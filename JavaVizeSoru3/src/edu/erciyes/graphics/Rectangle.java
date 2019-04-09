package edu.erciyes.graphics;

public class Rectangle extends GraphicObject
{

    private double width;
    private double length;

    public Rectangle()
    {
    }

    public Rectangle(double width, double length)
    {
        this.width = width;
        this.length = length;
    }

    @Override
    public boolean equals(Object obj)
    {
        return (this == obj);
    }

    @Override
    public double getArea()
    {
        return width * length;
    }

    @Override
    public double getPerimeter()
    {
        return 2 * (width + length);
    }
}
