package Revise;

import java.io.*;

public class DataStrm {
    public static void main(String[] argc){
        File file = new File("scrap/file.txt");
        if (file.exists()){
            System.out.println("file already exist " + file.getName());
            System.out.println("file already exist at " + file.getPath());
        }else {
            try {
                if (file.createNewFile()){
                    System.out.println("File created");
                }else {
                    System.out.println("cannot creat file " + file.getName());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file.getPath(),true));
            dataOutputStream.writeInt(72);
            dataOutputStream.writeDouble(78.9);
            dataOutputStream.writeFloat(0.96f);
            dataOutputStream.close();


            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file.getPath()));
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readFloat());
            dataInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
