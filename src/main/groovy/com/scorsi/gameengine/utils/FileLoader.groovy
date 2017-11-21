package com.scorsi.gameengine.utils

import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class FileLoader {

    static final String RESOURCES_DIRECTORY = "./resources/"

    static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder()

        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(FileLoader.class.getResourceAsStream(path)))
            BufferedReader br = new BufferedReader(new FileReader(RESOURCES_DIRECTORY + path))
            String line
            while ((line = br.readLine()) != null) {
                builder.append(line + "\n")
            }
            br.close()
        } catch (IOException e) {
            e.printStackTrace()
            throw new Exception("File " + RESOURCES_DIRECTORY + path + " not found")
        }

        return builder.toString()
    }

    static BufferedImage loadImage(String path) throws Exception {
        try {
            return ImageIO.read(new File(RESOURCES_DIRECTORY + path))
        } catch (IOException e) {
            e.printStackTrace()
            throw new Exception("Image " + RESOURCES_DIRECTORY + path + " not found")
        }
    }

}
