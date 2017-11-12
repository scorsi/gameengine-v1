package com.scorsi.example.states

import com.scorsi.gameengine.display.gfx.SpriteSheet
import com.scorsi.gameengine.states.State

import java.awt.Graphics

class GameState extends State {

    private SpriteSheet testSheet

    GameState() {

    }

    @Override
    void init() {
        testSheet = new SpriteSheet("/textures/sheet.png")
    }

    @Override
    void update() {

    }

    @Override
    void render(Graphics g) {
        g.drawImage(testSheet.crop(0,0,32,32), 10, 10, 64, 64, null)
    }

}
