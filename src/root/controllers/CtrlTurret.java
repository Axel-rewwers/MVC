package root.controllers;

import root.model.Turret.Turret;
import root.model.Wall.FactoryWall;
import root.model.Wall.TypeObject;
import root.model.Wall.Wall;
import root.utils.Loader;
import root.viewers.VTurret;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;


public class CtrlTurret extends ControlObject<Turret> {
    private ActionListener fireListener;
    private Loader<Turret> loader;

    public CtrlTurret() {

        setViewer(new VTurret());

        loader = new Loader<>();
        loader.setPath("turret_v1.map");
//        try {
//            addObject(loader.loadFromFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//                FactoryWall factoryWall = new FactoryWall();
////        Wall wall = new Wall(100,100,20,200,100,false);
////
//        addObject(factoryWall.getInstance(TypeObject.STEEL, new Point(0,100), new Dimension(20, 200)));

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

            if(!turret.isAlive()){
                removeObject(turret);
            }
        }
    }

    public void save() throws IOException {
        loader.saveToFile(getObjects());
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
