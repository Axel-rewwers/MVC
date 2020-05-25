package root.model.Wall;

import java.awt.*;

public class RockWall extends Wall {


    public RockWall(Point location, Dimension dimension) {
        super(location.getX(), location.getY(), dimension.getWidth(), dimension.getHeight(), 200);
        type = TypeObject.ROCK;
    }

    @Override
    public Wall copy() {
        RockWall w = new RockWall(getLocation(), getDimension());
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }
}
