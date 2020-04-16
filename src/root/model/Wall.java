package root.model;

public class Wall extends BreakableObject{

    private int state;

    private final int timeDamageElapsed = 300;
    private long timeHit;
    private boolean unbreakable = false; //неуязвимость



    public Wall(double x, double y, int healthPoint) {
        super(x, y, healthPoint);
        state = 2;
    }

    public Wall(double mx, double my, double width, double height, int healthPoint, boolean unbreakable) {
        super(mx, my, width, height, healthPoint);
        this.unbreakable = unbreakable;
        state = 2;
    }

    public void setDimension(double width, double height){
        setWidth(width);
        setHeight(height);
    }


    public int getState() {
        return state;
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


}
