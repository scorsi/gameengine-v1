package com.scorsi.gameengine.input

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KeyManager implements KeyListener {

    private ArrayList<Boolean> keys

    KeyManager() {
        keys = new ArrayList<>()
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

    ArrayList<Boolean> getKeys() {
        return keys
    }

    Boolean getUp() {
        return keys[KeyEvent.VK_Z]
    }

    Boolean getDown() {
        return keys[KeyEvent.VK_S]
    }

    Boolean getLeft() {
        return keys[KeyEvent.VK_Q]
    }

    Boolean getRight() {
        return keys[KeyEvent.VK_D]
    }
}
