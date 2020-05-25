package root.model.Turret;

import root.model.Wall.TypeObject;
import root.model.Wall.Wall;

import java.awt.*;

public class BrickTurret extends Turret{
    public BrickTurret(Point location, Dimension dimension) {
        super(location.getX(), location.getY(), dimension.getWidth(), 400);
        type = TypeObject.BRICK;
    }

    @Override
    public Turret copy() {
        BrickTurret w = new BrickTurret(getLocation(), getDimension());
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }
}
