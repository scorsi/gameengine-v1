package com.scorsi.gameengine.graphics

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

    void render(Graphics g, Integer x, Integer y) {
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null)
    }

}
