package AStarAlgorithm;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;


public class Window extends Application
{

    Timeline loop;
    private static int scrW = 800;
    private static int scrH = 800;
    //
    public static int cols = 40;
    public static int rows = 40;

    public static int w = scrW / cols;
    public static int h = scrH / rows;


    Spot grid[][] = new Spot[cols][rows];

    ArrayList<Spot> openSet = new ArrayList<>();
    ArrayList<Spot> closeSet = new ArrayList<>();
    Spot start;
    Spot end;
    Spot current;

    ArrayList<Spot> path = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception
    {
        Pane root = new Pane();
        //backGround
        //Rectangle back = new Rectangle(0, 0, scrW, scrH);
        //back.setFill(Color.rgb(51, 51, 51));

        //create spot objects
        for (int i = 0; i < cols; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                grid[i][j] = new Spot(i, j);
            }
        }

        //check neighbors
        for (int i = 0; i < cols; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                grid[i][j].addNeighbors(grid);
            }
        }

        start = grid[0][0];//set start
        end = grid[cols - 1][rows - 1];//set end

        //start and end cant be walls
        start.setWall(false);
        end.setWall(false);


        openSet.add(start);
        //
        loop = new Timeline(new KeyFrame(Duration.millis(16), e -> {
            if (openSet.size() > 0)
            {
                int lowestIndex = 0;
                for (int i = 0; i < openSet.size(); i++)
                {
                    if (openSet.get(i).getF() < openSet.get(lowestIndex).getF())
                    {
                        lowestIndex = i;
                    }
                }
                current = openSet.get(lowestIndex);
                if (current == end)
                {
                    /*
                    //Find the Path
                    path = new ArrayList<>();
                    Spot temp = current;
                    path.add(temp);
                    while (temp.getPrevious() != null)
                    {
                        path.add(temp.getPrevious());
                        temp = temp.getPrevious();
                    }*/
                    loop.stop();
                    System.out.println("DONE!");
                }

                openSet.remove(current);
                closeSet.add(current);

                ArrayList<Spot> neighbors = current.getNeighbors();
                for (int i = 0; i < neighbors.size(); i++)
                {
                    Spot neighbor = neighbors.get(i);
                    if (!closeSet.contains(neighbor) && !neighbor.isWall())
                    {
                        double tempG = current.getG() + 1;
                        if (openSet.contains(neighbor))
                        {
                            if (tempG < neighbor.getG())
                            {
                                neighbor.setG(tempG);
                            }
                        } else
                        {
                            neighbor.setG(tempG);
                            openSet.add(neighbor);
                        }

                        neighbor.setH(heuristic(neighbor, end));
                        neighbor.setF(neighbor.getG() + neighbor.getH());
                        neighbor.setPrevious(current);
                    }
                }

                //we can keep going
            } else
            {
                //no solution
                System.out.println("No Solution!");
                loop.stop();
            }
            //debug
            for (int i = 0; i < cols; i++)
            {
                for (int j = 0; j < rows; j++)
                {
                    grid[i][j].show(Color.WHITE);
                }
            }
            for (int i = 0; i < closeSet.size(); i++)
            {
                closeSet.get(i).show(Color.rgb(255, 0, 0));
            }
            for (int i = 0; i < openSet.size(); i++)
            {
                openSet.get(i).show(Color.rgb(0, 255, 0));
            }
            //Find the Path
            path = new ArrayList<>();
            Spot temp = current;
            path.add(temp);
            while (temp.getPrevious() != null)
            {
                path.add(temp.getPrevious());
                temp = temp.getPrevious();
            }
            for (int i = 0; i < path.size(); i++)
            {
                path.get(i).show(Color.rgb(0, 0, 255));
            }

        }));
        //
        loop.setRate(1);
        loop.setAutoReverse(false);
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        //
        /*
        for (int i = 0; i < cols; i++)
        {
            System.out.println(Arrays.toString(grid[i]));
        }
        */
        //
        //root.getChildren().add(back);
        //
        for (int i = 0; i < cols; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                root.getChildren().add(grid[i][j].getSqr());
            }
        }
        stage.setTitle("A* PathFind");
        stage.setScene(new Scene(root, scrW - 10, scrH - 10));
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.show();
    }

    private static double heuristic(Spot a, Spot b)
    {
        //return dist(a.getX(), a.getY(), b.getX(), b.getY());
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    private static double dist(int ax, int ay, int bx, int by)
    {
        return Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
