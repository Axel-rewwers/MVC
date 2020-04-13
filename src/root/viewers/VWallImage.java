package root.viewers;

import root.model.Wall;
import root.utils.Display;

import javax.swing.*;
import java.awt.*;

public class VWallImage implements ViewerObject<Wall> {
    private Image image;
    private String path = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\wall3.png";


    public VWallImage() {
        image = new ImageIcon(path).getImage();
    }

    @Override
    public void render(Graphics2D g, Wall wall) {
        Point p = Display.toWindowCoordinate(wall.getX(), wall.getY());

        int width = (int) Display.toScale(wall.getWidth());
        int height = (int) Display.toScale(wall.getHeight());

        int countWidth = (int)Math.ceil(width/Display.toScale(16.0));
        int countHeight = (int)Math.ceil(height/Display.toScale(16.0));


        double shift = 0.5;

        double widthCub = width/(float)countWidth;
        double heightCub = height/(float)countHeight;

        int x = p.x - width/2;
        int y = p.y - height/2;

        g.setColor(Color.gray);
        g.drawRect(x, y, width, height);



        for (int i = 0; i < countWidth; i++) {
            for (int j = 0; j < countHeight; j++) {
                g.drawImage(image,
                        (int) Math.round(x + widthCub*i),
                        (int) Math.round(y + heightCub*j),
                        (int) Math.round(widthCub+shift),
                        (int) Math.round(heightCub+shift),
                        null);
            }
        }

//        g.drawImage(image,x, y, width, height, null);
    }
}
