package root.model.Wall;

import java.awt.*;

public class WoodWall  extends Wall{

    public WoodWall(Point location, Dimension dimension) {
        super(location.getX(), location.getY(), dimension.getWidth(), dimension.getHeight(), 50);
        type = TypeObject.WOOD;
    }

    @Override
    public Wall copy() {
        WoodWall w = new WoodWall(getLocation(), getDimension());
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }

}
