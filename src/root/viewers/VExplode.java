package root.viewers;

import root.model.Explode;
import root.utils.Display;

import java.awt.*;

public class VExplode implements ViewerObject<Explode> {


    @Override
    public void render(Graphics2D g, Explode explode) {

        Point p = Display.toWindowCoordinate(explode.getX(), explode.getY());

        int x = p.x;
        int y = p.y;
        int width = (int) Display.toScale(explode.getWidth());
        int height = (int) Display.toScale(explode.getHeight());

        g.setColor(Color.red);
        g.fillOval(x-width/2,y-height/2,width,height);



    }
}
