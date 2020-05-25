package root.model;

import root.model.Wall.TypeObject;

public class BreakableObject extends Model{
    private int healthPointCurrent;
    private int healthPoint;
    private boolean unbreakable = false; //неуязвимость

    protected TypeObject type = TypeObject.SIMPLE;


    public BreakableObject(double x, double y, int healthPoint) {
        super(x, y);
        this.healthPointCurrent = healthPoint;
        this.healthPoint = healthPointCurrent;
    }

    public BreakableObject(double mx, double my, double width, double height, int healthPoint) {
        this(mx, my, healthPoint);
        setWidth(width);
        setHeight(height);
    }


    public int getHealthPointCurrent() {
        return healthPointCurrent;
    }

    public void setHealthPointCurrent(int healthPointCurrent) {
        this.healthPointCurrent = healthPointCurrent;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    @Override
    public boolean equals(Model m) {
        if (m instanceof BreakableObject){
            BreakableObject b = (BreakableObject) m;
            return super.equals(b)
                    & healthPoint == b.healthPoint
                    & healthPointCurrent == b.healthPointCurrent
                    & b.isUnbreakable() == isUnbreakable();
        }

        return false;
    }

    public void hit(int damage){
        healthPointCurrent -= damage;
    }


    public boolean isAlive(){
        return healthPointCurrent > 0;
    }


    public boolean isUnbreakable() {
        return unbreakable;
    }

    public void setUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
    }


    public TypeObject getType() {
        return type;
    }


    @Override
    public BreakableObject copy() {
        BreakableObject object = new BreakableObject(x, y, getWidth(),getHeight(), getHealthPoint());
        object.setHealthPointCurrent(getHealthPointCurrent());

        return object;
    }


}
