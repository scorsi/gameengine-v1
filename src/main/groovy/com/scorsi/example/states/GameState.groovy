package com.scorsi.example.states

import com.scorsi.example.entities.Player
import com.scorsi.example.graphics.tiles.DirtTile
import com.scorsi.example.graphics.tiles.GrassTile
import com.scorsi.gameengine.Game
import com.scorsi.gameengine.graphics.Tile
import com.scorsi.gameengine.states.State
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class GameState extends State {

    Player player
    Tile dirtTile
    Tile grassTile

    GameState(Game game) {
        super(game)
    }

    @Override
    void init() {
        player = new Player(game, new Position2D(100, 100))
        grassTile = new GrassTile(0)
        dirtTile = new DirtTile(1)
    }

    @Override
    void update() {
        player.update()
    }

    @Override
    void render(Graphics g) {
        Tile.tiles[0].render(g, 0, 0)
        player.render(g)
    }

}
