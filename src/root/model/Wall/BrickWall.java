package root.model.Wall;

import java.awt.*;

public class BrickWall extends Wall {

    public BrickWall(Point location, Dimension dimension) {
        super(location.getX(), location.getY(), dimension.getWidth(), dimension.getHeight(), 250);
        type = TypeObject.BRICK;
    }

    @Override
    public Wall copy() {
        BrickWall w = new BrickWall(getLocation(), getDimension());
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }
}