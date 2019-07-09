package AStarAlgorithm;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
    private Circle body;
    private double r = Window.w * 0.30;
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
        body = new Circle(Window.w * x + r, Window.h * y + r, r);
        body.setFill(Color.WHITE);
        //body.setStroke(Color.DARKGRAY);
        //body.setStroke(Color.rgb(51, 51, 51));
        //body.setStrokeWidth(2);
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

    public Circle getBody()
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

    public double getCenterX()
    {
        return this.body.getCenterX();
    }

    public double getCenterY()
    {
        return this.body.getCenterY();
    }

    @Override
    public String toString()
    {
        return String.format("(%2.2f.%2.2f.%2.2f)", f, g, h);
    }
}