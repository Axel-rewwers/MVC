package root.model.Turret;

import root.model.Wall.TypeObject;
import root.model.Wall.Wall;

import java.awt.*;
import java.awt.event.ActionListener;

public class ArmoredTurret extends Turret {
//    public ArmoredTurret(Point location, double size) {
//        super(location.getX(), location.getY(), size, 200);
//        type = TypeObject.ARMORED;
//    }
//
//    @Override
//    public Wall copy() {
//        ArmoredTurret w = new ArmoredTurret(getLocation(), getDimension());
//        w.setHealthPointCurrent(getHealthPointCurrent());
//        return w;
//    }
public ArmoredTurret(Point location, Dimension dimension) {
    super(location.getX(), location.getY(), dimension.getWidth(), 400);
    type = TypeObject.ARMORED;
}

    @Override
    public Turret copy() {
        ArmoredTurret w = new ArmoredTurret(getLocation(), getDimension());
        w.setHealthPointCurrent(getHealthPointCurrent());
        return w;
    }
}
