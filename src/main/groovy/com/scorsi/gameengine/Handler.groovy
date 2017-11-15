package com.scorsi.gameengine

import com.scorsi.gameengine.display.Camera
import com.scorsi.gameengine.display.Display
import com.scorsi.gameengine.graphics.World
import com.scorsi.gameengine.input.KeyManager

class Handler {

    private Game game
    World world

    Handler(Game game) {
        this.game = game
    }

    Game getGame() {
        return game
    }

    Camera getCamera() {
        return game.camera
    }

    KeyManager getKeyManager() {
        return game.keyManager
    }

    Display getDisplay() {
        return game.display
    }
}
