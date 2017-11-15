package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

abstract class Entity {

    protected Handler handler
    Position2D position
    Integer width
    Integer height

    Entity(Handler handler, Position2D position, Integer width, Integer height) {
        this.handler = handler
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
