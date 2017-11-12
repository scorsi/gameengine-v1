package com.scorsi.gameengine.graphics

import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class ImageLoader {

    static BufferedImage load(String path) throws Exception {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path))
        } catch (IOException e) {
            e.printStackTrace()
            throw new Exception("Image " + path + " not found")
        }
    }

}
