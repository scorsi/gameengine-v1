package com.scorsi.example.states

import com.scorsi.example.Assets
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.states.State
import com.scorsi.gameengine.states.StateManager
import com.scorsi.gameengine.ui.ClickListener
import com.scorsi.gameengine.ui.UIImageButton
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class MenuState extends State {

    MenuState(Handler handler) {
        super(handler)
    }

    @Override
    void init() {
        uiManager.addObject new UIImageButton(new Position2D(200, 200), new Position2D(128, 64), Assets.btn_start,
                new ClickListener() {
                    @Override
                    void onClick() {
                        switchToGameState()
                    }
        })
    }

    @Override
    void update() {
    }

    @Override
    void render(Graphics g) {
    }

    private void switchToGameState() {
        def gameState = new GameState(handler)

        StateManager.currentState = gameState
        gameState.init()
    }
}
