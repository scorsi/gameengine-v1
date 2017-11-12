package com.scorsi.gameengine.states

class StateManager {

    private static State currentState

    static void setState(State state) {
        currentState = state
    }

    static State getState() {
        return currentState
    }

}
