package com.scorsi.gameengine.entities

import groovy.transform.SelfType

@SelfType(Entity)
trait Damageable implements Collidable {

    static final Double DEFAULT_HEALTH = 100D
    static final Double DEFAULT_DAMAGE = 10D

    Boolean limitHealthToMax = true
    Double maxHealth = DEFAULT_HEALTH
    Double health = DEFAULT_HEALTH

    Double damage = DEFAULT_DAMAGE

    void doDamage(Damageable other) {
        other.takeDamage(damage)
    }

    void takeDamage(Double damage) {
        health -= damage
    }

    void recoverHealth(Double amount) {
        health += amount
        if (limitHealthToMax && health > maxHealth)
            health = this.maxHealth
    }

    void resetHealth() {
        health = this.maxHealth
    }

    Boolean isDead() {
        return health <= 0
    }

    Boolean isAlive() {
        return health > 0
    }
}