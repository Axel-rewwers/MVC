package root.controllers;

import root.controllers.Editors.EditorTurret;
import root.controllers.Editors.SwitchListener;
import root.model.Turret.FactoryTurret;
import root.model.Turret.Turret;
import root.model.Wall.Wall;
import root.utils.Display;
import root.utils.Keyboard;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class CtrlTurretEdit extends CtrlTurret {
    private EditorTurret editor;

    public CtrlTurretEdit() {
        editor = new EditorTurret("turret");
        editor.setSwitchListener(new ReplaceTurretListener());
        editor.setFactoryObject(new FactoryTurret());
    }


    private Turret turret;

    @Override
    public void mouseDragged(MouseEvent e) {
        if (turret != null) {
            Point p = Display.toMapCoordinate(e.getX(),  e.getY());
            int x = p.x;
            int y = p.y;

            turret.setX(x);
            turret.setY(y);
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (turret == null && e.getButton() == 1) {
            int size = 2;
            Point p = Display.toMapCoordinate(e.getX(),  e.getY());
            int x = p.x;
            int y = p.y;
            Rectangle r = new Rectangle(x - size / 2, y - size / 2, size, size);

            turret = getCollision(r);
            if(turret != null && Keyboard.getKey(KeyEvent.VK_CONTROL)){
                turret = (Turret) turret.copy();
                addObject(turret);
            }


            if(turret != null && Keyboard.getKey(KeyEvent.VK_E)){
                editor.edit(turret);
                Keyboard.setKeys(KeyEvent.VK_E, false);
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        turret = null;
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







    private class ReplaceTurretListener implements SwitchListener<Wall> {
        @Override
        public void switchObjects(Wall remove, Wall add) {
            if(remove instanceof Turret && add instanceof Turret) {
                removeObject((Turret) remove);
                addObject((Turret) add);
            }
        }
    }
}
