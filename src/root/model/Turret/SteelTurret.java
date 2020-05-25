package root.model.Turret;

import root.model.Wall.TypeObject;

import java.awt.*;

public class SteelTurret extends Turret {
    public SteelTurret(Point location, Dimension dimension) {
        super(location.getX(), location.getY(), dimension.getWidth(), 400);
        type = TypeObject.STEEL;
    }

    @Override
    public Turret copy() {
        SteelTurret w = new SteelTurret(getLocation(), getDimension());
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }
}
