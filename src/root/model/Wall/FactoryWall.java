package root.model.Wall;

import java.awt.*;

public class FactoryWall {

    public Wall getInstance(TypeWall type, Point location, Dimension dimension){
        switch (type){
            case ROCK: return new RockWall(location, dimension);
            case STEEL: return new SteelWall(location, dimension);
            case WOOD: return new WoodWall(location, dimension);
            case BRICK: return new BrickWall(location, dimension);
            default: return new Wall(location.getX(),location.getY(), dimension.getWidth(), dimension.getHeight(), 10, false);
        }
    }

    public Wall copy(Wall w, TypeWall type){
        return getInstance(type,w.getLocation(),w.getDimension());
    }





}
