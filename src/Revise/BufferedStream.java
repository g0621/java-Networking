package Revise;


import java.io.*;

//BufferedInput byte streams
//BufferedReader character stream
public class BufferedStream {
    public static void main(String[] argc) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("scrap/output.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("scrap/output.txt"));

            //just like system.out but to file
            PrintStream printStream = new PrintStream("scrap/output.txt");
            printStream.println("Hello darkness");
            printStream.close();


            String line = null;
            line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();   //write new line on output
                bufferedWriter.flush();
                line = bufferedReader.readLine();
            }
            bufferedWriter.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
