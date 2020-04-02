package root.model;

public class Turret extends Wall{

//    private double angle;
    private int direction;
    private int damage;

    private long timeCoolDown = 100;
    private long timeLastShot = 0;


    public Turret(double mx, double my, double size, int healthPoint, boolean unbreakable) {
        super(mx, my, size, size, healthPoint, unbreakable);
    }


    @Override
    public void update() {
        super.update();

        if(System.currentTimeMillis() - timeLastShot >= timeCoolDown){
            Bullet bullet = new Bullet(getX(), getY(), getDirection());
            MapManager.addBullet(bullet);
            timeLastShot = System.currentTimeMillis();
        }


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
}
