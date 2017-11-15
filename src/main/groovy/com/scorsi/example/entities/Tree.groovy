package com.scorsi.example.entities

import com.scorsi.example.Assets
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.Collidable
import com.scorsi.gameengine.entities.Entity
import com.scorsi.gameengine.entities.Texturable
import com.scorsi.gameengine.graphics.Tile
import com.scorsi.gameengine.utils.Position2D
import com.scorsi.gameengine.utils.Rectangle2D

class Tree extends Entity implements Texturable, Collidable {

    Tree(Handler handler, Position2D position) {
        super(handler)

        this.position = position

        this.enableEntityCollision = true

        this.image = Assets.tree

        this.width = Tile.TILE_WIDTH
        this.height = Tile.TILE_HEIGHT * 2

        this.collisionBox = new Rectangle2D(10, height / 1.5D, width - 20, height - height / 1.5D)
    }

}
