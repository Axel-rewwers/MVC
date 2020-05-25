package root.viewers;

import root.model.Turret.*;
import root.model.Wall.ArmoredWall;
import root.model.Wall.SteelWall;
import root.utils.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class VTurret implements ViewerObject<Turret> {
    private Image image;

    private Image imageRock;
    private Image imageSteel;
    private Image imageBrick;
    private Image imageWood;
    private Image imageSimpl;
    private Image imageArmored;

    private String pathSimpl = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Turret\\0.png";
    private String pathWood = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Turret\\1.png";
    private String pathRock = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Turret\\2.png";
    private String pathBrick = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Turret\\2.png";
    private String pathSteel = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Turret\\4.png";
    private String pathArmored = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Turret\\5.png";
//    private String path = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Turret\\0.png";

    public VTurret() {
//        image = new ImageIcon(path).getImage();
        imageSimpl = new ImageIcon(pathSimpl).getImage();
        imageWood = new ImageIcon(pathWood).getImage();
        imageRock = new ImageIcon(pathRock).getImage();
        imageBrick = new ImageIcon(pathBrick).getImage();
        imageSteel = new ImageIcon(pathSteel).getImage();
        imageArmored = new ImageIcon(pathArmored).getImage();
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

        int alpha = 124;
        Color clShadow = new Color(0,0,0,alpha);

        g.setColor(clShadow);
        g.fillOval( x,y, width, height);
        Image image;
        image = imageSimpl;
        if (turret instanceof WoodTurret) image = imageWood;
        if (turret instanceof RockTurret) image = imageRock;
        if (turret instanceof BrickTurret) image = imageBrick;
        if (turret instanceof SteelTurret) image = imageSteel;
        if (turret instanceof ArmoredTurret) image = imageArmored;

        g.drawImage(image, x,y, width, height, null);

        g.setTransform(origTr);
    }
}
