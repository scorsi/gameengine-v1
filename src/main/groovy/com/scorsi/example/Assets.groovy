package com.scorsi.example

import com.scorsi.example.graphics.tiles.DirtTile
import com.scorsi.example.graphics.tiles.GrassTile
import com.scorsi.example.graphics.tiles.StoneTile
import com.scorsi.gameengine.graphics.Tile
import com.scorsi.gameengine.utils.ImageLoader
import com.scorsi.gameengine.graphics.SpriteSheet

import java.awt.image.BufferedImage

/**
 * Will be replaced later
 */
class Assets {

    private static final int width = 32, height = 32

    static BufferedImage dirt, grass, stone, tree

    static BufferedImage[] player_down = new BufferedImage[2]
    static BufferedImage[] player_up = new BufferedImage[2]
    static BufferedImage[] player_left = new BufferedImage[2]
    static BufferedImage[] player_right = new BufferedImage[2]

    static Tile dirtTile
    static Tile grassTile
    static Tile stoneTile

    static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.load("/textures/sheet.png"))

        tree = sheet.crop(0, 0, width, height)
        dirt = sheet.crop(width, 0, width, height)
        grass = sheet.crop(width * 2, 0, width, height)
        stone = sheet.crop(width * 3, 0, width, height)

        player_down[0] = sheet.crop(width * 4, 0, width, height)
        player_down[1] = sheet.crop(width * 5, 0, width, height)
        player_up[0] = sheet.crop(width * 6, 0, width, height)
        player_up[1] = sheet.crop(width * 7, 0, width, height)
        player_right[0] = sheet.crop(width * 4, height, width, height)
        player_right[1] = sheet.crop(width * 5, height, width, height)
        player_left[0] = sheet.crop(width * 6, height, width, height)
        player_left[1] = sheet.crop(width * 7, height, width, height)


        grassTile = new GrassTile(0)
        dirtTile = new DirtTile(1)
        stoneTile = new StoneTile(2)
    }

}
