package com.scorsi.gameengine.entities

import groovy.transform.SelfType

@SelfType(Entity)
abstract trait Updatable {

    abstract void update()

}