package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] argc){
        try {
            //65508 max capacity
            DatagramSocket clientSocket = new DatagramSocket(0);
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            //Datagram paackets are only bytes array it cant be anything else
            //contains ip header(20 byte) and udp header(8 byte)

            InetAddress address = InetAddress.getByName("localhost");

            //Sets the timeout so that server response within time
            clientSocket.setSoTimeout(3000);

            String send = "Hello Server";
            sendData = send.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,address,9090);
            clientSocket.send(sendPacket);

            DatagramPacket receive = new DatagramPacket(receiveData,receiveData.length);
            clientSocket.receive(receive);
            receiveData = receive.getData();
            String dataReceived = new String(receiveData);
            System.out.println("From Server : " + dataReceived);
            clientSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
