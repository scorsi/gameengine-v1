package com.scorsi.gameengine.graphics


import java.awt.image.BufferedImage

class SpriteSheet {

    BufferedImage sheet

    SpriteSheet(BufferedImage image) {
        sheet = image
    }

    SpriteSheet(String path) {
        sheet = ImageLoader.load(path)
    }

    BufferedImage crop(Integer x, Integer y, Integer width, Integer height) {
        return sheet.getSubimage(x, y, width, height)
    }

}
