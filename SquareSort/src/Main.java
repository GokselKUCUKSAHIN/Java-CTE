import sun.nio.cs.ext.MacArabic;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        int[] arr = new int[]{-10, -8, -6, -4, -2, -1, 0, 2, 3, 5, 10, 23};
        System.out.println(Arrays.toString(arr));
        int[] sqrArr = sortedSquaredArray(arr);
        System.out.println(Arrays.toString(sqrArr));
    }

    public static int[] sortedSquaredArray(int[] array)
    {
        int[] newarr = new int[array.length];
        int lastIndex = newarr.length - 1;
        int firstIndex = 0;
        int current = 0;
        //
        for (int i = array.length - 1; i >= 0; i--)
        {
            if (Math.abs(array[firstIndex]) >= Math.abs(array[lastIndex]))
            {
                current = array[firstIndex];
                firstIndex++;
            } else
            {
                current = array[lastIndex];
                lastIndex--;
            }
            newarr[i] = (int) Math.pow(current, 2);
        }
        return newarr;
    }
}
