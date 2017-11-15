package com.scorsi.example.entities

import com.scorsi.example.Assets
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.MovableCharacter
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class Player extends MovableCharacter {

    Player(Handler handler, Position2D pos) {
        super(handler, pos)
    }

    @Override
    void update() {
        getInput()
        move()

        handler.game.camera.centerOnEntity(this)
    }

    void getInput() {
        resetMove()

        if (handler.game.keyManager.up)
            yMove = -speed
        if (handler.game.keyManager.down)
            yMove = speed
        if (handler.game.keyManager.left)
            xMove = -speed
        if (handler.game.keyManager.right)
            xMove = speed
    }

    @Override
    void render(Graphics g) {
        g.drawImage(Assets.player,
                (position.x - handler.game.camera.offset.x) as Integer,
                (position.y - handler.game.camera.offset.y) as Integer,
                width, height, null)
    }

}
