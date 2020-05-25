package root.controllers;

import root.model.Wall.FactoryWall;
import root.model.Wall.TypeObject;
import root.model.Wall.Wall;
import root.utils.Loader;
import root.viewers.VWallImage;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ControlWalls extends ControlObject<Wall> {


    private Loader<Wall> loader;


    public ControlWalls() {
        setViewer(new VWallImage());


        loader = new Loader<>();
//        loader.setPath("walls_v1.map");
//        try {
//            addObject(loader.loadFromFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        FactoryWall factoryWall = new FactoryWall();
//        Wall wall = new Wall(100,100,20,200,100,false);
//
        addObject(factoryWall.getInstance(TypeObject.STEEL, new Point(0,100), new Dimension(20, 200)));


    }

    @Override
    public void update() {
        ArrayList<Wall> walls = getObjects();
        for (int i = 0; i < walls.size(); i++) {
            Wall wall = walls.get(i);
            wall.update();

            if(!wall.isAlive()){
                removeObject(wall);
            }
        }
    }


    public void save() throws IOException {
        loader.saveToFile(getObjects());
    }

}
