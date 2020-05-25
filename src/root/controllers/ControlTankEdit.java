package root.controllers;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import root.controllers.Editors.EditorTank;
import root.model.Tank;
import root.utils.Display;
import root.utils.Keyboard;

public class ControlTankEdit extends CtrlTank {
    private EditorTank editor;

    public ControlTankEdit(Tank mainTank) {
        super(mainTank);
        editor = new EditorTank("Tank");
//        editor.setSwitchListener(new Replace);
    }
    private Tank tank;

    @Override
    public void mouseDragged(MouseEvent e) {
        if (tank != null) {
            Point p = Display.toMapCoordinate(e.getX(),  e.getY());
            int x = p.x;
            int y = p.y;

            tank.setX(x);
            tank.setY(y);
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (tank == null && e.getButton() == 1) {
            int size = 2;
            Point p = Display.toMapCoordinate(e.getX(),  e.getY());
            int x = p.x;
            int y = p.y;
            Rectangle r = new Rectangle(x - size / 2, y - size / 2, size, size);

            tank = getCollision(r);
//            if(tank != null && Keyboard.getKey(KeyEvent.VK_CONTROL)){
//                addObject((Tank) tank);
//            }


            if(tank != null && Keyboard.getKey(KeyEvent.VK_E)){
                editor.edit(tank);
                Keyboard.setKeys(KeyEvent.VK_E, false);
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        tank = null;
    }


//    @Override
//    public void keyPressed(KeyEvent e) {
////        if (Keyboard.getKey(KeyEvent.VK_CONTROL) & Keyboard.getKey(KeyEvent.VK_S)) {
////            try {
//////                save();
////                System.out.println("save");
////            } catch (IOException ex) {
////                ex.printStackTrace();
////                System.out.println("Ошибка сохранения!!!");
//    }
}

