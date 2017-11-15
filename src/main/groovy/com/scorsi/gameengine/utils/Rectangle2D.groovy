package com.scorsi.gameengine.utils

import java.awt.Rectangle

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

    Rectangle2D createNewWithOffset(Position2D offset) {
        return new Rectangle2D(new Position2D(this.origin.x + offset.x, this.origin.y + offset.y), size)
    }

    Boolean intersect(Rectangle2D other) {
        Double tw = this.size.x
        Double th = this.size.y
        Double rw = other.size.x
        Double rh = other.size.y

        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false
        }

        Double tx = this.origin.x
        Double ty = this.origin.y
        Double rx = other.origin.x
        Double ry = other.origin.y

        rw += rx
        rh += ry
        tw += tx
        th += ty

        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry))
    }

}
