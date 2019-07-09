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
    private Rectangle body;
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
        body = new Rectangle(this.x * Window.w, this.y * Window.h, Window.w, Window.h);
        body.setFill(Color.WHITE);
        body.setStroke(Color.DARKGRAY);
        body.setStrokeWidth(2);
        if (Math.random() < 0.5)
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
            this.body.setFill(Color.BLACK);
        } else
        {
            this.body.setFill(clr);
        }
    }

    public Rectangle getBody()
    {
        return this.body;
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
        if (x > 0 && y > 0)
        {
            this.neighbors.add(grid[x - 1][y - 1]);
        }
        if (x < Window.cols - 1 && y > 0)
        {
            this.neighbors.add(grid[x + 1][y - 1]);
        }
        if (x > 0 && y < Window.rows - 1)
        {
            this.neighbors.add(grid[x - 1][y + 1]);
        }
        if (x < Window.cols - 1 && y < Window.rows - 1)
        {
            this.neighbors.add(grid[x + 1][y + 1]);
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