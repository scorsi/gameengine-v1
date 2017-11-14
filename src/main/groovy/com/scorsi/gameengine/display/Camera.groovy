package com.scorsi.gameengine.display

import com.scorsi.gameengine.Game
import com.scorsi.gameengine.entities.Entity
import com.scorsi.gameengine.utils.Position2D

class Camera {

    protected Game game
    Position2D offset

    Camera(Game game) {
        this.game = game
        this.offset = new Position2D()
    }

    Camera(Game game, Double xOffset, Double yOffset) {
        this.game = game
        this.offset = new Position2D(xOffset, yOffset)
    }

    Camera(Game game, Position2D offset) {
        this.game = game
        this.offset = offset
    }

    void move(Double xAmt, Double yAmt) {
        this.offset.x += xAmt
        this.offset.y += yAmt
    }

    void move(Position2D amt) {
        this.offset.x += amt.x
        this.offset.y += amt.y
    }

    void centerOnEntity(Entity entity) {
        offset.x = entity.position.x - game.display.width / 2 + entity.width / 2
        offset.y = entity.position.y - game.display.height / 2 + entity.height / 2
    }

}
