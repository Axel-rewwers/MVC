package root.controllers;

import root.model.Model;
import root.viewers.ViewerObject;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ControlObject<T extends Model>  implements MouseMotionListener, MouseListener, KeyListener {

    private ViewerObject<T> viewer;
    private ArrayList<T> objects;



    public ControlObject() {
        objects = new ArrayList<>();
    }


    public void setViewer(ViewerObject<T> viewer) {
        this.viewer = viewer;
    }



    public void update() {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update();
        }
    }


    public void render(Graphics2D g){
        if (viewer != null) {
            for (int i = 0; i < objects.size(); i++) {
                viewer.render(g, objects.get(i));
            }
        }
    }


    public T getCollision(Rectangle r){
        for (int i = 0; i < objects.size(); i++) {
            T obj = objects.get(i);
            if (r.intersects(obj.getRectangle())) {
                return obj;
            }
        }
        return null;
    }

    public void removeObject(T t){
        objects.remove(t);
    }



    public void addObject(T  t){
        objects.add(t);
    }

    public void addObject(ArrayList<T> list){
        objects.addAll(list);
    }



    public ArrayList<T> getObjects() {
        return objects;
    }


    @Override
    public void mouseDragged(MouseEvent e) {


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    public void keyReleased(KeyEvent e) {

    }
}
