import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        // 1. ADIM
        Point x0 = new Point(1, 0);
        double alpha = 0.25; //0.25 //0.5 //0.01
        double epsilon = 0.01; //0.01 //0.5
        Point enDikInis = enDikInisAlg(x0, alpha, epsilon);
        Point esneklikGradient = eslenikGradAlg(x0, alpha, epsilon);
        System.out.println("En Dik İniş Algoritması : " + enDikInis);
        System.out.println("Esneklik Gradient Algoritması : " + esneklikGradient);
        System.out.println("En Dik İniş Alg Cevap : " + f(enDikInis));
        System.out.println("Esneklik Gradient Alg Cevap : " + f(esneklikGradient));
    }

    public static Point eslenikGradAlg(Point init, double alpha, double E)
    {
        ArrayList<Point> solutions = new ArrayList<>();
        int t = 0;
        solutions.add(init);

        Point prevDirection = new Point(0, 0);
        Point diretction = gradient(init).getReverse();
        Point prevGradient = new Point(0, 0);
        Point gradient = gradient(solutions.get(t));
        gradient = gradient(solutions.get(t));
        double gMag = gradient.getMag();
        if (gMag < E)
        {
            return solutions.get(t);
        } else
        {
            while (true)
            {
                // 5. ADIM
                solutions.add(solutions.get(t).add(diretction.multiply(alpha)));
                t++;
                //2. ADIM
                prevGradient = gradient;
                gradient = gradient(solutions.get(t));
                gMag = gradient.getMag();
                if (gMag < E)
                {
                    return solutions.get(t);
                } else
                {
                    //3. ADIM
                    double beta = beta(gradient, prevGradient);
                    prevDirection = diretction;
                    diretction = gradient.getReverse().add(diretction.multiply(beta));
                }
            }
        }
    }

    public static Point enDikInisAlg(Point init, double alpha, double E)
    {
        ArrayList<Point> solutions = new ArrayList<>();
        int t = 0;
        solutions.add(init);
        double gMag = 0;
        do
        {
            // 2. ADIM
            Point g = gradient(solutions.get(t));
            gMag = g.getMag();
            if (gMag < E)
            {
                return solutions.get(t);
            } else
            {
                // 3. ADIM
                Point d = solutions.get(t).getReverse();
                // 4. ADIM
                // Alfa sabit
                solutions.add(solutions.get(t).add(d.multiply(alpha)));
                // 5. ADIM
                t++;
            }
        }
        while (gMag >= E);
        return solutions.get(t);
    }

    private static double beta(Point g1, Point g2)
    {
        return Math.pow((g1.getMag() / g2.getMag()), 2);
    }

    private static Point gradient(double x1, double x2)
    {
        return new Point(2 * x1 - 2 * x2, 2 * x2 - 2 * x1);
    }

    private static Point gradient(Point p1)
    {
        return gradient(p1.x1, p1.x2);
    }

    private static double f(double x1, double x2)
    {
        // x1^2 + x2^2 - 2(x1 * x2)
        return (Math.pow(x1, 2) + Math.pow(x2, 2) - 2 * (x1 * x2));
    }

    private static double f(Point p1)
    {
        return f(p1.x1, p1.x2);
    }
}