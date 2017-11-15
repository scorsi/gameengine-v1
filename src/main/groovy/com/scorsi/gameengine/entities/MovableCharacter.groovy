package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.utils.Position2D

abstract class MovableCharacter extends Character {

    static final DEFAULT_SPEED = 3D

    Double speed = DEFAULT_SPEED

    Double xMove, yMove

    MovableCharacter(Handler handler, Position2D pos) {
        super(handler, pos)
    }

    void resetMove() {
        xMove = 0
        yMove = 0
    }

    void move() {
        position.x += xMove
        position.y += yMove
    }

}
