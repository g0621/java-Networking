package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] argc) {
        try {
            DatagramSocket socket = new DatagramSocket(9090);
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            while (true){
                DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
                socket.receive(receivePacket);
                String received = new String(receivePacket.getData());
                System.out.println("DataReceived : "+received);

                InetAddress clientAdress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String data = "Hello Client";
                sendData = data.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,clientAdress,clientPort);
                socket.send(sendPacket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
