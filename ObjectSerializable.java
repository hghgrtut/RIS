package org.example;

import java.io.*;

public class ObjectSerializable {

    public boolean serializableToFile(String path, Object object) {
        try {
            //Сериализация в файл с помощью класса ObjectOutputStream
            FileOutputStream fileOutputStream = fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object deserializeFromFile(String path) {
        try {
            // Востановление из файла с помощью класса ObjectInputStream
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
