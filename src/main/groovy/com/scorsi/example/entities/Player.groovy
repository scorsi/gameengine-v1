package com.scorsi.example.entities

import com.scorsi.example.Assets
import com.scorsi.gameengine.Game
import com.scorsi.gameengine.entities.MovableCharacter
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class Player extends MovableCharacter {

    Player(Game game, Position2D pos) {
        super(game, pos)
    }

    @Override
    void update() {
        getInput()
        move()

        game.camera.centerOnEntity(this)
    }

    void getInput() {
        resetMove()

        if (game.keyManager.up)
            yMove = -speed
        if (game.keyManager.down)
            yMove = speed
        if (game.keyManager.left)
            xMove = -speed
        if (game.keyManager.right)
            xMove = speed
    }

    @Override
    void render(Graphics g) {
        g.drawImage(Assets.player,
                (position.x - game.camera.offset.x) as Integer,
                (position.y - game.camera.offset.y) as Integer,
                width, height, null)
    }

}
