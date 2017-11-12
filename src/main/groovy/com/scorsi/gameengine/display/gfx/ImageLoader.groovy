package com.scorsi.gameengine.display.gfx

import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class ImageLoader {

    static BufferedImage load(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path))
        } catch (IOException e) {
            e.printStackTrace()
            System.exit(1)
        }
        return null
    }

}
