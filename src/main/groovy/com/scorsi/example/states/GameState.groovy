package com.scorsi.example.states

import com.scorsi.example.entities.Player
import com.scorsi.example.graphics.tiles.DirtTile
import com.scorsi.example.graphics.tiles.GrassTile
import com.scorsi.example.graphics.tiles.StoneTile
import com.scorsi.gameengine.Game
import com.scorsi.gameengine.graphics.Tile
import com.scorsi.gameengine.graphics.World
import com.scorsi.gameengine.states.State
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class GameState extends State {

    World world
    Player player

    Tile dirtTile
    Tile grassTile
    Tile stoneTile

    GameState(Game game) {
        super(game)

        game.camera.move(new Position2D(100, 100))
    }

    @Override
    void init() {
        player = new Player(game, new Position2D(100, 100))
        grassTile = new GrassTile(0)
        dirtTile = new DirtTile(1)
        stoneTile = new StoneTile(2)
        world = new World(game, "/worlds/world2.txt")
    }

    @Override
    void update() {
        world.update()
        player.update()
    }

    @Override
    void render(Graphics g) {
        world.render(g)
        player.render(g)
    }

}
