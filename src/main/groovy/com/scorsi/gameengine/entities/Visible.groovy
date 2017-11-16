package com.scorsi.gameengine.entities

import groovy.transform.SelfType

import java.awt.Graphics

@SelfType(Entity)
trait Visible implements Positionable, Sizable {

    Boolean clipToCamera = true

    abstract void render(Graphics g)

}