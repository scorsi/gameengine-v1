package com.scorsi.gameengine.input

import com.scorsi.gameengine.Handler
import com.scorsi.gameengine.utils.Position2D

import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener

class MouseManager implements MouseListener, MouseMotionListener {

    private HashMap<Integer, Boolean> buttons
    private Position2D mousePosition
    private Handler handler

    MouseManager(Handler handler) {
        this.handler = handler
        this.buttons = new HashMap<>()
        this.mousePosition = new Position2D()
    }

    @Override
    void mouseClicked(MouseEvent e) {
    }

    @Override
    void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true
    }

    @Override
    void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false

        if (handler.uiManager != null) {
            def mouse = new Mouse(e, mousePosition)
            handler.uiManager.onMouseRelease(mouse)
        }
    }

    @Override
    void mouseMoved(MouseEvent e) {
        mousePosition.x = e.x
        mousePosition.y = e.y

        if (handler.uiManager != null) {
            def mouse = new Mouse(e, mousePosition)
            handler.uiManager.onMouseMove(mouse)
        }
    }

    @Override
    void mouseEntered(MouseEvent e) {
    }

    @Override
    void mouseExited(MouseEvent e) {
    }

    @Override
    void mouseDragged(MouseEvent e) {
    }

    Dictionary<Integer, Boolean> getButtons() {
        return buttons
    }

    Boolean getLeftPressed() {
        return buttons[MouseEvent.BUTTON1]
    }

    Boolean getMiddlePressed() {
        return buttons[MouseEvent.BUTTON2]
    }

    Boolean getRightPressed() {
        return buttons[MouseEvent.BUTTON3]
    }

    Position2D getMousePosition() {
        return mousePosition
    }
}
