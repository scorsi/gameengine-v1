package com.scorsi.gameengine.display

import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.Entity
import com.scorsi.gameengine.entities.Positionable
import com.scorsi.gameengine.entities.Sizable
import com.scorsi.gameengine.graphics.Tile
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

        checkBlankSpace()
    }

    void move(Position2D amt) {
        this.offset.x += amt.x
        this.offset.y += amt.y

        checkBlankSpace()
    }

    /**
     * Check for blank screen around the world
     */
    void checkBlankSpace() {
        if (offset.x < 0)
            offset.x = 0
        else if (offset.x > handler.world.width * Tile.TILE_WIDTH - handler.display.width)
            offset.x = handler.world.width * Tile.TILE_WIDTH - handler.display.width

        if (offset.y < 0)
            offset.y = 0
        else if (offset.y > handler.world.height* Tile.TILE_HEIGHT - handler.display.height)
            offset.y = handler.world.height * Tile.TILE_HEIGHT- handler.display.height
    }

    /**
     * Center the camera on the given positionable entity
     * Check if it is Sizable to center the camera to the entity center
     *
     * @param entity
     */
    void centerOnEntity(Positionable entity) {
        if (entity instanceof Sizable)
        {
            offset.x = entity.position.x - handler.game.display.width / 2 + entity.width / 2
            offset.y = entity.position.y - handler.game.display.height / 2 + entity.height / 2
        }
        else
        {
            offset.x = entity.position.x - handler.game.display.width / 2
            offset.y = entity.position.y - handler.game.display.height / 2
        }

        checkBlankSpace()
    }

}
