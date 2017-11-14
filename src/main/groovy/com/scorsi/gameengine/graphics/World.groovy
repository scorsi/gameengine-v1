package com.scorsi.gameengine.graphics

import com.scorsi.gameengine.Game
import com.scorsi.gameengine.utils.FileLoader
import com.scorsi.gameengine.utils.Parser
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class World {

    protected Game game
    Position2D screenPosition
    Integer height
    Integer width
    Integer spawnX
    Integer spawnY

    Integer[][] tiles

    World(Game game, String path) {
        this.game = game
        this.screenPosition = new Position2D(0, 0)
        loadWorld(path)
    }

    World(Game game, String path, Position2D screenPosition) {
        this.game = game
        this.screenPosition = screenPosition
        loadWorld(path)
    }

    void update() {
        screenPosition = game.camera.offset
    }

    void render(Graphics g) {
        for (Integer y in 0 .. height - 1) {
            for (Integer x in 0 .. width - 1) {
                def realPos = new Position2D(
                        x * Tile.TILE_WIDTH - screenPosition.x,
                        y * Tile.TILE_HEIGHT - screenPosition.y)

                getTile(new Position2D(x, y)).render(g, realPos)
            }
        }
    }

    Tile getTile(Position2D pos) {
        if (pos.x > width || pos.x < 0 || pos.y > height || pos.y < 0) return null
        return Tile.tiles[tiles[pos.x as Integer][pos.y as Integer]]
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

}
