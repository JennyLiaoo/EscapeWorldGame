
/**
 * A class that controls all the items, obstacles, etc in the third scene
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Gameboard3{
    //attributes
    private Obstacle[] obstacle;
    private Item[] items;
    private Image background;
    //constructor
    public Gameboard3() { 
        obstacle = new Obstacle[4];
        obstacle[0] = new Obstacle(0, 0, 120, 640, Color.WHITE);
        obstacle[1] = new Obstacle(0, 0, 300, 270, Color.WHITE);
        obstacle[2] = new Obstacle(650, 0, 200, 270, Color.WHITE);
        obstacle[3] = new Obstacle(860, 0, 100, 640, Color.WHITE);

        //all obtainable items in Scene 3
        items = new Item[3];
        items[0] = new Item(800, 320, "Candle", 13, "images/Candles.png",32, 32, "obtainable candles");
        items[1] = new Item(250, 300, "Skull", 44, "images/Skull.png",32, 32, "obtainable candles");
        items[2] = new Item(300, 360, "RedPearl", 45, "images/RedPearl.png",32, 32, "obtainable candles");

        background = new Image("images/Scene3.png");
    }

    public void draw(GraphicsContext pen) {

        for (int numObs = 0; numObs < obstacle.length; numObs++){
            Obstacle obs = obstacle[numObs];
            obs.draw(pen);
        } 

        pen.drawImage(background, 0, 0, 960, 640);

        for (int numItem = 0; numItem < items.length; numItem++){
            Item item = items[numItem];
            item.draw(pen);
        }

    }

    //getters and setters
    public Obstacle[] getObstacles() { 
        return obstacle;
    }

    public Item[] getItems() { 
        return items;
    }

}
