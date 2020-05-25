package root.controllers;

import root.utils.Display;
import root.utils.Settings;

import java.awt.*;
import java.awt.event.*;

public class ControllerDisplay implements MouseWheelListener, MouseMotionListener, MouseListener {

    private Point centerShift;
    private Point centerWindow;

    private double scaleStep = 0.1;


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        //попробуй взять точку центра экрана (centerWindow) в этом месте
        centerWindow = new Point(Display.getX(), Display.getY());



        if(e.getWheelRotation() > 0){
            //уменьшаем
            double newScale = Display.getScale() - scaleStep;
            if(newScale < 0.65){
                newScale = 0.65;
            }

            Display.setScale(newScale);

        } else {
            //увеличиваем
            double newScale = Display.getScale() + scaleStep;
            if(newScale > 1.5){
                newScale = 1.5;
            }
            Display.setScale(newScale);

        }


        double shiftX = centerWindow.x;
        double shiftY = centerWindow.y;



        int boundX = 1000;
        double windowWidth = Display.getWidth() / Display.getScale() / 2;
        double shiftAbsX =
                shiftX - windowWidth < -boundX
                        ? -boundX + windowWidth
                        :
                        shiftX + windowWidth > boundX
                                ? boundX - windowWidth
                                : shiftX;


        int boundY = 1000;
        double windowHeight = Display.getHeight()/ Display.getScale() / 2;
        double shiftAbsY =
                shiftY - windowHeight < -boundY
                        ? -boundY + windowHeight
                        :
                        shiftY + windowHeight > boundY
                                ? boundY - windowHeight
                                : shiftY;


        Display.setCenterWindow(shiftAbsX, shiftAbsY);


    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println("dragging!");

        if (centerShift != null) {
            double shiftX = centerWindow.x - (e.getX() - centerShift.getX())/Display.getScale();
            double shiftY = centerWindow.y -(e.getY() - centerShift.getY())/Display.getScale();



            int boundX = 1000;
            double windowWidth = Display.getWidth() / Display.getScale() / 2;
            double shiftAbsX =
                    shiftX - windowWidth < -boundX
                    ? -boundX + windowWidth
                    :
                    shiftX + windowWidth > boundX
                            ? boundX - windowWidth
                            : shiftX;


            int boundY = 1000;
            double windowHeight = Display.getHeight()/ Display.getScale() / 2;
            double shiftAbsY =
                    shiftY - windowHeight < -boundY
                            ? -boundY + windowHeight
                            :
                            shiftY + windowHeight > boundY
                                    ? boundY - windowHeight
                                    : shiftY;

            Display.setCenterWindow(shiftAbsX, shiftAbsY);
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
