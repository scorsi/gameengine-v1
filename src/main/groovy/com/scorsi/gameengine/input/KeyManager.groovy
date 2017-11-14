package com.scorsi.gameengine.input

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KeyManager implements KeyListener {

    ArrayList<Boolean> keys

    /**
     * Should be removed in the future
     */
    Boolean up, down, left, right

    KeyManager() {
        keys = new ArrayList<>()
    }

    void update() {
        up = keys[KeyEvent.VK_Z]
        down = keys[KeyEvent.VK_S]
        left = keys[KeyEvent.VK_Q]
        right = keys[KeyEvent.VK_D]
    }

    @Override
    void keyTyped(KeyEvent e) {
    }

    @Override
    void keyPressed(KeyEvent e) {
        keys[e.keyCode] = true
    }

    @Override
    void keyReleased(KeyEvent e) {
        keys[e.keyCode] = false
    }

}
