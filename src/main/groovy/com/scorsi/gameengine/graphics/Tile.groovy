package com.scorsi.gameengine.graphics

import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics
import java.awt.image.BufferedImage

class Tile {

    static ArrayList<Tile> tiles = new ArrayList<>()

    static final Integer TILE_WIDTH = 64
    static final Integer TILE_HEIGHT = 64

    protected BufferedImage texture
    protected Integer id

    Boolean isSolid

    Tile(BufferedImage texture, Integer id, Boolean isSolid = false) {
        this.texture = texture
        this.id = id
        this.isSolid = isSolid

        tiles[id] = this
    }

    void update() {

    }

    void render(Graphics g, Position2D position) {
        g.drawImage(texture, position.x as Integer, position.y as Integer, TILE_WIDTH, TILE_HEIGHT, null)
    }

}
