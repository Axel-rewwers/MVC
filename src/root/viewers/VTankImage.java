package root.viewers;

import root.model.Tank;
import root.utils.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class VTankImage implements ViewerObject<Tank> {

    private Image image;
    private Image[] images;
//    private String path = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\tank.png";
    private String path = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Tank\\";
    private double t;

    public VTankImage() {
        image = new ImageIcon(path).getImage();
        images = new Image[2];
        for (int i = 0; i < 2; i++) {
            images[i] = new ImageIcon(path + i + ".png").getImage();
        }

        t = Tank.timeToShift / 13;

    }

    @Override
    public void render(Graphics2D g, Tank tank) {


        Point p = Display.toWindowCoordinate(tank.getX(), tank.getY());
        int width = (int) Display.toScale(tank.getWidth());
        int height = (int) Display.toScale(tank.getHeight());
        int x = p.x - width/2;
        int y = p.y - height/2;





        AffineTransform origTr = g.getTransform();




        double angle = 0;


        switch (tank.getDirection()){
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

        int index = (int) Math.floor((System.currentTimeMillis() - tank.getTimeCreate()) / t);

        if(index>1) index = 1;


        g.drawImage(images[index], x,y, width, height, null);

        g.setTransform(origTr);


    }
}
