package root.model;


import root.controllers.*;
import root.graphics.GamePanel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MapManager implements MouseMotionListener, MouseListener, KeyListener {


    private ArrayList<ControlObject> controlObjects;

    private CtrlTank contrlTank;
    private ControlWalls controlWalls;
    private CtrlTurret ctrlTurret;
    private ControllerBullet controlBullet;
    private ControllerExplodes controllerExplodes;

    private Tank tank;

//    private static ArrayList<Bullet> bullets;


    public MapManager() {
        controlObjects = new ArrayList<>();


        tank = new Tank(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2, 3);
        tank.setHeight(50);
        tank.setWidth(50);

        contrlTank = new CtrlTank(tank);
        controlWalls = new ControlWalls();


//        bullets = new ArrayList<>();

        FireListener fireListener = new FireListener();

        ctrlTurret = new CtrlTurret();
        ctrlTurret.setFireListener(fireListener);

        Turret turret = new Turret(500,500,50,50,false);
        ctrlTurret.addObject(turret);



        controlBullet = new ControllerBullet();

        contrlTank.setFireListener(fireListener);


        controllerExplodes = new ControllerExplodes();

        controlObjects.add(controlWalls);
        controlObjects.add(ctrlTurret);
        controlObjects.add(controlBullet);
        controlObjects.add(contrlTank);
        controlObjects.add(controllerExplodes);

    }


    public void update() {


        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).update();
        }


        //пересечение танка и стен
        Wall wall = controlWalls.getCollision(tank.getRectangle());
        if (wall != null) {
            tank.impact();
        }


        //пробегаемся по всем пулям и проверям коллизию стена-пуля
        ArrayList<Bullet> bullets = controlBullet.getObjects();
        for (int j = 0; j < bullets.size(); j++) {
            Bullet b = bullets.get(j);

            wall = controlWalls.getCollision(b.getRectangle());
            if (wall != null) {
                wall.hit(bullets.get(j).getDamage());
                Explode explode = new Explode(b.getX(), b.getY(), 50,50);
                controllerExplodes.addObject(explode);
                controlBullet.removeObject(b);
            }
        }


    }


    public void render(Graphics2D g) {
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).render(g);
        }
    }


    public Tank getTank() {
        return tank;
    }

    public CtrlTank getContrlTank() {
        return contrlTank;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        controlWalls.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        controlWalls.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        controlWalls.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        controlWalls.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        controlWalls.keyReleased(e);
    }






    private class FireListener<T extends Fireable> implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            T shooter = (T) e.getSource();
            Bullet b = shooter.fire();
            if (b != null) {
                controlBullet.addObject(b);
            }
        }
    }

}

