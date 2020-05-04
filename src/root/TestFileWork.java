package root;

import java.io.*;

public class TestFileWork {
//11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111

    public static void main(String[] path) {
        int[] sts = new int[10];int[] stsO = new int[10];int[] stsP = new int[10];
        int st = 0;int stO = 0;int stP = 0;

// считывание/////////////////////////////////////////////////////////////////
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("C:\\test\\in.txt");
            String out = "";
            int c;
            int num = 0;

            boolean minus = false;

            //1234
            while ((c = fileReader.read()) != -1) {

                if((char)c != ' ' & (char)c != '-') {
                    num = num * 10 + c - '0';
                }

                if((char)c == '-'){
                    minus = true;
                }


                 if((char)c == ' ') {
                     if(minus){
                         num = num*-1;
                         minus = false;
                     }
                    System.out.print(num + " ");
                    sts[st] = num;
                    st++;
                    num = 0;
                }

            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//сщртировка/////////////////////////////////////////////////////////////////
        for (int i = 0; i < st ; i++) {
            if (sts[i] >= 0) {
               stsP[stP] = sts[i];
               stP++;
            } else {
                stsO[stO] = sts[i];
                stO++;
            }

        }

//вывод////////////////////////////////////////////////////////////////////////////
//        положительных
        try {
            FileWriter fileWriter = new FileWriter("C:\\test\\test+.txt");
            for(int i = stP-1;i >=0;i--) {
                fileWriter.write(stsP[i] + " ");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        отрицательных
        try {
            FileWriter fileWriter = new FileWriter("C:\\test\\test-.txt");
            for(int i = stO-1;i >=0;i--) {
                fileWriter.write(stsO[i] + " ");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
//public static void main(String[] path) {
//    int[] sts = new int[100];int[] stsP = new int[100];
//    int st = 0;int stP = 0;
//
//// считывание/////////////////////////////////////////////////////////////////
//    FileReader fileReader = null;
//    try {
//        fileReader = new FileReader("C:\\test\\in.txt");
//        String out = "";
//        int c;
//        int num = 0;
//
//        //1234
//        while ((c = fileReader.read()) != -1) {
//
//            if((char)c != ' ' ){
//                num = num * 10 + c - '0';
//            } else {
//                System.out.print(num + " ");
//                sts[st] = num;
//                st++;
//                num = 0;
//            }
//
//        }
//        fileReader.close();
//
//    } catch (FileNotFoundException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
////сщртировка/////////////////////////////////////////////////////////////////
//    stsP[0] = sts[0];
//    stsP[st-1] = sts[st-1];
//    for (int i = 1; i < st-1 ; i++) {
//        stsP[i] = (sts[i-1] + sts[i] + sts[i+1])/3;
//        stP++;
//    }
//
////вывод////////////////////////////////////////////////////////////////////////////
////        положительных
//    try {
//        FileWriter fileWriter = new FileWriter("C:\\test\\test.txt");
//        for (int i = 0; i <stP +2; i++) {
//            fileWriter.write(stsP[i] + " ");
//        }
//        fileWriter.flush();
//        fileWriter.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}


//    String path = "walls.map";
//
//        Wall wall = new Wall(0, -GamePanel.HEIGHT * 2, 10);
//        wall.setDimension(GamePanel.WIDTH * 2, 20);
//        wall.setUnbreakable(true);
//
//        Wall wall2 = new Wall(0, -GamePanel.HEIGHT * 2, 10);
//        wall2.setDimension(GamePanel.WIDTH * 2, 20);
//        wall2.setUnbreakable(true);
//
//
//        TestFileWork fileWork = new TestFileWork();
//
//        try {
//            ArrayList<Wall> w = new ArrayList<>();
//            w.add(wall);
//            w.add(wall2);
//
//            fileWork.saveWallToFile(w, path);
//
//
//            ArrayList<Wall> walls = fileWork.loadWallsFromFile(path);
//
//            System.out.println(walls.get(0).equals(walls.get(1)));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//    public ArrayList<Wall> loadWallsFromFile(String path) throws IOException {
//        ArrayList<Wall> walls = new ArrayList<>();
//
//        FileReader fileReader = new FileReader(path);
//
//        String out = "";
//        int c;
//        while ((c = fileReader.read()) != -1) {
//
//            if(((char) c) != '|'){
//                out += (char) c;
//            } else {
//                String[] res = out.split(" ");
//
//                double x = Double.parseDouble(res[0]);
//                double y = Double.parseDouble(res[1]);
//                double width = Double.parseDouble(res[2]);
//                double height = Double.parseDouble(res[3]);
//                int healthPoint = Integer.parseInt(res[4]);
//                boolean unbreak = Boolean.parseBoolean(res[5]);
//
//                Wall wall;
////          создать файл из данных, считанных из файла
//                wall = new Wall(x, y, healthPoint);
//                wall.setDimension(width, height);
//                wall.setUnbreakable(unbreak);
//
//
//                walls.add(wall);
//
//                out = "";
//            }
//        }
//
//        return walls;
//    }
//
//
//    public void saveWallToFile(ArrayList<Wall> walls, String path) throws IOException {
//        FileWriter fileWriter = new FileWriter(path);
//        for (int i = 0; i < walls.size(); i++) {
//            Wall wall = walls.get(i);
//
//            String out = wall.getX()
//                    + " " + wall.getY()
//                    + " " + wall.getWidth()
//                    + " " + wall.getHeight()
//                    + " " + wall.getHealthPoint()
//                    + " " + wall.isUnbreakable() + " |";
//            fileWriter.append(out);
//        }
//
//        fileWriter.flush();
//        fileWriter.close();
//    }
//
//}
}
