
/**
 * A class that controls all the items, obstacles, etc in the seventh scene
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Gameboard7{
    //attributes
    private Obstacle[] obstacle;
    private Item[] items;
    private Scrolls scroll;
    private Image background;
    //constructor
    public Gameboard7() { 

        obstacle = new Obstacle[10];
        obstacle[0] = new Obstacle(0, 0, 100, 150, Color.WHITE);
        obstacle[1] = new Obstacle(0, 180, 200, 250, Color.WHITE);
        obstacle[2] = new Obstacle(170, 270, 200, 230, Color.WHITE);
        obstacle[3] = new Obstacle(500, 270, 220, 230, Color.WHITE);
        obstacle[4] = new Obstacle(650, 170, 230, 230, Color.WHITE);
        obstacle[5] = new Obstacle(780, 0, 250, 250, Color.WHITE);
        obstacle[6] = new Obstacle(330, 0, 20, 170, Color.WHITE);
        obstacle[7] = new Obstacle(530, 0, 20, 170, Color.WHITE);
        obstacle[8] = new Obstacle(0, 0, 5, 640, Color.WHITE);
        obstacle[9] = new Obstacle(955, 0, 5, 640, Color.WHITE);
        
        //all obtainable items in Scene 7
        items = new Item[2];
        items[0] = new Item(420, 30, "Scroll", 23, "images/Scroll.png",32, 32, "This is a secret scroll");
        items[1] = new Item(600, 30, "Drape", 50, "images/Drape.png",32, 32, "");
        
        //readable scroll
        scroll = new Scrolls("images/MapSnow.png", 240, 150, items[0]);
        
        background = new Image("images/Scene7.png");

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
}
