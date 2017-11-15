package com.scorsi.example.graphics.tiles

import com.scorsi.example.Assets
import com.scorsi.gameengine.graphics.Tile

class StoneTile extends Tile {

    StoneTile(Integer id) {
        super(Assets.stone, id)
        isSolid = true
    }

}
