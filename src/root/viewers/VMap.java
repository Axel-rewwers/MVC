package root.viewers;

import root.model.MapManager;

import java.awt.*;

public class VMap {


    public VMap() {
    }

    public void render(Graphics2D g, MapManager mapManager){


        mapManager.render(g);
    }

}
