package root.viewers;

import root.model.Turret;
import root.model.Wall;

import java.awt.*;

public class VTurret implements ViewerObject<Turret> {

    @Override
    public void render(Graphics2D g, Turret turret) {
        Rectangle r = turret.getRectangle();
        g.setColor(Color.BLACK.brighter());
        g.fillOval(r.x,r.y, r.width, r.height);
    }
}
