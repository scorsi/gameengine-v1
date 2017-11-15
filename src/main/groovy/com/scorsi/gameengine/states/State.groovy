package com.scorsi.gameengine.states

import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.EntityManager

import java.awt.Graphics

abstract class State {

    private Handler handler
    private EntityManager entityManager

    State(Handler handler) {
        this.handler = handler
        this.entityManager = new EntityManager(handler)
    }

    abstract void init()

    abstract void update()

    abstract void render(Graphics g)

    Handler getHandler() {
        return handler
    }

    EntityManager getEntityManager() {
        return entityManager
    }
}
