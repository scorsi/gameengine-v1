package com.scorsi.gameengine.entities

import java.awt.Graphics
import java.awt.image.BufferedImage

trait Visible implements Positionable {

    static final DEFAULT_WIDTH = 64
    static final DEFAULT_HEIGHT = 64

    BufferedImage image

    Integer width = DEFAULT_WIDTH
    Integer height = DEFAULT_HEIGHT

    void render(Graphics g) {
        g.drawImage(image, position.x as Integer, position.y as Integer, width, height, null)
    }

}