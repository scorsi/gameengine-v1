package com.scorsi.example.states

import com.scorsi.example.entities.Player
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.EntityManager
import com.scorsi.gameengine.graphics.World
import com.scorsi.gameengine.states.State
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class GameState extends State {

    World world

    private EntityManager entityManager

    GameState(Handler handler) {
        super(handler)
        entityManager = new EntityManager(handler)
    }

    @Override
    void init() {
        world = new World(handler, "/worlds/world2.txt")
        handler.world = world

        entityManager.registerEntity(new Player(handler, new Position2D(world.spawnX, world.spawnY)))
    }

    @Override
    void update() {
        world.update()
        entityManager.update()
    }

    @Override
    void render(Graphics g) {
        world.render(g)
        entityManager.render(g)
    }

}
