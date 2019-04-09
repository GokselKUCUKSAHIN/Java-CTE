package edu.erciyes.graphics;

public class Circle extends GraphicObject implements IResizable
{

    private double radius;

    public Circle()
    {

    }

    public Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getArea()
    {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }

    @Override
    public void resize(int size)
    {
        this.radius *= size;
    }
}
