package Socket;

import java.io.IOException;
import java.net.ServerSocket;

public class LocalPortScanner {
    public static void main(String[] argc){
        int port = 1;
        //scan for all open ports ports which are listning already.
        while (port <= 65535){
            try {
                //netstat -a in cmd to list all open ports
                ServerSocket socket = new ServerSocket(port);
            } catch (IOException e) {
                System.out.println("port open " + port);
            }
            port++;
        }
    }
}
