package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Game
import com.scorsi.gameengine.utils.Position2D

abstract class MovableCharacter extends Character {

    static final DEFAULT_SPEED = 3D

    Double speed = DEFAULT_SPEED

    Double xMove, yMove

    MovableCharacter(Game game, Position2D pos) {
        super(game, pos)
    }

    MovableCharacter(Game game, Position2D pos, Integer width, Integer height) {
        super(game, pos, width, height)
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
