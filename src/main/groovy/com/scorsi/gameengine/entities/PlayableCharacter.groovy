package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Game
import com.scorsi.gameengine.utils.Position2D

abstract class PlayableCharacter extends Character {

    PlayableCharacter(Game game, Position2D pos) {
        super(game, pos)
    }

}
