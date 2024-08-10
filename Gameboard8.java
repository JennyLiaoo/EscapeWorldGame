
/**
 * A class that controls all the items, obstacles, etc in the eigth scene
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Gameboard8{
    //attributes
    private Obstacle[] obstacle;
    private Item[] items;
    private Scrolls scroll;
    private Scrolls scroll2;
    private Image background;
    //constructor
    public Gameboard8() { 

        obstacle = new Obstacle[6];
        obstacle[0] = new Obstacle(0, 0, 300, 200, Color.WHITE);
        obstacle[1] = new Obstacle(0, 0, 180, 640, Color.WHITE);
        obstacle[2] = new Obstacle(180, 320, 270, 350, Color.WHITE);
        obstacle[3] = new Obstacle(450, 0, 500, 160, Color.WHITE);
        obstacle[4] = new Obstacle(0, 550, 960, 5, Color.WHITE);
        obstacle[5] = new Obstacle(600, 340, 350, 320, Color.WHITE);

        //all obtainable items in Scene 8
        items = new Item[4];
        items[0] = new Item(750, 140, "Scroll", 24, "images/Scroll.png",32, 32, "This is a secret scroll");
        items[1] = new Item(230, 290, "compass", 25, "images/Compass.png",32, 32, "a shiny pearl");
        items[2] = new Item(750, 330, "card", 26, "images/Card.png",32, 32, "a potion");
        items[3] = new Item(550, 420, "Scroll", 33, "images/Scroll.png",32, 32, "This is a secret scroll");

        //scrolls
        scroll = new Scrolls("images/ShortStory1.png", 200, 240, items[0]);
        scroll2 = new Scrolls("images/ShortStory2.png", 200, 240, items[3]);
       
        background = new Image("images/Scene8.png");

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

    public Scrolls getHint() {
        return scroll;
    }

    public Scrolls getHint2() {
        return scroll2;
    }
}
