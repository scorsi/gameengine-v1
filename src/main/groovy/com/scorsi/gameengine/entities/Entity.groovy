package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Handler

abstract class Entity {

    Boolean isEnabled
    protected Handler handler

    Entity(Handler handler) {
        this.handler = handler
        this.isEnabled = true
    }

    void enable() {
        isEnabled = true
    }

    void disable() {
        isEnabled = false
    }
}
