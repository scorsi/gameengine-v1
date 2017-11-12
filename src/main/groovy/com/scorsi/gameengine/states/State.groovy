package com.scorsi.gameengine.states

import com.scorsi.gameengine.Game

import java.awt.Graphics

abstract class State {

    protected Game game

    State(Game game) {
        this.game = game
    }

    abstract void init()

    abstract void update()

    abstract void render(Graphics g)

}
