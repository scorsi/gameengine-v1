package com.scorsi.gameengine.input

import com.scorsi.gameengine.utils.Position2D

import java.awt.event.MouseEvent

class Mouse {

    MouseEvent lastEvent
    Position2D position

    Mouse(MouseEvent event, Position2D position) {
        this.lastEvent = event
        this.position = position
    }

}
