package root.model;

public class Turret extends Wall implements Fireable{

//    private double angle;
    private int direction;
    private int damage;

    private long timeCoolDown = 1000;
    private long timeLastShot = 0;


    public Turret(double mx, double my, double size, int healthPoint, boolean unbreakable) {
        super(mx, my, size, size, healthPoint, unbreakable);
    }


    @Override
    public void update() {
        super.update();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    //    public double getAngle() {
//        return angle;
//    }
//
//    public void setAngle(double angle) {
//        this.angle = angle;
//    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public Bullet fire() {
        Bullet bullet = null;
        if(readyToFire()){
            bullet = new Bullet(getX(), getY(), getDirection());
            timeLastShot = System.currentTimeMillis();
            bullet.setWidth(5);
            bullet.setHeight(5);
        }
        return bullet;
    }

    @Override
    public boolean readyToFire(){
        return  System.currentTimeMillis() - timeLastShot >= timeCoolDown;
    }

}
