package root.viewers;

import root.model.Turret;
import root.model.Wall;
import root.utils.Display;

import java.awt.*;

public class VTurret implements ViewerObject<Turret> {

    @Override
    public void render(Graphics2D g, Turret turret) {

        Point p = Display.toWindowCoordinate(turret.getX(), turret.getY());

        int x = p.x;
        int y = p.y;
        int width = (int) Display.toScale(turret.getWidth());
        int height = (int) Display.toScale(turret.getHeight());

        g.setColor(Color.black);
        g.fillOval(x-width/2,y-height/2,width,height);
    }
}
