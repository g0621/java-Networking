package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] argc){
        try {
            InetAddress address = InetAddress.getByName("localhost");
            System.out.println("Server Adress "+ address.getAddress().toString());
            Socket socket = new Socket(address,9090);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());
            printWriter.println("Hello Server");
            printWriter.close();
            bufferedReader.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
