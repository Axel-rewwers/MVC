package root.model;


import root.utils.Display;
import root.utils.Settings;


public class Tank extends BreakableObject implements Fireable{


    private double speed;

    public static final long timeToShift = 500;

    private long timeCreate;

    private long time;

    private int power;

    private int coolDown = 1000;

    private boolean moving = false;




    public Tank(double x, double y, int healthPoint) {
        super(x, y, healthPoint);
        speed = 10;
        power = 1;
        timeCreate = System.currentTimeMillis();
    }




    @Override
    public boolean readyToFire(){
        return time + coolDown < System.currentTimeMillis();
    }


    @Override
    public Bullet fire(){
        if(readyToFire()) {
            Bullet bullet = new Bullet(x, y, getDirection(), this);
            bullet.setWidth(5);
            bullet.setHeight(5);
            bullet.setDamage(power);
            time = System.currentTimeMillis();
            return bullet;
        }
        return null;
    }

    public boolean isAlive(){
        return System.currentTimeMillis() - timeCreate < timeToShift;
    }
    public  long getTimeCreate() {
        return timeCreate;
    }

    public void  go(){
        moving = true;
    }
    public void stop(){
        moving = false;
    }

    public void update(){
        if(moving){
            switch (getDirection()){
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




    public double getSpeed() {
        return speed;
    }


    public void impact(){
        switch (getDirection()) {
            case UP:
                y += speed;
                break;
            case RIGHT:
                x -= speed;
                break;
            case LEFT:
                x += speed;
                break;
            case DOWN:
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
