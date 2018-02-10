package Socket;

import org.apache.commons.validator.routines.InetAddressValidator;

public class IPvalidator {
    public static void main(String argc[]){
        InetAddressValidator validator = new InetAddressValidator();
        String ip = "192.168.0.13";
        boolean isValid = validator.isValid(ip) ;
        if (isValid){
            System.out.println("Address is valid");
        }else {
            System.out.println("Address is invalid");
        }
    }
    public boolean isValid(String ip){
        String[] str = ip.split("\\.");
        if (str.length != 4){
            return false;
        }
        for (String s:str){
            int num = Integer.parseInt(s);
            if (num>255 || num <0){
                return false;
            }
        }
        return true;
    }
}
