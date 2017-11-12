package com.scorsi.gameengine.utils

class FileLoader {

    static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder()

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(FileLoader.class.getResourceAsStream(path)))
            String line
            while ((line = br.readLine()) != null) {
                builder.append(line + "\n")
            }
            br.close()
        } catch (IOException e) {
            e.printStackTrace()
        }

        return builder.toString()
    }

}
