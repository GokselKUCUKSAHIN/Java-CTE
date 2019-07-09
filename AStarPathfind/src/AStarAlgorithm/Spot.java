package AStarAlgorithm;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Spot
{

    private int x;
    private int y;
    //
    private double f = 0;
    private double g = 0;
    private double h = 0;
    //
    private Spot previous = null;
    //
    ArrayList<Spot> neighbors = new ArrayList<>();
    //
    private Rectangle sqr;
    private boolean wall = false;

    public boolean isWall()
    {
        return wall;
    }

    //
    public Spot(int x, int y)
    {
        this.x = x;
        this.y = y;
        //
        sqr = new Rectangle(this.x * Window.w, this.y * Window.h, Window.w, Window.h);
        sqr.setFill(Color.WHITE);
        sqr.setStroke(Color.DARKGRAY);
        sqr.setStrokeWidth(2);
        if (Math.random() < 0.3)
        {
            this.wall = true;
        }
    }

    public void setWall(boolean wall)
    {
        this.wall = wall;
    }

    public void show(Color clr)
    {
        if (wall)
        {
            this.sqr.setFill(Color.BLACK);
        } else
        {
            this.sqr.setFill(clr);
        }
    }

    public Rectangle getSqr()
    {
        return this.sqr;
    }

    public void addNeighbors(Spot grid[][])
    {
        if (x < Window.cols - 1)
        {
            this.neighbors.add(grid[x + 1][y]);
        }
        if (x > 0)
        {
            this.neighbors.add(grid[x - 1][y]);
        }
        if (y < Window.rows - 1)
        {
            this.neighbors.add(grid[x][y + 1]);
        }
        if (y > 0)
        {
            this.neighbors.add(grid[x][y - 1]);
        }
    }

    public ArrayList<Spot> getNeighbors()
    {
        return this.neighbors;
    }

    public double getF()
    {
        return f;
    }

    public void setF(double f)
    {
        this.f = f;
    }

    public double getG()
    {
        return g;
    }

    public void setG(double g)
    {
        this.g = g;
    }

    public double getH()
    {
        return h;
    }

    public void setH(double h)
    {
        this.h = h;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Spot getPrevious()
    {
        return previous;
    }

    public void setPrevious(Spot previous)
    {
        this.previous = previous;
    }

    @Override
    public String toString()
    {
        return String.format("(%2.2f.%2.2f.%2.2f)", f, g, h);
    }
}