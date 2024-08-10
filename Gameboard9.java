
/**
 * A class that controls all the items, obstacles, etc in the ninth scene
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Gameboard9{
    //attributes
    private Obstacle[] obstacle;
    private Item[] items;
    private Image background;
    //constructor
    public Gameboard9() { 

        obstacle = new Obstacle[8];

        obstacle[0] = new Obstacle(0, 0, 200, 250, Color.WHITE);
        obstacle[1] = new Obstacle(200, 0, 350, 75, Color.WHITE);
        obstacle[2] = new Obstacle(550, 0, 400, 160, Color.WHITE);
        obstacle[3] = new Obstacle(900, 0, 5, 640, Color.WHITE);
        obstacle[4] = new Obstacle(0, 450, 120, 150, Color.WHITE);
        obstacle[5] = new Obstacle(100, 470, 600, 200, Color.WHITE);
        obstacle[6] = new Obstacle(250, 320, 100, 320, Color.WHITE);
        obstacle[7] = new Obstacle(600, 500, 300, 50, Color.WHITE);

        //all obtainable items in Scene 9
        items = new Item[5];

        items[0] = new Item(160, 430, "Snowy Ruin 1", 27, "images/Snow_ruins1.png",128, 128, "This is a secret scroll");
        items[1] = new Item(500, 100, "Ripped map", 28, "images/RippedMap.png",32, 32, "a shiny pearl");
        items[2] = new Item(450, 430, "Pirate Flag", 29, "images/PirateFlag.png",32, 32, "a potion");
        items[3] = new Item(870, 450, "Crown", 30, "images/Crown.png",32, 32, "a potion");
        items[4] = new Item(250, 130, "Snowy Ruins 2", 31, "images/Snow_ruins4.png",32, 32, "ruins");

        background = new Image("images/Scene9.png");

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
