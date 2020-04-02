package root.controllers;

import root.model.Bullet;
import root.viewers.VBullet;


public class ControllerBullet extends ControlObject<Bullet> {


    public ControllerBullet() {
        setViewer(new VBullet());
    }



}
