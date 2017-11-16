package com.scorsi.gameengine

import com.scorsi.gameengine.display.Camera
import com.scorsi.gameengine.display.Display
import com.scorsi.gameengine.entities.Entity
import com.scorsi.gameengine.entities.EntityManager
import com.scorsi.gameengine.graphics.World
import com.scorsi.gameengine.input.KeyManager
import com.scorsi.gameengine.states.State
import com.scorsi.gameengine.states.StateManager
import com.scorsi.gameengine.ui.UIManager

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

    EntityManager getEntityManager() {
        if (StateManager.currentState == null) return null
        return StateManager.currentState.entityManager
    }

    UIManager getUiManager() {
        if (StateManager.currentState == null) return null
        return StateManager.currentState.uiManager
    }
}
