package root.model.Turret;

import root.controllers.Editors.FactoryInterface;
import root.model.Wall.TypeObject;

import java.awt.*;

public class FactoryTurret implements FactoryInterface<Turret> {
    public Turret getInstance(TypeObject type, Point location, Dimension dimension){
        switch (type){
            case ROCK: return new RockTurret(location, dimension);
            case STEEL: return new SteelTurret(location, dimension);
            case WOOD: return new WoodTurret(location, dimension);
            case BRICK: return new BrickTurret(location, dimension);
            case ARMORED: return new ArmoredTurret(location,dimension);
            default: return new Turret(location.getX(),location.getY(), dimension.getWidth(), 10);
        }
    }

    public Turret copy(Turret w, TypeObject type){
        return getInstance(type,w.getLocation(),w.getDimension());
    }
}
