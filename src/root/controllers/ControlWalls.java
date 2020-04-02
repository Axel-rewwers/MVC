package root.controllers;

import root.model.Wall;
import root.utils.Display;
import root.utils.Keyboard;
import root.utils.Loader;
import root.viewers.VWalls;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class ControlWalls extends ControlObject<Wall> {

    private Editor editor;
    private Loader<Wall> loader;


    public ControlWalls() {
        editor = new Editor();
        setViewer(new VWalls());


        loader = new Loader<>("walls_v1.map");

        try {
            addObject(loader.loadFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



    @Override
    public void update() {
        ArrayList<Wall> walls = getObjects();
        for (int i = 0; i < walls.size(); i++) {
            Wall wall = walls.get(i);
            wall.update();

            if(wall.getState() == 0){
                removeObject(wall);
            }
        }
    }

    private Wall wall;

    @Override
    public void mouseDragged(MouseEvent e) {
        if (wall != null) {
            Point p = Display.toMapCoordinate(e.getX(),  e.getY());
            int x = p.x;
            int y = p.y;

            wall.setX(x);
            wall.setY(y);
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (wall == null && e.getButton() == 1) {
            int size = 2;
            Point p = Display.toMapCoordinate(e.getX(),  e.getY());
            int x = p.x;
            int y = p.y;
            Rectangle r = new Rectangle(x - size / 2, y - size / 2, size, size);

            wall = getCollision(r);
            if(wall != null && Keyboard.getKey(KeyEvent.VK_CONTROL)){
                wall = wall.copy();
                addObject(wall);
            }


            if(wall != null && Keyboard.getKey(KeyEvent.VK_E)){
                editor.editWall(wall);
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        wall = null;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (Keyboard.getKey(KeyEvent.VK_CONTROL) & Keyboard.getKey(KeyEvent.VK_S)) {
            try {
                loader.saveToFile(getObjects());
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Ошибка сохранения!!!");
            }
        }

    }

}
