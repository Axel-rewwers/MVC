package root.controllers;


import root.utils.Keyboard;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.EventListener;

public class Controller implements MouseListener, KeyListener, MouseWheelListener, MouseMotionListener {



    private ArrayList<EventListener> controllers;

    public Controller() {
        controllers = new ArrayList<>();
    }

    public void addController(EventListener controller){
        controllers.add(controller);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(int i = 0; i < controllers.size(); i++) {
            if (controllers.get(i) instanceof MouseListener) {
                ((MouseListener) controllers.get(i)).mousePressed(e);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(int i = 0; i < controllers.size(); i++) {
            if (controllers.get(i) instanceof MouseListener) {
                ((MouseListener) controllers.get(i)).mouseReleased(e);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for(int i = 0; i < controllers.size(); i++) {
            if (controllers.get(i) instanceof MouseListener) {
                ((MouseListener) controllers.get(i)).mouseEntered(e);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for(int i = 0; i < controllers.size(); i++) {
            if (controllers.get(i) instanceof MouseListener) {
                ((MouseListener) controllers.get(i)).mouseExited(e);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        for(int i = 0; i < controllers.size(); i++) {
            if (controllers.get(i) instanceof KeyListener) {
                ((KeyListener) controllers.get(i)).keyTyped(e);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Keyboard.setKeys(e.getKeyCode(), true);


        for(int i = 0; i < controllers.size(); i++) {
            if (controllers.get(i) instanceof KeyListener) {
                ((KeyListener) controllers.get(i)).keyPressed(e);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Keyboard.setKeys(e.getKeyCode(), false);

        for(int i = 0; i < controllers.size(); i++) {
            if (controllers.get(i) instanceof KeyListener) {
                ((KeyListener) controllers.get(i)).keyReleased(e);
            }
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        for(int i = 0; i < controllers.size(); i++) {
            if (controllers.get(i) instanceof MouseWheelListener) {
                ((MouseWheelListener) controllers.get(i)).mouseWheelMoved(e);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for(int i = 0; i < controllers.size(); i++) {
            if (controllers.get(i) instanceof MouseMotionListener) {
                ((MouseMotionListener) controllers.get(i)).mouseDragged(e);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(int i = 0; i < controllers.size(); i++) {
            if (controllers.get(i) instanceof MouseMotionListener) {
                ((MouseMotionListener) controllers.get(i)).mouseMoved(e);
            }
        }
    }
}
