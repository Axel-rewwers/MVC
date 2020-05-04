package root.graphics;


import root.controllers.Controller;
import root.controllers.ControllerDisplay;
import root.model.*;
import root.viewers.VMap;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 650;
    private MapManager mapManager;
    private VMap vMap;

    private Graphics2D g;

    private BufferedImage image;

    private JButton btnF1;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        setFocusable(true);


        mapManager = new MapManager();
        vMap = new VMap();



        Controller controller = new Controller();
        addMouseListener(controller);
        addKeyListener(controller);
        addMouseWheelListener(controller);
        addMouseMotionListener(controller);

        controller.addController(mapManager.getContrlTank());



        addMouseMotionListener(mapManager);
        addMouseListener(mapManager);
        addKeyListener( mapManager);
        ControllerDisplay controllerDisplay = new ControllerDisplay();

        controller.addController(controllerDisplay);


        btnF1 = new JButton("F1");



    }




    @Override
    public void run() {

        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        while (true) {

            //обновляем
            update();
            //отрисовываем
            render();
            //спим
            try {
                Thread.sleep(1000 / 40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void update() {
        mapManager.update();
    }


    private void render() {
        drawBackground();
        vMap.render(g, mapManager);

        drawImage();

    }

    private void drawBackground() {
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    private void drawImage() {
        this.getGraphics().drawImage(image, 0, 0, null);
    }

    public void start() {
        new Thread(this).start();
    }
}
