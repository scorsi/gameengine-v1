package com.scorsi.example.states

import com.scorsi.example.entities.Player
import com.scorsi.example.entities.Tree
import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.entities.EntityManager
import com.scorsi.gameengine.graphics.World
import com.scorsi.gameengine.states.State
import com.scorsi.gameengine.utils.Position2D

import java.awt.Graphics

class GameState extends State {

    World world

    GameState(Handler handler) {
        super(handler)
    }

    @Override
    void init() {
        world = new World(handler, "/worlds/world2.txt")
        handler.world = world

        entityManager.registerEntity(new Tree(handler, new Position2D(100, 250)))
        entityManager.registerEntity(new Tree(handler, new Position2D(100, 350)))
        entityManager.registerEntity(new Tree(handler, new Position2D(100, 450)))
        
        entityManager.registerEntity(new Player(handler, new Position2D(world.spawnX, world.spawnY)))
    }

    @Override
    void update() {
        world.update()
    }

    @Override
    void render(Graphics g) {
        world.render(g)
    }

}
