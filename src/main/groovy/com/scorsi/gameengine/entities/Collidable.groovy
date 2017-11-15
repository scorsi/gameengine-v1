package com.scorsi.gameengine.entities

import com.scorsi.gameengine.graphics.Tile
import com.scorsi.gameengine.utils.Rectangle2D
import groovy.transform.SelfType

@SelfType(Entity)
abstract trait Collidable implements Positionable, Sizable, Updatable {

    /**
     * The box collision
     */
    Rectangle2D collisionBox = new Rectangle2D(0, 0, width, height)

    /**
     * Enable solid tiles check
     */
    Boolean enableSolidTilesCollision = true

    /**
     * Check if we can move to the given distance along X-axis
     *
     * @param xMove
     * @param snapToTile
     * @return
     */
    void collisionMoveX(Double xMove, Boolean snapToTile = false) {
        Double newPositionX = position.x + xMove
        if (xMove > 0) {
            Integer tx = (newPositionX + collisionBox.origin.x + collisionBox.size.x) / Tile.TILE_WIDTH

            if (collisionWithTile(tx, ((position.y + collisionBox.origin.y) / Tile.TILE_HEIGHT) as Integer) ||
                    collisionWithTile(tx, ((position.y + collisionBox.origin.y + collisionBox.size.y) / Tile.TILE_WIDTH) as Integer)) {
                position.x = tx * Tile.TILE_WIDTH - collisionBox.origin.x - collisionBox.size.x - 1
                return
            }
        } else if (xMove < 0) {
            Integer tx = (newPositionX + collisionBox.origin.x) / Tile.TILE_WIDTH

            if (collisionWithTile(tx, ((position.y + collisionBox.origin.y) / Tile.TILE_HEIGHT) as Integer) ||
                    collisionWithTile(tx, ((position.y + collisionBox.origin.y + collisionBox.size.y) / Tile.TILE_WIDTH) as Integer)) {
                position.x = (tx + 1) * Tile.TILE_WIDTH - collisionBox.origin.x
                return
            }
        }
        position.x = newPositionX
    }

    /**
     * Check if we can move to the given distance along Y-axis
     *
     * @param yMove
     * @param snapToTile
     * @return
     */
    void collisionMoveY(Double yMove, Boolean snapToTile = false) {
        Double newPositionY = position.y + yMove
        if (yMove > 0) {
            Integer ty = ((newPositionY + collisionBox.origin.y + collisionBox.size.y) as Integer) / Tile.TILE_HEIGHT

            if (collisionWithTile(((position.x + collisionBox.origin.x) / Tile.TILE_WIDTH) as Integer, ty) ||
                    collisionWithTile(((position.x + collisionBox.origin.x + collisionBox.size.x) / Tile.TILE_HEIGHT) as Integer, ty)) {
                position.y = ty * Tile.TILE_HEIGHT - collisionBox.origin.y - collisionBox.size.y - 1
                return
            }
        } else if (yMove < 0) {
            Integer ty = (newPositionY + collisionBox.origin.y) / Tile.TILE_HEIGHT

            if (collisionWithTile(((position.x + collisionBox.origin.x) / Tile.TILE_WIDTH) as Integer, ty) ||
                    collisionWithTile(((position.x + collisionBox.origin.x + collisionBox.size.x) / Tile.TILE_HEIGHT) as Integer, ty)) {
                position.y = (ty + 1) * Tile.TILE_HEIGHT - collisionBox.origin.y
                return
            }
        }
        position.y = newPositionY
    }

    /**
     * Check if there is a collision at the given position
     *
     * @param x
     * @param y
     * @return
     */
    Boolean collisionWithTile(Integer x, Integer y) {
        if (!enableSolidTilesCollision) return false
        Tile tile = handler.world.getTile(x, y)
        return tile ? tile.isSolid : false
    }

}