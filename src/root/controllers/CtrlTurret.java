package root.controllers;

import root.model.Turret;
import root.viewers.VTurret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class CtrlTurret extends ControlObject<Turret> {
    private ActionListener fireListener;


    public CtrlTurret() {

        setViewer(new VTurret());
    }

    @Override
    public void update() {
        ArrayList<Turret> turrets = getObjects();
        for (int i = 0; i < turrets.size(); i++) {
            Turret turret = turrets.get(i);
            turret.update();
            if(fireListener != null && turret.readyToFire()){
                fireListener.actionPerformed(new ActionEvent(turret, 0, "fire"));
            }
        }
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }


    public void setFireListener(ActionListener fireListener) {
        this.fireListener = fireListener;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
