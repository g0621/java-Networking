package Smtp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class EmailSocket {

    private static PrintWriter out;
    private static BufferedReader in;
    private static Socket emailSocket;

    public static void main(String[] argc) {
        try {
            emailSocket = new Socket("localhost",25);
            in = new BufferedReader(new InputStreamReader(emailSocket.getInputStream()));
            out = new PrintWriter(emailSocket.getOutputStream(),true);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (emailSocket != null && in != null && out != null){
            try {
                //Step 1: get greeting from server
                String response = in.readLine();
                while (response != null){
                    System.out.println("Server : " + response);
                    if (response.contains("220")) break;
                    response = in.readLine();
                }

                //step 2: respond with HELO to let know server
                out.println("HELO "+ InetAddress.getLocalHost().getHostAddress());
                System.out.println("HELO "+ InetAddress.getLocalHost().getHostAddress());
                response = in.readLine();
                while (response != null){
                    System.out.println("Server : " + response);
                    if (response.contains("250")) break;
                    response = in.readLine();
                }

                //Step 3: send the sender address
                out.println("MAIL From: gyansingh1997@gmail.com");
                response = in.readLine();
                //if email is not valid they can respond with other code
                while (response != null){
                    System.out.println("Server : " + response);
                    if (response.contains("250")) break;
                    response = in.readLine();
                }

                //Step 4: send the receiver address
                out.println("RCPT TO: gyansingh1997@gmail.com");
                response = in.readLine();
                while (response != null){
                    System.out.println("Server : " + response);
                    if (response.contains("250")) break;
                    response = in.readLine();
                }

                //Step 5: send the data command
                out.println("DATA");
                response = in.readLine();
                while (response != null){
                    System.out.println("Server : " + response);
                    if (response.contains("354")) break;
                    response = in.readLine();
                }

                //Step 6: Send email body
                //out.println("X-Mailer: Java");
                out.println("From: gyansingh1997@gmail.com.com");
                out.println("To: gyansingh1997@gmail.com");
                out.println("Subject: TEST EMAIL");
                out.println();
                out.println("Subject: TEST EMAIL"); // message body
                out.println("This is a test message"); // message body
                out.println("Thanks,"); // message body
                out.println("Java Network Programming course"); // message body
                out.println();
                out.println(".");
                //out.println();
                response = in.readLine();
                while (response != null){
                    System.out.println("Server : " + response);
                    if (response.contains("250")) break;
                    response = in.readLine();
                }

                //Step 7: Send the QUIT command
                out.println("QUIT");
                response = in.readLine();
                while (response != null){
                    System.out.println("Server : " + response);
                    if (response.contains("221")) break;
                    response = in.readLine();
                }

                System.out.println("Email send sucessfully");

                out.close();
                in.close();
                emailSocket.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
