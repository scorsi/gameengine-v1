package com.scorsi.example.entities

import com.scorsi.example.Assets
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.Collidable
import com.scorsi.gameengine.entities.Entity
import com.scorsi.gameengine.entities.Movable
import com.scorsi.gameengine.entities.Updatable
import com.scorsi.gameengine.entities.Visible
import com.scorsi.gameengine.utils.Position2D
import com.scorsi.gameengine.utils.Rectangle2D

import java.awt.Graphics

class Player extends Entity implements Collidable, Movable, Visible, Updatable {

    Player(Handler handler, Position2D position) {
        super(handler)
        this.position = position

        this.collisionBox = new Rectangle2D(16, 32, 32, 32)
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

    /**
     * Call collision moveX instead of basic move method
     */
    @Override
    void moveX() {
        collisionMoveX(handler.world, xMove, true)
    }

    /**
     * Call collision moveY instead of basic move method
     */
    @Override
    void moveY() {
        collisionMoveY(handler.world, yMove, true)
    }
}
