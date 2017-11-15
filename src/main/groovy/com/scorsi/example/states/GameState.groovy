package com.scorsi.example.states

import com.scorsi.example.entities.Player
import com.scorsi.example.graphics.tiles.DirtTile
import com.scorsi.example.graphics.tiles.GrassTile
import com.scorsi.example.graphics.tiles.StoneTile
import com.scorsi.gameengine.Handler
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

    GameState(Handler handler) {
        super(handler)
    }

    @Override
    void init() {
        player = new Player(handler, new Position2D(100, 100))
        grassTile = new GrassTile(0)
        dirtTile = new DirtTile(1)
        stoneTile = new StoneTile(2)
        world = new World(handler, "/worlds/world2.txt")
        handler.world = world
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
