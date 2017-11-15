package com.scorsi.gameengine

import com.scorsi.gameengine.graphics.World

class Handler {

    private Game game
    World world

    Handler(Game game) {
        this.game = game
    }

    Game getGame() {
        return game
    }
}
