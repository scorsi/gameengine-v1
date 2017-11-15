package com.scorsi.gameengine.ui

import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics
import java.awt.image.BufferedImage

class UIImageButton extends UIObject {

    protected BufferedImage[] images
    private ClickListener clicker

    UIImageButton(Position2D position, Position2D size, BufferedImage[] images, ClickListener clicker) {
        super(position, size)
        this.images = images
        this.clicker = clicker
    }

    @Override
    void update() {
    }

    @Override
    void render(Graphics g) {
        if (hovering)
            g.drawImage(images[1], origin.x as Integer, origin.y as Integer, width as Integer, height as Integer, null)
        else
            g.drawImage(images[0], origin.x as Integer, origin.y as Integer, width as Integer, height as Integer, null)
    }

    @Override
    void onClick() {
        clicker.onClick()
    }
}
