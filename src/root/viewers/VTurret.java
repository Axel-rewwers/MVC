package root.viewers;

import root.model.Turret;
import root.model.Wall;
import root.utils.Display;

import javax.swing.*;
import java.awt.*;

public class VTurret implements ViewerObject<Turret> {
    private Image image;
    private String path = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\turret1.png";

    public VTurret() {
        image = new ImageIcon(path).getImage();
    }

    @Override
    public void render(Graphics2D g, Turret turret) {
        Point p = Display.toWindowCoordinate(turret.getX(), turret.getY());

        int x = p.x;
        int y = p.y;
        int width = (int) Display.toScale(turret.getWidth());
        int height = (int) Display.toScale(turret.getHeight());


        g.drawImage(image, x-width/2,y-height/2, 50, 50, null);
    }
}
