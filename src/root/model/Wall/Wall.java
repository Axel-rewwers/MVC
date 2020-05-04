package root.model.Wall;

import root.model.BreakableObject;
import root.model.Model;

import java.awt.*;

public class Wall extends BreakableObject {
    protected TypeWall type = TypeWall.SIMPLE;

    private final int timeDamageElapsed = 300;
    private long timeHit;
    private boolean unbreakable = false; //неуязвимость



    public Wall(double x, double y, int healthPoint) {
        super(x, y, healthPoint);
    }

    public Wall(double mx, double my, double width, double height, int healthPoint, boolean unbreakable) {
        super(mx, my, width, height, healthPoint);
        this.unbreakable = unbreakable;
    }

    public Dimension getDimension(){
        Dimension dimension = new Dimension();
        dimension.setSize(getWidth(), getHeight());
        return dimension;
    }

    public Point getLocation(){
        Point p = new Point();
        p.setLocation(getX(), getY());
        return p;
    }

    public void setDimension(double width, double height){
        setWidth(width);
        setHeight(height);
    }

    public void setLocation(double x, double y){
        setX(x);
        setY(y);
    }

    public boolean isTookDamage() {
        return System.currentTimeMillis() - timeHit < timeDamageElapsed;
    }


    @Override
    public void hit(int damage){
        if (!unbreakable) {
            timeHit = System.currentTimeMillis();
            super.hit(damage);
        }
    }

    public boolean isUnbreakable() {
        return unbreakable;
    }

    public void setUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
    }

    @Override
    public boolean equals(Model m) {
        if (m instanceof Wall){
            Wall w = (Wall) m;
            return super.equals(m)
                    & unbreakable == w.unbreakable;
        }
        return false;
    }


    public Wall copy(){
        Wall w = new Wall(x, y, getWidth(), getHeight(), getHealthPoint(), unbreakable);
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }

    public TypeWall getType() {
        return type;
    }
}
