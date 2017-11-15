package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Handler

import java.awt.Graphics

class EntityManager {

    private Handler handler
    private ArrayList<Entity> entities
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        int compare(Entity o1, Entity o2) {
            Boolean o1Visible = o1 instanceof Visible
            Boolean o2Visible = o2 instanceof Visible
            if (!o1Visible && !o2Visible)
                return 0
            else if (!o1Visible)
                return 1
            else if (!o2Visible)
                return -1

            if (o1.position.y + o1.size.y < o2.position.y + o2.size.y)
                return -1
            return 1
        }
    }

    EntityManager(Handler handler) {
        this.handler = handler
        this.entities = new ArrayList<>()
    }

    void update()
    {
        for (def entity : entities) {
            if (entity instanceof Updatable)
                entity.update()
        }
        entities.sort(renderSorter)
    }

    void render(Graphics g)
    {
        for (def entity : entities) {
            if (entity instanceof Visible)
                entity.render(g)
        }
    }

    void registerEntity(Entity entity)
    {
        entities.add(entity)
    }

    ArrayList<Entity> getEntities() {
        return entities
    }
}
