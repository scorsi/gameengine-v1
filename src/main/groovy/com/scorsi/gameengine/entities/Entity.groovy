package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Handler

abstract class Entity {

    protected Handler handler

    Entity(Handler handler) {
        this.handler = handler
    }

}
