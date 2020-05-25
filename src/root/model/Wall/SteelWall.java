package root.model.Wall;

import java.awt.*;

public class SteelWall extends Wall {


    public SteelWall(Point location, Dimension dimension) {
        super(location.getX(), location.getY(), dimension.getWidth(), dimension.getHeight(), 300);
        type = TypeObject.STEEL;
    }

    @Override
    public Wall copy() {
        SteelWall w = new SteelWall(getLocation(), getDimension());
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }
}
