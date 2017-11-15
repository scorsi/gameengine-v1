package com.scorsi.example.entities

import com.scorsi.example.Assets
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.Entity
import com.scorsi.gameengine.entities.Visible
import com.scorsi.gameengine.graphics.Tile
import com.scorsi.gameengine.utils.Position2D

class Tree extends Entity implements Visible {

    Tree(Handler handler, Position2D position) {
        super(handler)

        this.position = position

        image = Assets.tree

        width = Tile.TILE_WIDTH
        height = Tile.TILE_HEIGHT * 2
    }

}
