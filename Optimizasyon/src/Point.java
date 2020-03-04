class Point
{

    public double x1;
    public double x2;

    public Point(double x1, double x2)
    {
        this.x1 = x1;
        this.x2 = x2;
    }

    public double[] getPoint()
    {
        return new double[]{this.x1, this.x2};
    }

    public void setPoint(double x1, double x2)
    {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Point getReverse()
    {
        return new Point(-this.x1, -this.x2);
    }

    public double getMag()
    {
        return Math.sqrt(Math.pow(this.x1, 2) + Math.pow(this.x2, 2));
    }

    public Point multiply(double multiplier)
    {
        return new Point(this.x1 * multiplier, this.x2 * multiplier);
    }

    public Point multiply(Point other)
    {
        return new Point(this.x1 * other.x1, this.x2 * other.x2);
    }

    public Point add(Point other)
    {
        return new Point(this.x1 + other.x1, this.x2 + other.x2);
    }

    @Override
    public String toString()
    {
        return String.format("[x1 = %3.7f, x2 = %3.7f]", this.x1, this.x2);
    }
}