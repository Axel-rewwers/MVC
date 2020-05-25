package root.controllers;

import root.model.Direction;
import root.model.Model;
import root.model.Tank;
import root.viewers.VTankImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CtrlTank extends ControlObject<Tank> {
    private Tank mainTank;


    private ActionListener fireListener;

    public CtrlTank(Tank mainTank) {
        this.mainTank = mainTank;
        addObject(mainTank);
        setViewer(new VTankImage());
    }

    @Override
    public void update() {
        ArrayList<Tank> tanks = getObjects();
        for (int i = 0; i < tanks.size(); i++) {
            Tank tank = tanks.get(i);
            tank.update();
        }
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                mainTank.setDirection(Direction.UP);
                mainTank.go();
                break;

            case KeyEvent.VK_DOWN:
                mainTank.setDirection(Direction.DOWN);
                mainTank.go();
                break;

            case KeyEvent.VK_RIGHT:
                mainTank.setDirection(Direction.RIGHT);
                mainTank.go();
                break;

            case KeyEvent.VK_LEFT:
                mainTank.setDirection(Direction.LEFT);
                mainTank.go();
                break;
            case KeyEvent.VK_SPACE:
                if(fireListener != null){
                    fireListener.actionPerformed(new ActionEvent(mainTank, 0, "fire"));
                }

                break;
        }
    }


    public void setFireListener(ActionListener fireListener) {
        this.fireListener = fireListener;
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
