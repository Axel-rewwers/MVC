package root.viewers;

import root.model.Tank;
import root.utils.Display;

import java.awt.*;

public class VTank implements ViewerObject<Tank> {

    public VTank() {

    }
    int u= 0;
    int [] tover = new int [7];
    int [] line = new int [45];

    @Override
    public void  render(Graphics2D g, Tank tank) {
        //рисуем танк

//        int x = (int) tank.getLocation().getX();
//        int y = (int) tank.getLocation().getY();


        Point p = Display.toWindowCoordinate(tank.getX(), tank.getY());

        int x = p.x;
        int y = p.y;

        int width = (int) Display.toScale(tank.getWidth());
        int height = (int) Display.toScale(tank.getHeight());
//
//        int otkl = 20;
//        int otcl1 = 5;
//        for(int i = 0;i<tover.length;i++){
//            if(u < tover.length){
//                tover[i] = otkl;
//                otkl+=20;
//                u++;
//            }
//        }
//        for(int i = 0;i<line.length;i++){
//            if(u < line.length){
//                line[i] = otcl1;
//                otcl1+=5;
//                u++;
//            }
//        }


        int width3 = width / 4;
        int height3 = height;
        int caterplillarX = x;
        int caterplillarY = y;
        int barrelChangeX = x - width / 11;
        int barrelChangeY = y - height / 2;
        int barrelChangeWidth = width / 6;
        int barrelChangeHeight = height / 2 + height / 10;

        int changeBaseTankX = x - width/2 + width/15;
        int changeBaseTankY = y-height/2 + height/3;
        int changeBaseTankWidth = width - width/8;
        int changeBaseTankHeigth = height - height/3;

        switch (tank.getDirection()) {
            case UP:
                width3 = width / 4;
                height3 = height;
                caterplillarX = x + width / 2 - width3;
                caterplillarY = y - height / 2;
                barrelChangeX = x - width / 11;
                barrelChangeY = y - height / 2;
                barrelChangeWidth = width / 6;
                barrelChangeHeight = height / 2 + height / 10;

                changeBaseTankX = x - width/2 + width/15;
                changeBaseTankY = y-height/2 + height/3;
                changeBaseTankWidth = width - width/8;
                changeBaseTankHeigth = height - height/3;


                break;
            case RIGHT:
                width3 = width;
                height3 = height / 4;
                caterplillarX = x - width / 2;
                caterplillarY = y + height / 2 - height / 4;
                barrelChangeX = x - width / 11;
                barrelChangeY = y - width / 11;
                barrelChangeWidth = width / 2 + width / 10;
                barrelChangeHeight = height / 6;

                changeBaseTankX = x - width/2 + width/30;
                changeBaseTankY = y-height/2 + height/15;
                changeBaseTankWidth = width - width/3;
                changeBaseTankHeigth = height - height/8;
                break;

            case LEFT:
                width3 = width;
                height3 = height / 4;
                caterplillarX = x - width / 2;
                caterplillarY = y + height / 2 - height / 4;
                barrelChangeX = x - width / 2;
                barrelChangeY = y - width / 11;
                barrelChangeWidth = width / 2 + width / 10;
                barrelChangeHeight = height / 6;

                changeBaseTankX = x  - width/5;
                changeBaseTankY = y-height/2 + height/15;
                changeBaseTankWidth = width - width/3;
                changeBaseTankHeigth = height - height/8;

                break;
            case DOWN:
                width3 = width / 4;
                height3 = height;
                caterplillarX = x + width / 2 - width3;
                caterplillarY = y - height / 2;
                barrelChangeX = x - width / 11;
                barrelChangeY = y - height / 11;
                barrelChangeWidth = width / 6;
                barrelChangeHeight = height / 2 + height / 10;

                changeBaseTankX = x - width/2 + width/15;
                changeBaseTankY = y-height/2 - height/30;
                changeBaseTankWidth = width - width/8;
                changeBaseTankHeigth = height - height/3;
                break;
        }

        // исуем гусиницу


//        g.setColor(Color.red);
//        g.drawRect(x-width/2,y-height/2,width,height);
//         исуем гусиницу
        g.setColor(Color.black);
        g.fillRect(x - width/2, y-height/2,width3,height3);//левая
        g.fillRect(caterplillarX,caterplillarY ,width3,height3);//правая
        // основание танка
        g.setColor(Color.green.darker());
        g.fillOval(changeBaseTankX,changeBaseTankY,changeBaseTankWidth,changeBaseTankHeigth);
        // башня танка
        g.setColor(Color.green.brighter());
        g.fillRect(x - width/2+ width/4  + width/40,y-height/2+ height/4,width- width/2,height- height/2);
        g.setColor(Color.black);
        g.drawRect(x - width/2+ width/4 + width/40,y-height/2+ height/4,width- width/2,height- height/2);

        //дуло танка
        g.setColor(Color.green.brighter());
        g.fillRect(barrelChangeX,barrelChangeY,barrelChangeWidth,barrelChangeHeight);
        g.setColor(Color.black);
        g.drawRect(barrelChangeX,barrelChangeY,barrelChangeWidth,barrelChangeHeight);


//        //ЗАМОК
        //кусты
//        g.setColor(Color.green.darker());
//        g.fillRect(x-width/2,y-height/2,width,height);
//        g.setColor(Color.green);
//        for (int i = 0;i < 4;i++) {
//            g.fillOval(x + width/2 - width/3, y + height/2 - height/10 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x + width/2 - width/3, y + height/2 - height/7 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x + width/2 - width/3 - width/50, y + height/2 - height/8 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x + width/2 - width/3 + width/30, y + height/2 - height/8 - tover[i] * 2, width / 20, height / 20);
//
//            g.fillOval(x - width/2 + width/3 -width/20, y + height/2 - height/10 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x - width/2 + width/3 - width/20, y + height/2 - height/7 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x - width/2 + width/3  - width/40, y + height/2 - height/8 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x - width/2 + width/3 - width/30 -width/20, y + height/2 - height/8 - tover[i] * 2, width / 20, height / 20);
//        }
//        for (int i = 0;i < 4;i++) {
//            g.fillOval(x + width/2 - width/ 25, y + height/2 - height/10 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x + width/2 - width/ 15, y + height/2 - height/15 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x + width/2 - width/ 15, y + height/2 - height/8 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x - width/2 - width/100,y + height/2 - height/10 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x - width/2 + width/ 50, y + height/2 - height/15 - tover[i] * 2, width / 20, height / 20);
//            g.fillOval(x - width/2 + width/50, y + height/2 - height/8 - tover[i] * 2, width / 20, height / 20);
//        }
//        //крыша
//        g.setColor(Color.red);
//        g.fillRect(x-width/2 + width/10,y+height/2-height/3 -height/25,width - width/5,height/6);
//        g.setColor(Color.red.darker());
//        g.fillRect(x-width/25,y-height/2,width/10,height - height/3);
//        g.setColor(Color.black);
//        g.drawRect(x-width/2 + width/10,y+height/2-height/3 - height/25,width - width/5,height/12);
//        g.drawRect(x-width/2 + width/10,y+height/2-height/3 + height/25,width - width/5,height/12);
//        g.setColor(Color.red);
//        g.fillRect(x-width/2 + width/3,y+height/2-height/3 -height/16,width/3,height/5);
//        g.setColor(Color.black);
//        g.drawRect(x-width/2 + width/3,y+height/2-height/3 -height/16,width/3,height/5);
//        g.drawRect(x-width/2 + width/3,y+height/2-height/3 -height/16,width/3,height/10);
//        for(int i = 0; i<line.length; i++){
//            g.drawLine(x-width/2 + width/10  +line[i],y+height/2-height/3 -height/25,x-width/2  + width/10 +line[i],y+height/2-height/5 -height/50);
//        }
//                //стены
//        g.setColor(Color.gray.darker());
//        g.fillRect(x - width/2 + width/20,y-height/2 + height/8,width/8,height - height/4);
//        g.fillRect(x + width/2 - width/8 - width/20,y-height/2  +height/8,width/8,height - height/4);
//        g.fillRect(x - width/2  + width/8,y-height/2  +height/20,width - width/4,height/8);
//        g.fillRect(x - width/2  + width/8,y+height/2  -height/8 - height/20,width - width/4,height/8);
//        g.setColor(Color.black);
//        for (int i = 0;i < tover.length;i++){
//            g.fillRect(x - width/2 + width/6 +tover[i],y+height/2- height/6 ,width/20,height/40);
//            g.fillRect(x - width/2 + width/6 +tover[i],y+height/2- height/12 ,width/20,height/40);
//            g.fillRect(x + width/2 - width/12 ,y-height/2+ height/7 + tover[i],width/40,height/20);
//            g.fillRect(x + width/2 - width/8 - width/20,y-height/2+ height/7 + tover[i],width/40,height/20);
//            g.fillRect(x - width/2  + width/7,y-height/2+ height/7 + tover[i],width/40,height/20);
//            g.fillRect(x - width/2 + width/20,y-height/2+ height/7 + tover[i],width/40,height/20);
//            g.fillRect(x - width/2 + width/6 +tover[i],y-height/2 + height/7 ,width/20,height/40);
//            g.fillRect(x - width/2 + width/6 +tover[i],y-height/2 + height/15 ,width/20,height/40);
//        }
//         //вышки
//        g.setColor(Color.red);
//        g.fillOval(x - width/2 - width/250 ,y-height/2  - height/100 ,width/3 - tover.length*2 ,height/3 - tover.length*2);
//        g.fillOval(x + width/2 - width/4 - width/100 ,y-height/2  - height/100 ,width/3 -tover.length*2,height/3 - tover.length*2 );
//        g.fillOval(x - width/2 - width/95,y+height/2- height/4 - height/50 ,width/3 - tover.length*2  ,height/3- tover.length*2);
//        g.fillOval(x + width/2 - width/4 - width/100 ,y+height/2  - height/4 - height/50 ,width/3 -tover.length*2,height/3 - tover.length*2 );
//
//
//        //замок
//        g.fillRect(x-width/2 + width/10,y+height/2-height/10,width/10,height/10);
//        g.setColor(Color.black);
//        for (int i = 0;i < 7;i++){
//            g.drawOval(x - width/2 - width/95+ tover[i]/4,y-height/2  - height/50 + tover[i]/4,width/3 - width/25 - tover[i]/2 ,height/3- height/25-tover[i]/2);
//            g.drawOval(x - width/2 - width/80+ tover[i]/4,y+height/2 -height/4 - height/30 + tover[i]/4,width/3 - width/25 - tover[i]/2 ,height/3- height/25-tover[i]/2);
//            g.drawOval(x + width/2 - width/4 - width/60+ tover[i]/4,y-height/2 -height/50 + tover[i]/4,width/3 -width/25- tover[i]/2,height/3 - height/25- tover[i]/2);
//            g.drawOval(x + width/2 - width/4 - width/60+ tover[i]/4,y+height/2 -height/4 - height/30 + tover[i]/4,width/3 -width/25- tover[i]/2,height/3 - height/25- tover[i]/2);
//
//        }
//
//    }

    }
}
