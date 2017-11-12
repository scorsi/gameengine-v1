package com.scorsi.gameengine.states

import java.awt.Graphics

abstract class State {

    abstract void init()

    abstract void update()

    abstract void render(Graphics g)

}
