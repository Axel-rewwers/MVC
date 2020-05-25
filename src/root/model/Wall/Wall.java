package root.model.Wall;

import root.model.BreakableObject;
import root.model.Model;

import java.awt.*;

public class Wall extends BreakableObject {


    private final int timeDamageElapsed = 300;
    private long timeHit;




    public Wall(double x, double y, int healthPoint) {
        super(x, y, healthPoint);
        type = TypeObject.SIMPLE;
    }

    public Wall(double mx, double my, double width, double height, int healthPoint) {
        super(mx, my, width, height, healthPoint);
        type = TypeObject.SIMPLE;
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
        if (!isUnbreakable()) {
            timeHit = System.currentTimeMillis();
            super.hit(damage);
        }
    }


    @Override
    public boolean equals(Model m) {
        if (m instanceof Wall){
            Wall w = (Wall) m;
            return super.equals(m);

        }
        return false;
    }


    @Override
    public Wall copy(){
        Wall w = new Wall(x, y, getWidth(), getHeight(), getHealthPoint());
        w.setHealthPointCurrent(getHealthPointCurrent());
        w.setDirection(getDirection());
        return w;
    }

    public TypeObject getType() {
        return type;
    }
}
