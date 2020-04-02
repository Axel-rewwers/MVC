package root.viewers;

import root.graphics.GamePanel;
import root.model.Wall;
import root.utils.Display;

import java.awt.*;

public class VWalls implements ViewerObject<Wall> {
    int scoreCells = 200;
    int score = 0;
    int usd ;
    @Override
    public void render(Graphics2D g, Wall wall) {

        Point p = Display.toWindowCoordinate(wall.getX(), wall.getY());

        int x = p.x;
        int y = p.y;
        int width = (int) Display.toScale(wall.getWidth());
        int height = (int) Display.toScale(wall.getHeight());
        int[] tover = new int[100];

//        for (int i = 10; i < 20; i++){
//            usd = -1;
//            while (usd != -1) {
//                if (scoreCells > 0) {
//                    scoreCells -= i;
//                    score++;
//                }else {
//                    usd = 0;
//                }
//            }
//        }
//        System.out.println(score + " "+ scoreCells);


        Point a = new Point(x - width / 2, y - height / 2);
        Point b = new Point(x + width / 2, y - height / 2);
        Point c = new Point(x + width / 2, y + height / 2);
        Point d = new Point(x - width / 2, y + height / 2);

        Color primeCl;

        switch (wall.getState()){
            case 2:
                primeCl = Color.gray.darker();
                break;
            case 1:
                primeCl = Color.gray;
                break;

            case 0:
                primeCl = Color.lightGray.brighter();
                break;
            default: primeCl = Color.RED;
                break;
        }

        g.setColor(primeCl);
        g.fillPolygon(
                new int[]{a.x, b.x, c.x, d.x},
                new int[]{a.y, b.y, c.y, d.y},
                4
        );


        if (wall.isTookDamage() ) {
            g.setColor(Color.RED);
            g.drawPolygon(
                    new int[]{a.x, b.x, c.x, d.x},
                    new int[]{a.y, b.y, c.y, d.y},
                    4
            );
        }
    }

}
