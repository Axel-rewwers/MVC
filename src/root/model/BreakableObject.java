package root.model;

public class BreakableObject extends Model{
    private int healthPointCurrent;
    private int healthPoint;


    public BreakableObject(double x, double y, int healthPointCurrent) {
        super(x, y);
        this.healthPointCurrent = healthPointCurrent;
        this.healthPoint = healthPointCurrent;
    }

    public BreakableObject(double mx, double my, double width, double height, int healthPoint) {
        this(mx, my, healthPoint);
        setWidth(width);
        setHeight(height);
    }

    public BreakableObject(double x, double y) {
        this(x, y, 1);
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
                    & healthPointCurrent == b.healthPointCurrent;
        }

        return false;
    }

    public void hit(int damage){
        healthPointCurrent -= damage;
    }


    public boolean isAlive(){
        return healthPointCurrent > 0;
    }



}
