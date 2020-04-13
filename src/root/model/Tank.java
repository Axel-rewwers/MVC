package root.model;


import root.utils.Display;
import root.utils.Settings;

import java.awt.*;

public class Tank extends BreakableObject implements Fireable{


    public static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;


    private double speed;

    private int direction;

    private long time;

    private int coolDown = 1000;

    private boolean moving = false;




    public Tank(double x, double y, int healthPoint) {
        super(x, y, healthPoint);
        speed = 10;

    }


    public void goForward(){
        direction = UP;

    }

    public void goRight(){
        direction = RIGHT;

    }
    public void goLeft(){
        direction = LEFT;

    }
    public void goBackward(){
        direction = DOWN;

    }

    @Override
    public boolean readyToFire(){
        return time + coolDown < System.currentTimeMillis();
    }


    @Override
    public Bullet fire(){
        if(readyToFire()) {
            Bullet bullet = new Bullet(x, y, direction);
            bullet.setWidth(5);
            bullet.setHeight(5);
            time = System.currentTimeMillis();
            return bullet;
        }
        return null;
    }

    public void  go(){
        moving = true;
    }
    public void stop(){
        moving = false;
    }

    public void update(){
        if(moving){
            switch (direction){
                case  UP:
                    y -=speed;
                    break;
                case  RIGHT:
                    x+= speed;
                    break;
                case  DOWN:
                    y += speed;
                    break;
                case  LEFT:
                    x -= speed;
                    break;
            }
        }

        if (Settings.fixDisplayOnTank) {
            Display.setCenterWindow(x, y);
        }
    }


    public int getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }


    public void impact(){
        switch (getDirection()) {
            case Tank.UP:
                y += speed;
                break;
            case Tank.RIGHT:
                x -= speed;
                break;
            case Tank.LEFT:
                x += speed;
                break;
            case Tank.DOWN:
                y -= speed;
                break;
        }



    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

//    public int getState() {
//        return 0;
//    }
}
