package root.model.Wall;

import java.awt.*;

public class ArmoredWall extends Wall {
    public ArmoredWall(Point location, Dimension dimension) {
        super(location.getX(), location.getY(), dimension.getWidth(), dimension.getHeight(), 400);
        type = TypeObject.ARMORED;
    }

    @Override
    public Wall copy() {
        ArmoredWall w = new ArmoredWall(getLocation(), getDimension());
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }
}
