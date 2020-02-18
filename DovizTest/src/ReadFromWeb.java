import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFromWeb
{
    public static void main(String[] args) throws IOException
    {
        String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
        //
        ArrayList<String> stream = readFromWeb(url);
        //
        ArrayList<Currency> currencies = getCurrencies(stream);
        //
        for (Currency c : currencies)
        {
            System.out.println(c);
        }
    }

    static private ArrayList<Currency> getCurrencies(ArrayList<String> dataRows)
    {
        ArrayList<Currency> currencies = new ArrayList<>();
        //
        Matcher matcher;
        //
        String ncRegex = "<Currency CrossOrder=\"(\\d*)\" Kod=\"([A-Z]{3})\" CurrencyCode=\"([A-Z]{3})\">"; //tested
        Pattern newlinePattern = Pattern.compile(ncRegex);
        //
        String uRegex = "<Unit>(\\d*)</Unit>"; //tested
        Pattern unitPattern = Pattern.compile(uRegex);
        //
        String nameRegex = "<Isim>([A-Z ĞÜŞİÖÇ]*)</Isim>"; //tested
        Pattern namePattern = Pattern.compile(nameRegex);
        //
        String cNameRegex = "<CurrencyName>([A-Z ]*)</CurrencyName>"; //tested
        Pattern cNamePattern = Pattern.compile(cNameRegex);
        //
        String forBuyRegex = "<ForexBuying>(\\d.\\d{3,5})</ForexBuying>"; //tested
        Pattern forBuyPattern = Pattern.compile(forBuyRegex);
        //
        String forSellRegex = "<ForexSelling>(\\d.\\d{3,5})</ForexSelling>"; //tested
        Pattern forSellPattern = Pattern.compile(forSellRegex);
        //
        String bankBuyRegex = "<BanknoteBuying>(\\d.\\d{3,5})</BanknoteBuying>"; //tested
        Pattern bankBuyPattern = Pattern.compile(bankBuyRegex);
        //
        String bankSellRegex = "<BanknoteSelling>(\\d.\\d{3,5})</BanknoteSelling>"; //tested
        Pattern bankSellPattern = Pattern.compile(bankSellRegex);
        //
        for (int i = 0; i < dataRows.size(); i++)
        {
            String current = dataRows.get(i);
            matcher = newlinePattern.matcher(current);
            if (matcher.find())
            {
                //it's new currency
                String code = matcher.group(2);
                //
                int unit = 0;
                matcher = unitPattern.matcher(dataRows.get(i + 1));
                if (matcher.find())
                {
                    unit = Integer.parseInt(matcher.group(1));
                }
                //
                String name = "";
                matcher = namePattern.matcher(dataRows.get(i + 2));
                if (matcher.find())
                {
                    name = matcher.group(1);
                }
                //
                String currName = "";
                matcher = cNamePattern.matcher(dataRows.get(i + 3));
                if (matcher.find())
                {
                    currName = matcher.group(1);
                }
                //
                double forbuy = 0;
                matcher = forBuyPattern.matcher(dataRows.get(i + 4));
                if (matcher.find())
                {
                    forbuy = Double.parseDouble(matcher.group(1));
                }
                //
                double forsell = 0;
                matcher = forSellPattern.matcher(dataRows.get(i + 5));
                if (matcher.find())
                {
                    forsell = Double.parseDouble(matcher.group(1));
                }
                //
                double bankbuy = 0;
                matcher = bankBuyPattern.matcher(dataRows.get(i + 6));
                if (matcher.find())
                {
                    bankbuy = Double.parseDouble(matcher.group(1));
                }
                //
                double banksell = 0;
                matcher = bankSellPattern.matcher(dataRows.get(i + 7));
                if (matcher.find())
                {
                    banksell = Double.parseDouble(matcher.group(1));
                }
                //
                currencies.add(new Currency(code, unit, name, currName, forbuy, forsell, bankbuy, banksell));
                //
                i += 8;
            }
        }
        return currencies;
    }

    private static ArrayList<String> readFromWeb(String webURL) throws IOException
    {
        ArrayList<String> data = new ArrayList<>();
        URL url = new URL(webURL);
        InputStream is = url.openStream();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                data.add(line);
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
            throw new MalformedURLException("URL is malformed!!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new IOException();
        }
        return data;
    }
}