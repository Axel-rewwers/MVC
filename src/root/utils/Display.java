package root.utils;

import root.graphics.GamePanel;
import root.model.Tank;

import java.awt.*;

public class Display {

    private static int x;
    private static int y;
    public static final int  width = GamePanel.WIDTH;
    public static final int  height = GamePanel.HEIGHT;

    private static double scale = 1;



    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }


    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }


    // РАССЧЁТ КООРДИНАТ МОДЕЛИ В ОКНЕ В ДАННЫЙ МОМЕНТ, ОТНОСИТЕЛЬНО ЕГО КООРДИНАТ НА КАРТЕ И ПОЛОЖЕНИЯ центра экрана
    /**
     * @param x - координата оси Ох на карте
     * @param y - координата оси Оу на карте
     * @return точку в системе координат окна
     */
    public static Point toWindowCoordinate(double x, double y){
        double wX = (x - Display.getX()) * scale + (float) Display.getWidth() / 2;
        double wY = (y - Display.getY()) * scale + (float) Display.getHeight() / 2;

        Point p = new Point();
        p.setLocation(wX, wY);
        return  p;
    }

    public static Point toMapCoordinate(double x, double y){
        double mX = Display.getX() + (x - (float) GamePanel.WIDTH / 2)/scale;
        double mY = Display.getY() + (y - (float) GamePanel.HEIGHT / 2)/scale;

        Point p = new Point();
        p.setLocation(mX, mY);
        return  p;
    }

    public static double toScale(double value){
        return value * scale;
    }


    public static void setCenterWindow(double x, double y){
        Display.x = (int) x;
        Display.y = (int) y;
    }

    public static void setX(int x) {
        Display.x = x;
    }

    public static void setY(int y) {
        Display.y = y;
    }

    public static double getScale() {
        return scale;
    }

    public static void setScale(double scale) {
        Display.scale = scale;
    }
}
