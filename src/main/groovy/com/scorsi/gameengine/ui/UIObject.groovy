package com.scorsi.gameengine.ui

import com.scorsi.gameengine.input.Mouse
import com.scorsi.gameengine.utils.Position2D
import com.scorsi.gameengine.utils.Rectangle2D

import java.awt.Graphics

abstract class UIObject {

    protected Boolean hovering = false
    protected Rectangle2D bounds

    UIObject(Position2D position, Position2D size) {
        this.bounds = new Rectangle2D(position, size)
    }

    abstract void update()

    abstract void render(Graphics g)

    abstract void onClick()

    void onMouseMove(Mouse mouse) {
        if (bounds.contains(mouse.position))
            hovering = true
        else
            hovering = false
    }

    void onMouseRelease(Mouse mouse) {
        if (hovering)
            onClick()
    }

    Position2D getOrigin() {
        return bounds.origin
    }

    Double getWidth() {
        return bounds.size.x
    }

    Double getHeight() {
        return bounds.size.y
    }
}
