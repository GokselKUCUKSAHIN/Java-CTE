public class Main
{

    static int standart_Mult = 0;
    static int fast_Mult = 0;

    public static void main(String[] args)
    {
        System.out.printf("s: %d; f:%d\n", multiply(4, 10), multiplyFast(4, 10));
        stamp();
        System.out.printf("s: %d; f:%d\n", multiply(13, 76), multiplyFast(13, 76));
        stamp();
        System.out.printf("s: %d; f:%d\n", multiply(-5, 50), multiplyFast(-5, 50));
        stamp();
        System.out.printf("s: %d; f:%d\n", multiply(75, 50), multiplyFast(75, 50));
        stamp();
        System.out.printf("s: %d; f:%d\n", multiply(1000, 100), multiplyFast(1000, 100));
        stamp();
        System.out.printf("s: %d; f:%d\n", multiply(100, 10000), multiplyFast(100, 10000));
        stamp();
        System.out.printf("s: %d; f:%d\n", multiply(10000, 100), multiplyFast(100000, 100));
        stamp();
    }

    static void stamp()
    {
        System.out.printf("standart :\t%3d cycle\nfast :\t%3d cycle\n", standart_Mult, fast_Mult);
        standart_Mult = 0;
        fast_Mult = 0;
    }

    static int multiplyFast(int x, int y)
    {
        fast_Mult++;
        /* 0 multiplied with anything gives 0 */
        if (y == 0 || x == 0)
            return 0;
        // for made some time
        int tx = Math.max(x, y);
        int ty = Math.min(x, y);

        /* Add x one by one */
        if (ty > 0)
            return (tx + multiplyFast(tx, ty - 1));

        /* the case where y is negative */
        if (ty < 0)
            return -multiplyFast(tx, -ty);

        return -1;
    }

    static int multiply(int x, int y)
    {
        standart_Mult++;
        /* 0 multiplied with anything gives 0 */
        if (y == 0)
            return 0;

        /* Add x one by one */
        if (y > 0)
            return (x + multiply(x, y - 1));

        /* the case where y is negative */
        if (y < 0)
            return -multiply(x, -y);

        return -1;
    }

}
