package root.viewers;

import root.model.Turret;
import root.model.Wall;
import root.utils.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class VTurret implements ViewerObject<Turret> {
    private Image image;
    private String path = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Turret\\111.png";

    public VTurret() {
        image = new ImageIcon(path).getImage();
    }

    @Override
    public void render(Graphics2D g, Turret turret) {
        Point p = Display.toWindowCoordinate(turret.getX(), turret.getY());


        int width = (int) Display.toScale(turret.getWidth());
        int height = (int) Display.toScale(turret.getHeight());
        int x = p.x - width/2;
        int y = p.y - height/2;

        AffineTransform origTr = g.getTransform();

        double angle = 0;


        switch (turret.getDirection()){
            case UP:
                angle = Math.toRadians(0);
                break;
            case DOWN:
                angle = Math.toRadians(180);
                break;
            case RIGHT:
                angle = Math.toRadians(90);
                break;
            case LEFT:
                angle = Math.toRadians(270);
                break;
        }
        AffineTransform newTr = new AffineTransform(origTr);

        newTr.rotate(angle,p.x,p.y);
        g.setTransform(newTr);
//        g.drawImage(image,x, y, width, height, null);


        g.drawImage(image, x,y, width, height, null);

        g.setTransform(origTr);
    }
}
