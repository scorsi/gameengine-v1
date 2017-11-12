package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Game
import com.scorsi.gameengine.utils.Position2D

abstract class Character extends Entity {

    Double health

    Character(Game game, Position2D pos) {
        super(game, pos)
        health = 0
    }

}
