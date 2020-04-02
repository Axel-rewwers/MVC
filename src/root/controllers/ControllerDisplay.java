package root.controllers;

import root.utils.Display;
import root.utils.Settings;

import java.awt.*;
import java.awt.event.*;

public class ControllerDisplay implements MouseWheelListener, MouseMotionListener, MouseListener {

    private Point centerShift;
    private Point centerWindow;



    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {


        if(e.getWheelRotation() > 0){
            //уменьшаем
            Display.setScale(Display.getScale()-0.01);
        } else {
            //увеличиваем

            Display.setScale(Display.getScale()+0.01);
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println("dragging!");

        if (centerShift != null) {
            double shiftX = (e.getX() - centerShift.getX())/Display.getScale();
            double shiftY = (e.getY() - centerShift.getY())/Display.getScale();


            Display.setCenterWindow(centerWindow.x - shiftX, centerWindow.y - shiftY);
        }
    }



    private int pop = 100;
    private int speed = 5;


    @Override
    public void mouseMoved(MouseEvent e) {
        if (false & !Settings.fixDisplayOnTank){
            int centerX = Display.getX();
            int centerY = Display.getY();

            if(e.getX() < pop){
                Display.setCenterWindow(centerX - speed, centerY);
            }
            if(e.getX() > Display.getWidth() - pop){
                Display.setCenterWindow(centerX + speed, centerY);
            }
            if(e.getY()< pop){
                Display.setCenterWindow(centerX, centerY - speed);
            }
            if(e.getY() > Display.getHeight()-pop){
                Display.setCenterWindow(centerX, centerY + speed);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!Settings.fixDisplayOnTank && e.getButton() == 3) {
            centerShift = new Point(e.getX(), e.getY());
            centerWindow = new Point(Display.getX(), Display.getY());
        }
//        System.out.println(Display.getX() + " " +  Display.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        centerShift = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
