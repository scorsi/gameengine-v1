package com.scorsi.gameengine

import com.scorsi.gameengine.display.Camera
import com.scorsi.gameengine.display.Display
import com.scorsi.gameengine.input.KeyManager
import com.scorsi.gameengine.input.MouseManager
import com.scorsi.gameengine.states.StateManager

import java.awt.Graphics
import java.awt.image.BufferStrategy

abstract class Game implements Runnable {

    /**
     * Default configuration
     *
     * The height is automatically set to 12 / 9 ration
     */
    static final WIDTH = 1024
    static final HEIGHT = WIDTH / 12 * 9
    static final NAME = "Game"
    static final FPS = 60D

    /**
     * The Display of the game
     */
    private Display display
    protected String title

    protected BufferStrategy bs
    protected Graphics g

    /**
     * Inputs
     */
    private KeyManager keyManager
    private MouseManager mouseManager

    /**
     * Camera
     */
    private Camera camera

    /**
     * Handler
     */
    private Handler handler

    /**
     * Threads
     */
    private Thread thread
    private Boolean running = false

    /**
     * Constructor with default parameters
     */
    Game() {
        title = NAME
        display = new Display(title, WIDTH as Integer, HEIGHT as Integer)
    }

    /**
     * Constructor with custom parameters
     *
     * @param name
     * @param width
     * @param height
     */
    Game(String name, Integer width, Integer height) {
        title = name
        display = new Display(name, width, height)
    }

    /**
     * Initialize the Game
     */
    private void beforeInit() {
        keyManager = new KeyManager()
        mouseManager = new MouseManager()
        display.frame.addKeyListener(keyManager)
        display.registerMouseManager(mouseManager)
        handler = new Handler(this)
        camera = new Camera(handler)
    }

    /**
     * Initialize customs resources
     *
     * @throws Exception
     */
    abstract protected void init() throws Exception

    /**
     * Executed before update method
     */
    private void beforeUpdate() throws Exception {
        // Call update of the actual state
        if (StateManager.currentState != null)
            StateManager.currentState.update()
    }

    /**
     * Executed at each tick to update variables
     */
    protected void update() throws Exception {
    }

    /**
     * Executed before render method
     */
    private void beforeRender() throws Exception {
        // Get or create the BufferStrategy
        bs = display.getCanvas().getBufferStrategy()
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3)
            bs = display.getCanvas().getBufferStrategy()
            if (bs == null)
                throw new Exception("Unable to create the buffer strategy")
        }

        // Get Graphics
        g = bs.getDrawGraphics()

        // Clear screen
        g.clearRect(0, 0, display.width, display.height)

        // Call render of the actual state
        if (StateManager.currentState != null)
            StateManager.currentState.render(g)
    }

    /**
     * Executed at each frame to update display
     */
    protected void render() throws Exception {
    }

    /**
     * Executed before render method
     */
    private void afterRender() throws Exception {
        // Display on the screen
        bs.show()
        g.dispose()
    }

    /**
     * Game loop
     */
    void run() {

        // Initialize the engine
        try {
            beforeInit()
            init()
        } catch (Exception e) {
            e.printStackTrace()
            running = false
            return
        }

        Double timePerTick = 1000000000 / FPS
        Double delta = 0

        Long now
        Long lastTime = System.nanoTime()

        // Used for the FPS counter
        Long timer = 0
        Integer ticks = 0

        // The game loop
        while (running) {
            now = System.nanoTime()
            delta += (now - lastTime) / timePerTick
            timer += now - lastTime
            lastTime = now

            if (delta >= 1) {
                // Update
                try {
                    beforeUpdate()
                    update()
                } catch (Exception e) {
                    e.printStackTrace()
                }

                // Render
                try {
                    beforeRender()
                    render()
                    afterRender()
                } catch (Exception e) {
                    e.printStackTrace()
                }

                delta--
                ticks++
            }

            // Display the FPS Counter
            if (timer >= 1000000000) {
                System.out.println("FPS Counter: " + ticks)
                ticks = 0
                timer = 0
            }
        }

        stop()
    }

    /**
     * Start a new thread
     */
    synchronized void start() {
        if (running) return // Stop if the thread is already started

        thread = new Thread(this)

        running = true
        thread.start()
    }

    /**
     * Stop safely the thread
     */
    synchronized void stop() {
        if (!running) return // Stop if the thread is not started

        running = false
        try {
            thread.join()
        } catch (InterruptedException e) {
            e.printStackTrace()
        }
    }

    /**
     * Getter for display
     *
     * @return
     */
    Display getDisplay() {
        return display
    }

    /**
     * Getter for keyManager
     *
     * @return
     */
    KeyManager getKeyManager() {
        return keyManager
    }

    /**
     * Getter for mouseManager
     *
     * @return
     */
    MouseManager getMouseManager() {
        return mouseManager
    }

    /**
     * Getter for camera
     *
     * @return
     */
    Camera getCamera() {
        return camera
    }

    /**
     * Getter for handler
     *
     * @return
     */
    Handler getHandler() {
        return handler
    }
}
