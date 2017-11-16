package com.scorsi.gameengine.entities

import com.scorsi.gameengine.graphics.Tile
import com.scorsi.gameengine.utils.Position2D
import com.scorsi.gameengine.utils.Rectangle2D
import groovy.transform.SelfType

@SelfType(Entity)
abstract trait Collidable implements Positionable, Sizable {

    /**
     * The box collision
     */
    Rectangle2D collisionBox = new Rectangle2D(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT)

    /**
     * Enable solid tiles check
     */
    Boolean enableSolidTilesCollision = false

    /**
     * Enable entity collision
     */
    Boolean enableEntityCollision = false

    /**
     * Check if we can move to the given distance along X-axis
     *
     * @param xMove
     * @param snapToTile
     * @return
     */
    void collisionMoveX(Double xMove, Boolean snapToTile = false) {
        if (enableEntityCollision && checkEntityCollision(xMove, 0))
            return

        if (!enableSolidTilesCollision)
            position.x += xMove
        else
            computeTilesCollisionMoveX(xMove, snapToTile)
    }

    /**
     * Check and compute the collision with tiles along the X-axis
     *
     * @param xMove
     * @param snapToTile
     */
    void computeTilesCollisionMoveX(Double xMove, Boolean snapToTile)
    {
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
        if (enableEntityCollision && checkEntityCollision(0, yMove))
            return

        if (!enableSolidTilesCollision)
            position.y += yMove
        else
            computeTilesCollisionMoveY(yMove, snapToTile)
    }

    /**
     * Check and compute the collision with tiles along the Y-axis
     *
     * @param yMove
     * @param snapToTile
     */
    void computeTilesCollisionMoveY(Double yMove, Boolean snapToTile) {
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
        Tile tile = handler.world.getTile(x, y)
        return tile ? tile.isSolid : false
    }

    /**
     * Check if this entity will collide with every other Collidable entity registered into the EntityManager
     *
     * @param xOffset
     * @param yOffset
     * @return
     */
    Boolean checkEntityCollision(Double xOffset, Double yOffset) {
        def offset = new Position2D(position.x + xOffset, position.y + yOffset)

        for (def entity : handler.entityManager.entities) {
            if (entity == this) continue

            if (entity instanceof Collidable && entity.enableEntityCollision) {
                if (entity.realCollisionBox.intersect(collisionBox.createNewWithOffset(offset))) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * Create and return a collisionBox based on the entity position
     *
     * @return
     */
    Rectangle2D getRealCollisionBox() {
        return collisionBox.createNewWithOffset(position)
    }
}