package com.scorsi.gameengine.display

import javax.swing.JFrame
import java.awt.Canvas
import java.awt.Dimension

class Display {

    /**
     * Configuration
     */
    String name
    Integer width
    Integer height

    /**
     * The window
     */
    private JFrame frame
    private Canvas canvas

    /**
     * Constructor.
     *
     * @param cName the name of the window
     * @param cWidth the width of the window
     * @param cHeight the height of the window
     */
    Display(String cName, Integer cWidth, Integer cHeight) {
        name = cName
        width = cWidth
        height = cHeight

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
}
