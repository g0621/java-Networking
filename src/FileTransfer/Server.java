package FileTransfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private BufferedOutputStream out;
    private BufferedInputStream fileReader;

    ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void closeConnection() {
        try {
            if (out != null) {
                out.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            if (out != null) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedOutputStream(socket.getOutputStream());
            String filename = reader.readLine();
            System.out.println("File :" + filename + " requested by " + socket.getInetAddress().getHostAddress());
            File file = new File(filename);
            //String rootDirectory = "D:\\rootDirectory";
            //File file = new File(rootDirectory + "" +file);
            //verify that the file exists
            if (file.exists()) {
                out.write((byte) 1);
                fileReader = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[1024];
                int bytesRead = fileReader.read(buffer);
                while (bytesRead != -1) {
                    out.write(buffer, 0, bytesRead);
                    out.flush();
                    bytesRead = fileReader.read(buffer);
                }
                closeConnection();
            } else {
                out.write((byte) 0);
                closeConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Server {
    public static void main(String argc[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
