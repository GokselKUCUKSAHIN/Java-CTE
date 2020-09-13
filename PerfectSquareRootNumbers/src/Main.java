public class Main
{
    public static void main(String[] args)
    {
        for (int i = 1; i < 1000000000; i++)
        {
            isPerfectSquare(i);
        }
    }
    private static void isPerfectSquare(int number)
    {
        // Square result must be whole number (integer)
        double sqrt = Math.sqrt(number);
        if (sqrt == Math.round(sqrt))
        {
            String result = numberCheck(number + "", (int) sqrt);
            if (!result.equals("-1"))
            {
                System.out.printf("%d bir S sayısıdır √%d = %d =  %s\n", number, number, (int) sqrt, result.replace("+"," + "));
            }
        }
    }
    private static String numberCheck(String numStr, int sum)
    {
        int len = numStr.length() - 1; // total shift count.
        int count = (int) Math.pow(2, len);
        for (int i = 0; i < count; i++)
        {
            int binary = i;
            StringBuilder sb = new StringBuilder();
            sb.append(numStr.charAt(0));
            for (short j = 0; j < len; j++)
            {
                if ((binary & 0b0000_0001) == 1) // Check only LSB bit.
                {
                    sb.append("+");
                }
                sb.append(numStr.charAt(j + 1)); // 1 digit offset.
                binary >>= 1; // bitwise right-shift.
            }
            if(sumString(sb.toString()) == sum)
            {
                return sb.toString();
            }
        }
        return  "-1";
    }
    private static int sumString(String expression)
    {
        final String[] split = expression.split("\\+");
        int sum = 0;
        for(String str : split) { sum += Integer.parseInt(str); }
        return sum;
    }
}