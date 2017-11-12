package com.scorsi.gameengine

import com.scorsi.gameengine.display.Display

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

    /**
     * The Display of the game
     */
    private Display display
    private String title
    private Dimension dimension

    private BufferStrategy bs
    private Graphics g

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
        dimension = new Dimension(WIDTH as Integer, HEIGHT as Integer)
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
        dimension = new Dimension(width, height)
    }

    /**
     * Initialize the Game
     */
    private void beforeInit() {
        display = new Display(title, dimension.width as Integer, dimension.height as Integer)
    }

    abstract protected void init() throws Exception

    /**
     * Executed before update method
     */
    private void beforeUpdate() throws Exception {
    }

    /**
     * Executed at each tick to update variables
     */
    abstract protected void update() throws Exception

    /**
     * Executed after update method
     */
    private void afterUpdate() throws Exception {
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
    abstract protected void render() throws Exception

    /**
     * Executed before render method
     */
    private void afterRender() throws Exception {
        bs.show()
        g.dispose()
    }

    /**
     * Game loop
     */
    void run() {

        try {
            beforeInit()
            init()
        } catch (Exception e) {
            stop()
            return
        }

        while (running) {
            // Update
            try {
                beforeUpdate()
                update()
                afterUpdate()
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
