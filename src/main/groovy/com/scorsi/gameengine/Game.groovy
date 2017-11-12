package com.scorsi.gameengine

import com.scorsi.gameengine.display.Display
import com.scorsi.gameengine.states.StateManager

import java.awt.Dimension
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
    protected Dimension dimension
    protected Integer height
    protected Integer width

    protected BufferStrategy bs
    protected Graphics g

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
        width = WIDTH as Integer
        height = HEIGHT as Integer
        dimension = new Dimension(width, height)
    }

    /**
     * Constructor with custom parameters
     *
     * @param name
     * @param cWidth
     * @param cHeight
     */
    Game(String name, Integer cWidth, Integer cHeight) {
        title = name
        width = cWidth
        height = cHeight
        dimension = new Dimension(width, height)
    }

    /**
     * Initialize the Game
     */
    private void beforeInit() {
        display = new Display(title, dimension.width as Integer, dimension.height as Integer)
    }

    /**
     * Initialize customs resources
     *
     * @throws Exception
     */
    abstract protected void init() throws Exception

    /**
     * Executed at each tick to update variables
     */
    protected void update() throws Exception {
        StateManager.getState().update()
    }

    /**
     * Executed before render method
     */
    private void beforeRender() throws Exception {
        // Get or create the BufferStrategy
        bs = display.getCanvas().getBufferStrategy()
        if (bs == null) {
            bs = display.getCanvas().createBufferStrategy(3)
            if (bs == null)
                throw new Exception("Unable to create the buffer strategy")
        }

        // Get Graphics
        g = bs.getDrawGraphics()

        // Clear screen
        g.clearRect(0, 0, dimension.width as Integer, dimension.height as Integer)
    }

    /**
     * Executed at each frame to update display
     */
    protected void render() throws Exception {
        // Call render of the actual state
        if (StateManager.getState() != null)
            StateManager.getState().render(g)
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
        } catch (ignored) {
            stop()
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
     * Getter for dimension
     *
     * @return
     */
    Dimension getDimension() {
        return dimension
    }

    /**
     * Getter for title
     *
     * @return
     */
    String getTitle() {
        return title
    }

    /**
     * Getter for display
     *
     * @return
     */
    Display getDisplay() {
        return display
    }
}
