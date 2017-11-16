package com.scorsi.gameengine.entities

import com.scorsi.gameengine.utils.Position2D
import com.scorsi.gameengine.utils.Rectangle2D
import groovy.transform.SelfType

@SelfType(Entity)
trait SimpleAttacker implements Damageable {

    Double attackZoneSize = 20D
    Long attackSpeed = 800

    private Long lastAttackTimer = System.currentTimeMillis()
    private Long attackTimer = attackSpeed

    /**
     * Check if we can attack depending of the attackSpeed
     *
     * @return
     */
    Boolean canAttack() {
        Long tmp = System.currentTimeMillis()
        attackTimer += tmp - lastAttackTimer
        lastAttackTimer = tmp

        return attackTimer >= attackSpeed
    }

    /**
     * Calculate attack direction thanks to LookAt enum and perform the attack system
     */
    void attack(LookAt lookAt) {
        switch (lookAt) {
            case LookAt.Up:
                attackUp()
                break
            case LookAt.Down:
                attackDown()
                break
            case LookAt.Left:
                attackLeft()
                break
            case LookAt.Right:
                attackRight()
                break
        }
    }

    /**
     * Perform the attack system from up
     */
    void attackUp() {
        def cb = realCollisionBox
        def ar = new Rectangle2D(
                new Position2D(
                        cb.origin.x + cb.size.x / 2 - attackZoneSize / 2,
                        cb.origin.y - attackZoneSize
                ),
                new Position2D(attackZoneSize, attackZoneSize))

        performAttack(ar)
    }

    /**
     * Perform the attack system from down
     */
    void attackDown() {
        def cb = realCollisionBox
        def ar = new Rectangle2D(
                new Position2D(
                        cb.origin.x + cb.size.x / 2 - attackZoneSize / 2,
                        cb.origin.y + cb.size.y
                ),
                new Position2D(attackZoneSize, attackZoneSize))

        performAttack(ar)
    }

    /**
     * Perform the attack system from left
     */
    void attackLeft() {
        def cb = realCollisionBox
        def ar = new Rectangle2D(
                new Position2D(
                        cb.origin.x - attackZoneSize,
                        cb.origin.y + cb.size.y / 2 - attackZoneSize / 2
                ),
                new Position2D(attackZoneSize, attackZoneSize))

        performAttack(ar)
    }

    /**
     * Perform the attack system from right
     */
    void attackRight() {
        def cb = realCollisionBox
        def ar = new Rectangle2D(
                new Position2D(
                        cb.origin.x + cb.size.x,
                        cb.origin.y + cb.size.y / 2 - attackZoneSize / 2
                ),
                new Position2D(attackZoneSize, attackZoneSize))

        performAttack(ar)
    }

    /**
     * Calculate collision of the attack and do damage if an Damageable entity collide
     *
     * @param attack
     */
    void performAttack(Rectangle2D attackZone) {
        for (def entity : handler.entityManager.entities) {
            if (entity == this) continue
            if (entity instanceof Damageable) {
                if (entity.realCollisionBox.intersect(attackZone)) {
                    doDamage(entity)
                }
            }
        }

        // Set the attackTimer to 0 when we attack
        attackTimer = 0
    }
}