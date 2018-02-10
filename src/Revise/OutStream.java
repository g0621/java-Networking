package Revise;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class OutStream {
    public static void main(String[] argc){
        try {
            FileInputStream inputStream = new FileInputStream("scrap/file.txt");
            FileOutputStream outputStream = new FileOutputStream("scrap/output.txt",true);
            int data = inputStream.read();
            while (data != -1){
                outputStream.write((char)data);
                data = inputStream.read();
            }
            outputStream.close();
            inputStream.close();
//            String s = "Yes this is complete bullshit";
//            outputStream.write(s.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
