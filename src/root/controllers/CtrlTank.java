package root.controllers;

import root.model.Tank;
import root.viewers.VTank;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CtrlTank extends ControlObject<Tank> {
    private Tank mainTank;

    public CtrlTank(Tank mainTank) {
        this.mainTank = mainTank;
        addObject(mainTank);
        setViewer(new VTank());

//        loader = new Loader<>("tanks_v1.map");
//
//        try {
//            addObject(loader.loadFromFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void update() {
        ArrayList<Tank> tanks = getObjects();
        for (int i = 0; i < tanks.size(); i++) {
            Tank tank = tanks.get(i);
            tank.update();

//            if(tank.getState() == 0){
//                removeObject(tank);
//            }
        }
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                mainTank.goForward();
                mainTank.go();
                break;

            case KeyEvent.VK_DOWN:
                mainTank.goBackward();
                mainTank.go();
                break;

            case KeyEvent.VK_RIGHT:
                mainTank.goRight();
                mainTank.go();
                break;

            case KeyEvent.VK_LEFT:
                mainTank.goLeft();
                mainTank.go();
                break;
            case KeyEvent.VK_SPACE:
                mainTank.fire();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT ||
                e.getKeyCode() == KeyEvent.VK_RIGHT ||
                e.getKeyCode() == KeyEvent.VK_DOWN ||
                e.getKeyCode() == KeyEvent.VK_UP) {
            mainTank.stop();
        }
    }
}
