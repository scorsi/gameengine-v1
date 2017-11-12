package com.scorsi.example

import com.scorsi.example.states.GameState
import com.scorsi.gameengine.Game
import com.scorsi.gameengine.states.StateManager

class MyGame extends Game {

    @Override
    protected void init() throws Exception {
        StateManager.setState(new GameState())
        StateManager.getState().init()
    }

    @Override
    protected void update() throws Exception {
        super.update()
    }

    @Override
    protected void render() throws Exception {
        super.render()
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
