package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Game
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.utils.Position2D

abstract class Character extends Entity {

    static final DEFAULT_HEALTH = 100D
    static final DEFAULT_CREATURE_WIDTH = 64
    static final DEFAULT_CREATURE_HEIGHT = 64

    Double health = DEFAULT_HEALTH

    Character(Handler handler, Position2D pos) {
        super(handler, pos, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT)
    }

}
