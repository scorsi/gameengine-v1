package com.scorsi.gameengine.entities

import groovy.transform.SelfType

import java.awt.Graphics
import java.awt.image.BufferedImage

@SelfType(Entity)
trait Visible implements Positionable, Sizable {

    BufferedImage image

    Boolean clipToCamera = true

    void render(Graphics g) {
        if (clipToCamera)
            g.drawImage(image,
                    (position.x - handler.camera.offset.x) as Integer,
                    (position.y - handler.camera.offset.y) as Integer,
                    width as Integer, height as Integer, null)
        else
            g.drawImage(image, position.x as Integer, position.y as Integer, width as Integer, height as Integer, null)
    }

}