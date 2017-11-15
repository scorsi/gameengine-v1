package com.scorsi.gameengine.utils

class Rectangle2D {

    Position2D origin
    Position2D size

    Rectangle2D() {
        origin = new Position2D(0, 0)
        size = new Position2D(0, 0)
    }

    Rectangle2D(Double x, Double y, Double width, Double height) {
        origin = new Position2D(x, y)
        size = new Position2D(width, height)
    }

    Rectangle2D(Position2D origin, Position2D size) {
        this.origin = origin
        this.size = size
    }

}
