package Revise;

import java.io.*;

public class ChracterStream {
    public static void main(String[] argc) {
        try {
            //Maps the input with its built in character map and writes the character
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("scrap/output.txt"), "UNICODE");
            InputStreamReader in = new InputStreamReader(new FileInputStream("scrap/output.txt"), "UNICODE");

            System.out.println(out.getEncoding());
            out.write("Hello darkness be my friend\n");

            //If used ascii in line 9 instead then cant write this
            out.write("你好");

            //write just adds to the buffer flush sends to the file
            out.flush();


            //we cannot write to file after it is closed. but flush don't close file
            out.write("\nhelp me");
            out.close();


            int data = in.read();
            while (data != -1) {
                System.out.print((char) data);
                data = in.read();
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
