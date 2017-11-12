package com.scorsi.gameengine.display.gfx

import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class TextureLoader {

    static BufferedImage loadTexture(String path) {
        try {
            return ImageIO.read(TextureLoader.class.getResource(path))
        } catch (IOException e) {
            e.printStackTrace()
            System.exit(1)
        }
        return null
    }

}
