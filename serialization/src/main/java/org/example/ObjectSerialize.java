package org.example;

import java.io.*;

public class ObjectSerialize {

    public void serializeToFile(Object object, String nameFile) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(nameFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
    }

    public Object deserializeFromFile(String nameFile) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(nameFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        return object;
    }

}
