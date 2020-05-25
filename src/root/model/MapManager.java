package root.model;


import root.controllers.*;
import root.model.Turret.Turret;
import root.model.Wall.Wall;
import root.utils.Display;

import javax.swing.*;
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
    private Image image;
    private String path = "C:\\Users\\poloz\\IdeaProjects\\MVC\\res\\images\\Map\\4.png";

    public MapManager() {
        controlObjects = new ArrayList<>();

        image = new ImageIcon(path).getImage();


        tank = new Tank(-900, 900, 3);
        tank.setHeight(50);
        tank.setWidth(50);

//        contrlTank = new CtrlTank(tank);
        contrlTank = new ControlTankEdit(tank);
        controlWalls = new ControlWallsEdit();
//        controlWalls = new ControlWalls();



        FireListener fireListener = new FireListener();

        ctrlTurret = new CtrlTurretEdit();
        ctrlTurret.setFireListener(fireListener);

        Turret turret = new Turret(500,500,50,50);
        ctrlTurret.addObject(turret);

        Turret turret1 = new Turret(500,250,50,50);
        ctrlTurret.addObject(turret1);
        turret1.setDirection(Direction.DOWN);


        controlBullet = new ControllerBullet();

        contrlTank.setFireListener(fireListener);


        controllerExplodes = new ControllerExplodes();

        controlObjects.add(controlBullet);
        controlObjects.add(controlWalls);
        controlObjects.add(ctrlTurret);
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
        Turret turret = ctrlTurret.getCollision(tank.getRectangle());
        if(turret != null){
            tank.impact();
        }


        //пробегаемся по всем пулям и проверям коллизию стена-пуля
        ArrayList<Bullet> bullets = controlBullet.getObjects();
        for (int j = 0; j < bullets.size(); j++) {
            Bullet b = bullets.get(j);

            checkCollision(controlWalls, b);

            checkCollision(ctrlTurret, b);

            checkCollision(contrlTank, b);
        }


    }


    //подходят контроллеры любых наследников класса breakableObject
    private <T extends BreakableObject> void checkCollision(ControlObject<T> ctrlObject, Bullet b){
        T object = ctrlObject.getCollision(b.getRectangle());

        if (object != null && object != b.getOwner()) {
            object.hit(b.getDamage());
            Explode explode = new Explode(b.getX(), b.getY(), 50,50);
            controllerExplodes.addObject(explode);
            controlBullet.removeObject(b);
        }
    }



    private void drawBackground(Graphics2D g){

        Model map = new Model(0, 0, 2000, 2000);

        Point p = Display.toWindowCoordinate(map.getX(), map.getY());

        int x = p.x;
        int y = p.y;
        int width = (int) Display.toScale(map.getWidth());
        int height = (int) Display.toScale(map.getHeight());


        g.drawImage(image, x-width/2,y-height/2, width, height, null);
    }

    public void render(Graphics2D g) {

        drawBackground(g);

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
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).mouseMoved(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).mouseEntered(e);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).mouseExited(e);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).keyTyped(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (int i = 0; i < controlObjects.size(); i++) {
            controlObjects.get(i).keyReleased(e);
        }
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

