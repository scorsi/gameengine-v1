package com.scorsi.gameengine.display

import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.Entity
import com.scorsi.gameengine.utils.Position2D

class Camera {

    protected Handler handler
    Position2D offset

    Camera(Handler handler) {
        this.handler = handler
        this.offset = new Position2D()
    }

    Camera(Handler handler, Double xOffset, Double yOffset) {
        this.handler = handler
        this.offset = new Position2D(xOffset, yOffset)
    }

    Camera(Handler handler, Position2D offset) {
        this.handler = handler
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
        offset.x = entity.position.x - handler.game.display.width / 2 + entity.width / 2
        offset.y = entity.position.y - handler.game.display.height / 2 + entity.height / 2
    }

}
