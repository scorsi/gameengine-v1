package com.scorsi.example.states

import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.states.State
import com.scorsi.gameengine.states.StateManager

import java.awt.Graphics

class MenuState extends State {

    MenuState(Handler handler) {
        super(handler)
    }

    @Override
    void init() {
        def gameState = new GameState(handler)

        StateManager.currentState = gameState
        gameState.init()
    }

    @Override
    void update() {
    }

    @Override
    void render(Graphics g) {
    }
}
