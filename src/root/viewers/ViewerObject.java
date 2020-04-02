package root.viewers;

import java.awt.*;

public interface ViewerObject<T> {

    void render(Graphics2D g, T t);

}
