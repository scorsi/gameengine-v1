package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Game
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

abstract class Entity {

    protected Game game
    protected Position2D position

    Entity(Game game, Position2D position) {
        this.game = game
        this.position = position
    }

    abstract void update()

    abstract void render(Graphics g)

    Position2D getPosition() {
        return position
    }

}
