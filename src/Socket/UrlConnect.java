package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlConnect {
    public static void main(String[] argc){
        try {
            URL url = new URL("https://finance.yahoo.com/quote/ORCL?ltr=1");
            URLConnection myConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
            String line = reader.readLine();
            String pattern = "<span id=\"yfs_l84_orcl\">(.+?)</span>";
            Pattern r = Pattern.compile(pattern);
            while (line != null){
                System.out.println(line);
                if(line.contains("yfs_l84_orcl"))
                {
                    Matcher m = r.matcher(line);
                    if (m.find( )) {
                        System.out.println(m.group(1));
                    }
                }
                line = reader.readLine();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
