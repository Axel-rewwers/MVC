package root.model;

public class Explode extends Model{

    public static final long timeToLive = 500;

    private long timeCreate;


    public Explode(double x, double y, double width, double height) {
        super(x, y, width, height);
        timeCreate = System.currentTimeMillis();
    }

    public long getTimeCreate() {
        return timeCreate;
    }

    public boolean isAlive(){
        return System.currentTimeMillis() - timeCreate < timeToLive;
    }
}
