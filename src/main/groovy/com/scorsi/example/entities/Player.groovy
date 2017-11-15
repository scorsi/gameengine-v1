package com.scorsi.example.entities

import com.scorsi.example.Assets
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.Collidable
import com.scorsi.gameengine.entities.Entity
import com.scorsi.gameengine.entities.LookAt
import com.scorsi.gameengine.entities.Movable
import com.scorsi.gameengine.entities.Updatable
import com.scorsi.gameengine.entities.Visible
import com.scorsi.gameengine.graphics.Animation
import com.scorsi.gameengine.utils.Position2D
import com.scorsi.gameengine.utils.Rectangle2D

class Player extends Entity implements Collidable, Movable, Visible, Updatable {

    private LookAt lookAt

    /**
     * All current animations
     */
    HashMap<LookAt, Animation> animations

    Player(Handler handler, Position2D position) {
        super(handler)
        this.position = position

        this.collisionBox = new Rectangle2D(16, 32, 32, 32)

        this.enableSolidTilesCollision = true
        this.enableEntityCollision = true

        // Initialize Animations
        animations = new HashMap<>()
        animations[LookAt.Down] = new Animation(500, Assets.player_down)
        animations[LookAt.Up] = new Animation(500, Assets.player_up)
        animations[LookAt.Left] = new Animation(500, Assets.player_left)
        animations[LookAt.Right] = new Animation(500, Assets.player_right)
        lookAt = LookAt.Down
    }

    @Override
    void update() {
        for (def animation : animations)
            animation.value.update()

        determineLookAt()
        image = animations[lookAt].currentFrame

        resetMove()
        getInput()
        move()

        handler.camera.centerOnEntity(this)
    }

    private determineLookAt()
    {
        if (xMove < 0)
            lookAt = LookAt.Left
        else if (xMove > 0)
            lookAt = LookAt.Right
        else if (yMove < 0)
            lookAt = LookAt.Up
        else if (yMove > 0)
            lookAt = LookAt.Down
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
