package com.scorsi.gameengine.utils

class Parser {

    static parseInt(String s) {
        try {
            return Integer.parseInt(s)
        } catch (NumberFormatException e) {
            e.printStackTrace()
            return 0
        }
    }

}
