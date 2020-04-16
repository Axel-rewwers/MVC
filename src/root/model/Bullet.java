package root.model;

public class Bullet extends Model {
    public static  double speed = 5;
    private int damage;

    private double dx = 0, dy = 0;

    public Bullet(double x, double y, Direction direction) {
        super(x, y);
        damage = 2;
        switch (direction){
            case UP:
                dx = 0;
                dy = -1 * speed;
                break;
            case RIGHT:
                dx = 1 * speed;
                dy = 0;
                break;

            case DOWN:
                dx = 0;
                dy = 1 * speed;
                break;

            case LEFT:
                dx = -1 * speed;
                dy = 0;
                break;
        }
    }


    public void  update(){
        x += dx;
        y += dy;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


}
