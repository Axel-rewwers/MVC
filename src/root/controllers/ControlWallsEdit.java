package root.controllers;

import root.controllers.Editors.EditorWall;
import root.controllers.Editors.SwitchListener;
import root.model.Wall.FactoryWall;
import root.model.Wall.Wall;
import root.utils.Display;
import root.utils.Keyboard;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class ControlWallsEdit extends ControlWalls {

//    private Editor editor;
    private EditorWall<Wall> editor;

    public ControlWallsEdit() {
//        editor = new Editor();
        editor = new EditorWall<>("Отредактируйте стену");
        editor.setSwitchListener(new ReplaceWallListener());
        FactoryWall factoryWall = new FactoryWall();
        editor.setFactoryObject(factoryWall);
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
                Keyboard.setKeys(KeyEvent.VK_CONTROL, false);
            }


            if(wall != null && Keyboard.getKey(KeyEvent.VK_E)){
                editor.edit(wall);
                Keyboard.setKeys(KeyEvent.VK_E, false);
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
                save();
                System.out.println("save");
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Ошибка сохранения!!!");
            }
        }

    }


    private class ReplaceWallListener implements SwitchListener<Wall> {
        @Override
        public void switchObjects(Wall remove, Wall add) {
            removeObject(remove);
            addObject(add);
        }
    }

}
