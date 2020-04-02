package root.viewers;

import root.model.Bullet;
import root.utils.Display;

import java.awt.*;

public class VBullet implements ViewerObject<Bullet> {

    @Override
    public void  render(Graphics2D g, Bullet bullet) {
        Point p = Display.toWindowCoordinate(bullet.getX(), bullet.getY());

        int x = p.x;
        int y = p.y;
        int width = (int) Display.toScale(bullet.getWidth());
        int height = (int) Display.toScale(bullet.getHeight());

        g.setColor(Color.black);
        g.fillOval(x-width/2,y-height/2,width,height);

    }

}
