package com.scorsi.gameengine.states

import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.EntityManager
import com.scorsi.gameengine.ui.UIManager

import java.awt.Graphics

abstract class State {

    private Handler handler
    private EntityManager entityManager
    private UIManager uiManager

    State(Handler handler) {
        this.handler = handler
        this.entityManager = new EntityManager(handler)
        this.uiManager = new UIManager(handler)
    }

    abstract void init()

    void lateUpdate() {
        entityManager.update()
        uiManager.update()
    }

    abstract void update()

    void lateRender(Graphics g) {
        entityManager.render(g)
        uiManager.render(g)
    }

    abstract void render(Graphics g)

    Handler getHandler() {
        return handler
    }

    EntityManager getEntityManager() {
        return entityManager
    }

    UIManager getUiManager() {
        return uiManager
    }
}
