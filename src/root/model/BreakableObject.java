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
        super(mx, my, width, height);
        this.healthPoint = healthPoint;
    }

    public BreakableObject(double x, double y) {
        super(x, y);
        healthPointCurrent = 0;
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

//    public static void main(String[] args) {
//        BreakableObject m1 = new BreakableObject(13.1, 15.7);
//        m1.setWidth(30.6);
//        m1.setHeight(56.5);
//        m1.setHealthPointCurrent(100);
//        m1.healthPoint = 300;
//
//
//        BreakableObject m2 = new BreakableObject(13.1, 15.7);
//        m2.setWidth(30.6);
//        m2.setHeight(56.5);
//        m2.setHealthPointCurrent(5);
//        m2.healthPoint = 300;
//
//
//
//        System.out.println(m1.equals(m2));
//    }
}
