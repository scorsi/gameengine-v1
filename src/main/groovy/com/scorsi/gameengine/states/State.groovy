package com.scorsi.gameengine.states

import com.scorsi.gameengine.Handler

import java.awt.Graphics

abstract class State {

    protected Handler handler

    State(Handler handler) {
        this.handler = handler
    }

    abstract void init()

    abstract void update()

    abstract void render(Graphics g)

}
