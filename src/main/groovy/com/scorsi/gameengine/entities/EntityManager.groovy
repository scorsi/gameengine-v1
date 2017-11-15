package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Handler

import java.awt.Graphics

class EntityManager {

    private Handler handler
    private ArrayList<Entity> entities

    EntityManager(Handler handler) {
        this.handler = handler
        this.entities = new ArrayList<>()
    }

    void update()
    {
        for (Integer i in 0 .. entities.size() - 1) {
            Entity entity = entities.get(i)
            if (entity instanceof Updatable)
                entity.update()
        }
    }

    void render(Graphics g)
    {
        for (Integer i in 0 .. entities.size() - 1) {
            Entity entity = entities.get(i)
            if (entity instanceof Visible)
                entity.render(g)
        }
    }

    void registerEntity(Entity entity)
    {
        entities.add(entity)
    }
}
