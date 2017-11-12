package com.scorsi.example.entities

import com.scorsi.example.Assets
import com.scorsi.gameengine.Game
import com.scorsi.gameengine.entities.PlayableCharacter
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class Player extends PlayableCharacter {

    Player(Game game, Position2D pos) {
        super(game, pos)
    }

    @Override
    void update() {
        if (game.keyManager.up)
            position.y -= 3
        if (game.keyManager.down)
            position.y += 3
        if (game.keyManager.left)
            position.x -= 3
        if (game.keyManager.right)
            position.x += 3
    }

    @Override
    void render(Graphics g) {
        g.drawImage(Assets.player, position.x as Integer, position.y as Integer, null)
    }

}
