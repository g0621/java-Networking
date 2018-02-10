package FileTransfer;

import org.apache.commons.validator.routines.InetAddressValidator;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String argc[]) {
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(in);

            String ip = "";
            String filename = "";

            while (true) {
                System.out.println("Please enter a valid ip : ");
                ip = reader.readLine();
                InetAddressValidator validator = new InetAddressValidator();
                if (validator.isValid(ip)) break;
            }

            System.out.println("Enter filename :");
            filename = reader.readLine();

            Socket socket = new Socket(ip, 9090);
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream input = new BufferedInputStream(inputStream);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(filename);

            int code = input.read();
            if (code == 1) {
                BufferedOutputStream outputStream = new BufferedOutputStream(new
                        FileOutputStream("D:\\" + filename));
                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);
                while (bytesRead != -1) {
                    //System.out.print(".");
                    outputStream.write(buffer, 0, bytesRead);
                    outputStream.flush();
                    bytesRead = input.read(buffer);
                }
                System.out.println("File " + filename + " was Successfully downloaded");
            } else {
                System.out.println("File mot present");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
