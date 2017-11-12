package com.scorsi.example.states

import com.scorsi.example.entities.Player
import com.scorsi.gameengine.Game
import com.scorsi.gameengine.states.State
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class GameState extends State {

    Player player

    GameState(Game game) {
        super(game)
    }

    @Override
    void init() {
        player = new Player(game, new Position2D(100, 100))
    }

    @Override
    void update() {
        player.update()
    }

    @Override
    void render(Graphics g) {
        player.render(g)
    }

}
