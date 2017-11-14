package com.scorsi.gameengine.display

import javax.swing.JFrame
import java.awt.Canvas
import java.awt.Dimension

class Display {

    /**
     * Configuration
     */
    private String name
    private Integer width
    private Integer height

    /**
     * The window
     */
    private JFrame frame
    private Canvas canvas

    /**
     * Constructor.
     *
     * @param name the name of the window
     * @param width the width of the window
     * @param height the height of the window
     */
    Display(String name, Integer width, Integer height) {
        this.name = name
        this.width = width
        this.height = height

        createDisplay()
        createCanvas()
    }

    /**
     * Create, initialize and show the jFrame
     */
    private void createDisplay() {
        frame = new JFrame(name)
        frame.setSize(width, height)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setResizable(false)
        frame.setLocationRelativeTo(null)
        frame.setVisible(true)
    }

    /**
     * Create, initialize and register the canvas to the frame
     */
    private void createCanvas() {
        if (frame == null)
            throw new Exception("The frame is not properly initialized")

        canvas = new Canvas()

        canvas.setMinimumSize(new Dimension(width, height))
        canvas.setMaximumSize(new Dimension(width, height))
        canvas.setPreferredSize(new Dimension(width, height))
        canvas.setFocusable(false)

        frame.add(canvas)
        frame.pack()
    }

    /**
     * Getter for canvas
     *
     * @return
     */
    Canvas getCanvas() {
        return canvas
    }

    /**
     * Getter for frame
     *
     * @return
     */
    JFrame getFrame() {
        return frame
    }

    String getName() {
        return name
    }

    Integer getWidth() {
        return width
    }

    Integer getHeight() {
        return height
    }
}
