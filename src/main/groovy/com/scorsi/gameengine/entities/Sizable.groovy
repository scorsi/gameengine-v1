package com.scorsi.gameengine.entities

import com.scorsi.gameengine.utils.Position2D

trait Sizable {

    static final DEFAULT_WIDTH = 64
    static final DEFAULT_HEIGHT = 64

    Position2D size = new Position2D(DEFAULT_HEIGHT, DEFAULT_WIDTH)

    Double getWidth() {
        return size.x
    }

    Double getHeight() {
        return size.y
    }

    void setWidth(Double width) {
        size.x = width
    }

    void setHeight(Double height) {
        size.y = height
    }

}