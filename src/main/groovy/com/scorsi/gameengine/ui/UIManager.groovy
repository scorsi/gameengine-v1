package com.scorsi.gameengine.ui

import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.input.Mouse

import java.awt.Graphics

class UIManager {

    private Handler handler
    private ArrayList<UIObject> objects

    UIManager(Handler handler) {
        this.handler = handler
        this.objects = new ArrayList<>()
    }

    void update() {
        for (def o : objects) {
            o.update()
        }
    }

    void render(Graphics g) {
        for (def o : objects) {
            o.render(g)
        }
    }

    void onMouseMove(Mouse mouse) {
        for (def o : objects) {
            o.onMouseMove(mouse)
        }
    }

    void onMouseRelease(Mouse mouse) {
        for (def o : objects) {
            o.onMouseRelease(mouse)
        }
    }

    void addObject(UIObject o) {
        objects.add(o)
    }

    void removeObject(UIObject o) {
        objects.remove(o)
    }
}
