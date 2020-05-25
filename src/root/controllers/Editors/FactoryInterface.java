package root.controllers.Editors;

import root.model.BreakableObject;
import root.model.Wall.TypeObject;

import java.awt.*;

public interface FactoryInterface<T extends BreakableObject> {

    T getInstance(TypeObject type, Point location, Dimension dimension);
}
