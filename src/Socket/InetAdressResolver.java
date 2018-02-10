package Socket;

import java.net.InetAddress;
import java.net.Socket;

public class InetAdressResolver {
    public static void main(String[] argc){
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
//            InetAddress address1 = InetAddress.getByName("192.168.0.13");
            InetAddress address1 = InetAddress.getByName("google.com");
            System.out.println(address1.getHostAddress());
            System.out.println(address1.getHostName());

            Socket socket = new Socket(address,9090);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
