package root.controllers;

import root.model.Turret;
import root.viewers.VTurret;




public class CtrlTurret extends ControlObject<Turret> {

    public CtrlTurret() {
//        setPath("turret_v1.map");
        setViewer(new VTurret());


//        try {
//            addObject(loadWallsFromFile(getPath()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
