package root.viewers;

import root.model.Explode;
import root.utils.Display;

import javax.swing.*;
import java.awt.*;

public class VExplodeImage implements ViewerObject<Explode> {
    private Image[] images;
    private String path = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\explode1\\";

    private double t;



    public VExplodeImage() {
        images = new Image[13];
        for (int i = 0; i < 13; i++) {
            images[i] = new ImageIcon(path + i + ".png").getImage();
        }

        t = Explode.timeToLive / 13;

    }

    @Override
    public void render(Graphics2D g, Explode explode) {
        Point p = Display.toWindowCoordinate(explode.getX(), explode.getY());

        int x = p.x;
        int y = p.y;
        int width = (int) Display.toScale(explode.getWidth());
        int height = (int) Display.toScale(explode.getHeight());

        int index = (int) Math.floor((System.currentTimeMillis() - explode.getTimeCreate()) / t);

        if(index>12) index = 12;


        g.drawImage(images[index], x-width/2,y-height/2, 41, 40, null);

    }
}
