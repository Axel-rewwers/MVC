package root.model.Turret;

import root.model.Bullet;
import root.model.Fireable;
import root.model.Wall.Wall;

public class Turret extends Wall implements Fireable {


    private long timeCoolDown = 1000;
    private long timeLastShot = 0;
    private int power;


    public Turret(double mx, double my, double size, int healthPoint) {
        super(mx, my, size, size, healthPoint);
        power = 1;
    }


    @Override
    public void update() {
        super.update();
    }

    public int getDamage() {
        return power;
    }

    public void setDamage(int damage) {
        this.power = damage;
    }

    @Override
    public Bullet fire() {
        Bullet bullet = null;
        if(readyToFire()){
            bullet = new Bullet(getX(), getY(), getDirection(), this);
            timeLastShot = System.currentTimeMillis();
            bullet.setWidth(5);
            bullet.setHeight(5);
            bullet.setDamage(power);
        }
        return bullet;
    }

    @Override
    public boolean readyToFire(){
        return  System.currentTimeMillis() - timeLastShot >= timeCoolDown;
    }


    public long getTimeCoolDown() {
        return timeCoolDown;
    }

    public void setTimeCoolDown(long timeCoolDown) {
        this.timeCoolDown = timeCoolDown;
    }

    @Override
    public Wall copy() {
        Turret turret = new Turret(x, y, getWidth(), getHealthPoint());
        turret.setDamage(getDamage());
        turret.setUnbreakable(isUnbreakable());
        turret.setTimeCoolDown(getTimeCoolDown());
        turret.setDirection(getDirection());
        return turret;
    }
}
