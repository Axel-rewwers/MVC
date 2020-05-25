package root.model.Turret;

import root.model.Wall.TypeObject;

import java.awt.*;

public class WoodTurret extends Turret{
    public WoodTurret(Point location, Dimension dimension) {
        super(location.getX(), location.getY(), dimension.getWidth(), 400);
        type = TypeObject.WOOD;
    }

    @Override
    public Turret copy() {
        WoodTurret w = new WoodTurret(getLocation(), getDimension());
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }
}
