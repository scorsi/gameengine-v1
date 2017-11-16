package com.scorsi.gameengine.entities

import com.scorsi.gameengine.Handler

abstract class Entity {

    /**
     * Serve to create a unique od
     */
    private static Integer nextID = 1

    /**
     * Unique id of this entity
     */
    final Integer id

    /**
     * Game handler
     */
    protected Handler handler

    /**
     * Serve to know if this entity has to be updated and rendered
     */
    Boolean isEnabled

    /**
     * Constructor
     *
     * @param handler
     */
    Entity(Handler handler) {
        this.handler = handler
        this.isEnabled = true

        // Set the unique ID
        this.id = nextID
        nextID += 1
    }

    /**
     * Safe delete of this entity
     */
    void delete() {
        isEnabled = false
        handler.entityManager.deleteEntity(this)
    }

    /**
     * Set isEnabled to true
     */
    void enable() {
        isEnabled = true
    }

    /**
     * Set isEnabled to false
     */
    void disable() {
        isEnabled = false
    }

    /**
     * Set the equals method
     *
     * @param obj
     * @return
     */
    @Override
    boolean equals(Object obj) {
        if (obj instanceof Entity)
            return obj.id == id
        return false
    }
}
