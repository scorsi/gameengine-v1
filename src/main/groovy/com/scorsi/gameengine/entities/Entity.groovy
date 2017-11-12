package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Game
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

abstract class Entity {

    protected Game game
    Position2D position
    Integer width
    Integer height

    Entity(Game game, Position2D position, Integer width, Integer height) {
        this.game = game
        this.position = position
        this.width = width
        this.height = height
    }

    abstract void update()

    abstract void render(Graphics g)

    Position2D getPosition() {
        return position
    }

}
