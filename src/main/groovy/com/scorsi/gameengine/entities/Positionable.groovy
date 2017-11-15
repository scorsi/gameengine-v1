package com.scorsi.gameengine.entities

import com.scorsi.gameengine.utils.Position2D
import groovy.transform.SelfType

@SelfType(Entity)
trait Positionable {

    Position2D position = new Position2D()

    void resetPosition() {
        position.x = 0
        position.y = 0
    }

}