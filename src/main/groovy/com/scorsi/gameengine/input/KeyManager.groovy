package com.scorsi.gameengine.input

import com.sun.org.apache.xpath.internal.operations.Bool

import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.security.Key

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

    Boolean getUpArrow() {
        return keys[KeyEvent.VK_UP]
    }

    Boolean getDownArrow() {
        return keys[KeyEvent.VK_DOWN]
    }

    Boolean getLeftArrow() {
        return keys[KeyEvent.VK_LEFT]
    }

    Boolean getRightArrow() {
        return keys[KeyEvent.VK_RIGHT]
    }

    Boolean getAction1() {
        return keys[KeyEvent.VK_1]
    }

    Boolean getAction2() {
        return keys[KeyEvent.VK_2]
    }
}
