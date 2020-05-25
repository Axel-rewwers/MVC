package root.model;

import java.awt.*;
import java.io.Serializable;

public class Model implements Serializable {
//    public static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    private Direction direction = Direction.UP;


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


    public double getWidth() {
        return width;
    }
    public Dimension getDimension(){
        Dimension dimension = new Dimension();
        dimension.setSize(getWidth(), getHeight());
        return dimension;
    }

    public Point getLocation(){
        Point p = new Point();
        p.setLocation(getX(), getY());
        return p;
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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


    public boolean contain(double x, double y) {
        //находится ли данная точка х у в днной модели
        return y >= this.y - height / 2 & y <= this.y + height / 2 &
                x >= this.x - width / 2 & x <= this.x + width / 2;
    }


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


    public <T extends Model> T copy(){
        Model m = new Model(x, y, width, height);
        m.setDirection(direction);

        return (T) m;
    }

}






