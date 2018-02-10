package Revise;

import java.io.FileInputStream;

public class InStream {
    public static void main(String[] argc){
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream("file.txt");
            int data = inputStream.read();
            while (data != -1){
                System.out.print((char)data);
                data = inputStream.read();
            }
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
