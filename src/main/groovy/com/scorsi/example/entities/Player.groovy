package com.scorsi.example.entities

import com.scorsi.example.Assets
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.Collidable
import com.scorsi.gameengine.entities.Entity
import com.scorsi.gameengine.entities.Movable
import com.scorsi.gameengine.entities.Updatable
import com.scorsi.gameengine.entities.Visible
import com.scorsi.gameengine.graphics.Animation
import com.scorsi.gameengine.utils.Position2D
import com.scorsi.gameengine.utils.Rectangle2D

class Player extends Entity implements Collidable, Movable, Visible, Updatable {

    /**
     * All current animations
     */
    Animation downAnimation
    Animation upAnimation
    Animation leftAnimation
    Animation rightAnimation

    Player(Handler handler, Position2D position) {
        super(handler)
        this.position = position

        this.collisionBox = new Rectangle2D(16, 32, 32, 32)

        this.enableSolidTilesCollision = true
        this.enableEntityCollision = true

        // Initialize Animations
        downAnimation = new Animation(500, Assets.player_down)
        upAnimation = new Animation(500, Assets.player_up)
        leftAnimation = new Animation(500, Assets.player_left)
        rightAnimation = new Animation(500, Assets.player_right)

        image = downAnimation.currentFrame
    }

    @Override
    void update() {
        downAnimation.update()
        upAnimation.update()
        leftAnimation.update()
        rightAnimation.update()
        setCurrentAnimationFrame()

        resetMove()
        getInput()
        move()

        handler.camera.centerOnEntity(this)
    }

    private setCurrentAnimationFrame()
    {
        if (xMove < 0)
            image = leftAnimation.currentFrame
        else if (xMove > 0)
            image = rightAnimation.currentFrame
        else if (yMove < 0)
            image = upAnimation.currentFrame
        else if (yMove > 0)
            image = downAnimation.currentFrame
    }

    void getInput() {
        if (handler.keyManager.up)
            yMove = -speed
        if (handler.keyManager.down)
            yMove = speed
        if (handler.keyManager.left)
            xMove = -speed
        if (handler.keyManager.right)
            xMove = speed
    }

    /**
     * Call collision moveX instead of basic move method
     */
    @Override
    void moveX() {
        collisionMoveX(xMove, true)
    }

    /**
     * Call collision moveY instead of basic move method
     */
    @Override
    void moveY() {
        collisionMoveY(yMove, true)
    }
}
