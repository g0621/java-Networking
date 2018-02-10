package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null;

    ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Hello client");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientInp = reader.readLine();
            System.out.println(clientInp);
            printWriter.close();
            reader.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class MultiThreadedServer {
    public static void main(String[] argc) {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            while (true) {
                System.out.println("Waiting for client...");
                Socket socket = serverSocket.accept();
                System.out.println("Connected");
                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
