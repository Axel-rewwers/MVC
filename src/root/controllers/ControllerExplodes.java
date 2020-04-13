package root.controllers;

import root.model.Explode;
import root.viewers.VExplode;
import root.viewers.VExplodeImage;

public class ControllerExplodes extends ControlObject<Explode> {


    public ControllerExplodes() {
        setViewer(new VExplodeImage());
    }


    @Override
    public void update() {
        super.update();

        for (int i = 0; i < getObjects().size(); i++) {
            if(!getObjects().get(i).isAlive()){
                removeObject(getObjects().get(i));
            }
        }
    }
}
