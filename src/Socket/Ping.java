package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ping {
    public static void main(String argc[]){
        try{
            //Executes command in temninal on behalf of program
            Process p = Runtime.getRuntime().exec("ping 192.168.0.13");
//        Process p = Runtime.getRuntime().exec("netstat -a");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String cmd = reader.readLine();
            while (cmd != null){
                System.out.println(cmd);
                cmd = reader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
