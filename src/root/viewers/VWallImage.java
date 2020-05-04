package root.viewers;

import root.model.Wall.*;
import root.utils.Display;

import javax.swing.*;
import java.awt.*;

public class VWallImage implements ViewerObject<Wall> {

    private Image imageRock;
    private Image imageSteel;
    private Image imageBrick;
    private Image imageWood;
    private Image imageSimpl;

    private String pathSimpl = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Wall\\0.png";
    private String pathWood = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Wall\\1.png";
    private String pathRock = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Wall\\2.png";
    private String pathBrick = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Wall\\3.png";
    private String pathSteel = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Wall\\4.png";

    public VWallImage() {
        imageSimpl = new ImageIcon(pathSimpl).getImage();
        imageWood = new ImageIcon(pathWood).getImage();
        imageRock = new ImageIcon(pathRock).getImage();
        imageBrick = new ImageIcon(pathBrick).getImage();
        imageSteel = new ImageIcon(pathSteel).getImage();

    }

    @Override
    public void render(Graphics2D g, Wall wall) {

        Point p = Display.toWindowCoordinate(wall.getX(), wall.getY());

        int width = (int) Display.toScale(wall.getWidth());
        int height = (int) Display.toScale(wall.getHeight());

        int countWidth = (int) Math.ceil(width / Display.toScale(16.0));
        int countHeight = (int) Math.ceil(height / Display.toScale(16.0));


        double shift = 0.5;

        double widthCub = width / (float) countWidth;
        double heightCub = height / (float) countHeight;

        int x = p.x - width / 2;
        int y = p.y - height / 2;


        int alpha = 124;
        Color clShadow = new Color(0, 0, 0, alpha);
        g.setColor(clShadow);
        g.fillRect(x, y - 7, width, height + 7);

        Image image;
        image = imageSimpl;
        if (wall instanceof WoodWall) image = imageWood;
        if (wall instanceof RockWall) image = imageRock;
        if (wall instanceof BrickWall) image = imageBrick;
        if (wall instanceof SteelWall) image = imageSteel;


        for (int i = 0; i < countWidth; i++) {
            for (int j = 0; j < countHeight; j++) {
                g.drawImage(image,
                        (int) Math.round(x + widthCub * i),
                        (int) Math.round(y + heightCub * j),
                        (int) Math.round(widthCub + shift),
                        (int) Math.round(heightCub + shift),
                        null);
            }
        }

//        g.drawImage(imageRock,x, y, width, height, null);
    }
}
