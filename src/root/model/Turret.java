package root.model;

public class Turret extends Wall implements Fireable{


    private long timeCoolDown = 1000;
    private long timeLastShot = 0;
    private int power;


    public Turret(double mx, double my, double size, int healthPoint, boolean unbreakable) {
        super(mx, my, size, size, healthPoint, unbreakable);
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

}
