package root.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Loader<T> {
    private String path;

    public Loader(String path) {
        this.path = path;
    }

    public ArrayList<T> loadFromFile() throws IOException, ClassNotFoundException {
        ArrayList<T> list = new ArrayList<>();

        File file = new File(path);

        if(file.exists()){
            FileInputStream fileInputStream = new FileInputStream(file);


            ObjectInputStream stream = new ObjectInputStream(fileInputStream);

            list.addAll((Collection<? extends T>) stream.readObject());
        }

        return list;
    }


    public void saveToFile(ArrayList<T> t) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream stream = new ObjectOutputStream(fileOutputStream);

        stream.writeObject(t);

        stream.flush();
        stream.close();
    }



}
