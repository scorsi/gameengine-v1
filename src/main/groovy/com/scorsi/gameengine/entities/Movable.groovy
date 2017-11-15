package com.scorsi.gameengine.entities

abstract trait Movable implements Positionable {

    static final DEFAULT_SPEED = 3D

    /**
     * Multiplier for move distance
     */
    Double speed = DEFAULT_SPEED

    /**
     * Pixels to move
     */
    Double xMove = 0
    Double yMove = 0

    /**
     * Should be called from update method of the Entity
     */
    void move() {
        moveX()
        moveY()
    }

    /**
     * Move the entity along the X axis
     *
     * Can be used to check collision in case of Collidable object
     */
    void moveX() {
        position.x += xMove
    }

    /**
     * Move the entity along the Y axis
     *
     * Can be used to check collision in case of Collidable object
     */
    void moveY() {
        position.y += yMove
    }

    /**
     * Reset the move variable
     */
    void resetMove() {
        xMove = 0
        yMove = 0
    }

}