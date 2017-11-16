package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Handler

import java.awt.Graphics

class EntityManager {

    private Handler handler

    /**
     * List of registered entities
     */
    private ArrayList<Entity> entities

    /**
     * List of entities waiting of deletion
     */
    private ArrayList<Entity> entitiesToRemove

    /**
     * The Entity Sorter
     */
    private Comparator<Entity> renderSorter = new EntityRenderSorter()

    EntityManager(Handler handler) {
        this.handler = handler
        this.entities = new ArrayList<>()
        this.entitiesToRemove = new ArrayList<>()
    }

    void update() {
        for (def entity : entities) {
            if (!entity.isEnabled) continue
            if (entity instanceof Updatable)
                entity.update()
        }

        // Execute all waiting entity deletion
        purgeEntitiesToRemove()

        // Sort entities by Y-axis
        entities.sort(renderSorter)
    }

    void render(Graphics g) {
        for (def entity : entities) {
            if (!entity.isEnabled) continue
            if (entity instanceof Visible)
                entity.render(g)
        }
    }

    void registerEntity(Entity entity) {
        entities.add(entity)
    }

    void deleteEntity(Entity entity) {
        entitiesToRemove.add(entity)
    }

    private void purgeEntitiesToRemove() {
        for (def entity : entitiesToRemove) {
            entities.remove(entity)
        }
        entitiesToRemove.clear()
    }

    ArrayList<Entity> getEntities() {
        return entities
    }
}
