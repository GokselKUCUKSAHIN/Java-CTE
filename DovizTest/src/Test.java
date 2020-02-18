
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Test
{

    public static void main(String[] args) throws IOException
    {
        URL url = new URL("https://www.tcmb.gov.tr/kurlar/today.xml");
        InputStream in = url.openStream();
        Scanner scan = new Scanner(in);
        while(scan.hasNext())
        {
            System.out.println(scan.nextLine());
        }
    }
}
