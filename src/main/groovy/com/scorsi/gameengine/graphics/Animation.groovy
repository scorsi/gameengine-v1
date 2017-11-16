package com.scorsi.gameengine.graphics

import java.awt.image.BufferedImage

class Animation {

    private Integer speed
    private Integer index

    private Long lastTime
    private Long timer

    private BufferedImage[] frames

    Animation(Integer speed, BufferedImage[] frames) {
        this.speed = speed
        this.index = 0
        this.frames = frames

        this.lastTime = System.currentTimeMillis()
        this.timer = 0
    }

    void update() {
        def tmp = System.currentTimeMillis()
        timer += tmp - lastTime
        lastTime = tmp

        if (timer > speed) {
            index += 1
            timer = 0
            if (index >= frames.length)
                index = 0
        }
    }

    BufferedImage getCurrentFrame() {
        return frames[index]
    }

}
