package root.model.Wall;

import root.controllers.Editors.FactoryInterface;

import java.awt.*;

public class FactoryWall implements FactoryInterface<Wall> {

    public Wall getInstance(TypeObject type, Point location, Dimension dimension){
        switch (type){
            case ROCK: return new RockWall(location, dimension);
            case STEEL: return new SteelWall(location, dimension);
            case WOOD: return new WoodWall(location, dimension);
            case BRICK: return new BrickWall(location, dimension);
            case ARMORED: return new ArmoredWall(location,dimension);
            default: return new Wall(location.getX(),location.getY(), dimension.getWidth(), dimension.getHeight(), 10);
        }
    }

    public Wall copy(Wall w, TypeObject type){
        return getInstance(type,w.getLocation(),w.getDimension());
    }





}
