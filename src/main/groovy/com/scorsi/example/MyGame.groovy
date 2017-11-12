package com.scorsi.example

import com.scorsi.example.states.GameState
import com.scorsi.gameengine.Game
import com.scorsi.gameengine.states.StateManager

class MyGame extends Game {

    private GameState gameState

    MyGame() {
        super()
    }

    @Override
    protected void init() throws Exception {
        Assets.init()
        gameState = new GameState(this)
        StateManager.setState(gameState)
        gameState.init()
    }

    @Override
    protected void update() throws Exception {
    }

    @Override
    protected void render() throws Exception {
    }

    /**
     * Main which create and launch the Display
     *
     * @param args
     */
    static void main(String[] args) {
        def game = new MyGame()

        game.start()
    }

}
