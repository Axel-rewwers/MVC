package root.model.Turret;

import root.model.Wall.TypeObject;

import java.awt.*;

public class RockTurret extends Turret {
    public RockTurret(Point location, Dimension dimension) {
        super(location.getX(), location.getY(), dimension.getWidth(), 400);
        type = TypeObject.ROCK;
    }

    @Override
    public Turret copy() {
        RockTurret w = new RockTurret(getLocation(), getDimension());
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }
}
