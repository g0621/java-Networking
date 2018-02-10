package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] argc){
        try {
            //default port is 80
            //telnet localhost 9090 in cmd
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("Listening for client...");
            boolean stop = false;
            while (!stop){
            Socket socket = serverSocket.accept();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);

            //write to the client
            printWriter.println("Hello client");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //reads from the client
            String clientInp = reader.readLine();
            System.out.println(clientInp);
            printWriter.close();
            reader.close();
            socket.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
