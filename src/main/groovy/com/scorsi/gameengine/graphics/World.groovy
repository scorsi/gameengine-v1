package com.scorsi.gameengine.graphics

import com.scorsi.gameengine.Game
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.utils.FileLoader
import com.scorsi.gameengine.utils.Parser
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class World {

    protected Handler handler

    protected Integer width
    protected Integer height

    Integer spawnX
    Integer spawnY

    protected Integer[][] tiles

    World(Handler handler, String path) {
        this.handler = handler
        loadWorld(path)
    }

    void update() {
    }

    void render(Graphics g) {
        Integer xStart = Math.max(0, handler.camera.offset.x / Tile.TILE_WIDTH) as Integer
        Integer xEnd = Math.min(width, (handler.camera.offset.x + handler.display.width) / Tile.TILE_WIDTH + 1) as Integer

        Integer yStart = Math.max(0, handler.camera.offset.y / Tile.TILE_HEIGHT) as Integer
        Integer yEnd = Math.min(height, (handler.camera.offset.y + handler.display.height) / Tile.TILE_HEIGHT + 1) as Integer

        for (Integer y in yStart .. yEnd - 1) {
            for (Integer x in xStart .. xEnd - 1) {
                def realPos = new Position2D(
                        x * Tile.TILE_WIDTH - handler.camera.offset.x,
                        y * Tile.TILE_HEIGHT - handler.camera.offset.y)

                Tile tile = getTile(x, y)
                if (tile == null) continue
                tile.render(g, realPos)
            }
        }
    }

    Tile getTile(Integer x, Integer y) {
        if (x > width || x < 0 || y > height || y < 0) return null
        return Tile.tiles[tiles[x][y]]
    }

    private void loadWorld(String path) {
        String file = FileLoader.loadFileAsString(path)
        String[] tokens = file.split("\\s+")
        width = Parser.parseInt(tokens[0])
        height = Parser.parseInt(tokens[1])
        spawnX = Parser.parseInt(tokens[2])
        spawnY = Parser.parseInt(tokens[3])

        tiles = new Integer[width][height]
        for (Integer y in 0 .. height - 1) {
            for (Integer x in 0 .. width - 1) {
                tiles[x][y] = Parser.parseInt(tokens[(x + y * width) + 4])
            }
        }
    }

    Integer getHeight() {
        return height
    }

    Integer getWidth() {
        return width
    }
}
