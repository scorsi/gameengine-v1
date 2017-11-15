package com.scorsi.example

import com.scorsi.gameengine.graphics.ImageLoader
import com.scorsi.gameengine.graphics.SpriteSheet

import java.awt.image.BufferedImage

/**
 * Will be replaced later
 */
class Assets {

    private static final int width = 32, height = 32

    static BufferedImage player, dirt, grass, stone, tree

    static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.load("/textures/sheet.png"))

        tree = sheet.crop(0, 0, width, height)
        dirt = sheet.crop(width, 0, width, height)
        grass = sheet.crop(width * 2, 0, width, height)
        stone = sheet.crop(width * 3, 0, width, height)
        player = sheet.crop(width * 4, 0, width, height)
    }

}
