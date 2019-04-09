import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        ArrayList<String> words = new ArrayList<String>()
        {
            {
                add("Visual");
                add("JellyBeanci");
                add("Programming");
                add("madaMadaMADAMADA");
                add("java");
                add("bytecode");
                add("Türkçe");
                add("Binary");
                add("HelloWorld");
                add("1234567890");
                add("letter");
                add("word");
                add("foobar");
                add("test123");
                add("C0mput3r");
                add("Computer");
                add("Science");
            }
        };
        System.out.println(longestIsogram(words));
    }

    private static String longestIsogram(ArrayList<String> list)
    {
        String sMax = "";
        int max = -1;
        for (String word : list)
        {
            try
            {
                if (isIsogram(word))
                {
                    if (word.length() > max)
                    {
                        sMax = word;
                        max = word.length();
                    }
                }
            }
            catch (IllegalArgumentException ex)
            {
                System.out.println(word + " IllegalArgumentException!");
            }
            catch (Exception ex)
            {
                //Something Else
                System.out.println("Unexpected Error: " + ex.fillInStackTrace());
            }
        }
        return sMax;
    }

    private static boolean isIsogram(String word) throws IllegalArgumentException
    {
        ArrayList<Character> letters = new ArrayList<Character>();
        String regex = "[a-z A-Z]+"; //include white space only 26 English letters(upper & lowercase) (26 + 26 + 1)
        boolean flag = true;
        String lowerWord = word;
        lowerWord.toLowerCase();
        if (!word.matches(regex))
        {
            throw new IllegalArgumentException();
        } else
        {
            for (int i = 0; i < word.length(); i++)
            {
                if (letters.contains(lowerWord.charAt(i)))
                {
                    flag = false;
                } else
                {
                    letters.add(lowerWord.charAt(i));
                }
            }
        }
        return flag;
    }
}