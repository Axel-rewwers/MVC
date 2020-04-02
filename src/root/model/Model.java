package root.model;

import java.awt.*;
import java.io.Serializable;

public class Model implements Serializable {

    protected double x, y;//координаты НА КАРТЕ
    private double width, height;


    public Model(double xMap, double yMap) {
        x = xMap;
        y = yMap;
    }

    public Model(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {

    }


//    public double getWx() {
//        return (x - Display.getX() + (float) Display.getWidth() / 2);
//
//        //wX = x - Tank.getTankX() + (float) GamePanel.WIDTH / 2
//        //-x = -Tank.getTankX() - wX + (float) GamePanel.WIDTH / 2
//        //x = Tank.getTankX() + wX - (float) GamePanel.WIDTH / 2
//    }
//
//    public double getWy() {
//        return (y -Display.getY() + (float) Display.getHeight() / 2);
//    }
//    ////////////

    public double getWidth() {
        return width;
    }


    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //    public boolean contain(double x, double y){
//        //находится ли данная точка х у в днной модели
//        return y >= this.getLocation().getY() - height/2 & y <= this.getLocation().getY() + height/2 &
//                x >= this.getLocation().getX() - width/2 & x <= this.getLocation().getX() + width/2;
//    }
    public boolean contain(double x, double y) {
        //находится ли данная точка х у в днной модели
        return y >= this.y - height / 2 & y <= this.y + height / 2 &
                x >= this.x - width / 2 & x <= this.x + width / 2;
    }
//    public boolean contain1(double x, double y) {
//
//    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean intersects(Model m) {
        //проверить пересекается ли данная модель с моделью m

        return m.contain(x - width / 2, y - height / 2) ||
                m.contain(x + width / 2, y - height / 2) ||
                m.contain(x + width / 2, y + height / 2) ||
                m.contain(x - width / 2, y + height / 2) ||

                contain(m.getX() - m.width / 2, m.getY() - m.height / 2) ||
                contain(m.getX() + m.width / 2, m.getY()  - m.height / 2) ||
                contain(m.getX() + m.width / 2, m.getY()  + m.height / 2) ||
                contain(m.getX() - m.width / 2, m.getY()  + m.height / 2);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    public boolean equals(Model m){
       return Math.round(x) == Math.round(m.x)
                &  Math.round(y) == Math.round(m.y)
                &  Math.round(width) == Math.round(m.width)
                &  Math.round(height) == Math.round(m.height);
    }
    public Rectangle getRectangle(){
        return  new Rectangle(((int) (x - width / 2)), ((int) (y - height / 2)), ((int) width), ((int) height));
    }

//    public static void main(String[] args) {
//        Model m1 = new Model(13.1, 15.7);
//        m1.setWidth(30.6);
//        m1.setHeight(56.5);
//
//
//        Model m2 = new Model(13.1, 15.3);
//        m2.setWidth(30.6);
//        m2.setHeight(56.5);
//
//        System.out.println(m1.equals(m2));
//    }
}
