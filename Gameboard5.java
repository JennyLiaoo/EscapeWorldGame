
/**
 * A class that controls all the items, obstacles, etc in the fifth scene
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Gameboard5{
    //attributes

    private Obstacle[] obstacle;
    private Item[] items;
    private Scrolls scroll;
    private Image background;
    //constructor
    public Gameboard5() { 

        obstacle = new Obstacle[18];
        obstacle[0] = new Obstacle(0, 0, 960, 240, Color.WHITE);
        obstacle[1] = new Obstacle(0, 550, 960, 80, Color.WHITE);
        obstacle[2] = new Obstacle(200, 240, 5, 150, Color.WHITE);
        obstacle[3] = new Obstacle(200, 390, 100, 5, Color.WHITE);
        obstacle[4] = new Obstacle(300, 340, 5, 50, Color.WHITE);
        obstacle[5] = new Obstacle(200, 480, 5, 70, Color.WHITE);
        obstacle[6] = new Obstacle(300, 480, 5, 70, Color.WHITE);
        obstacle[7] = new Obstacle(300, 480, 100, 5, Color.WHITE);
        obstacle[8] = new Obstacle(400, 340, 5, 140, Color.WHITE);
        obstacle[9] = new Obstacle(500, 480, 70, 5, Color.WHITE);
        obstacle[10] = new Obstacle(570, 480, 5, 70, Color.WHITE);
        obstacle[11] = new Obstacle(670, 300, 5, 180, Color.WHITE);
        obstacle[12] = new Obstacle(600, 410, 70, 5, Color.WHITE);
        obstacle[13] = new Obstacle(600, 360, 5, 50, Color.WHITE);
        obstacle[14] = new Obstacle(600, 300, 70, 5, Color.WHITE);
        obstacle[15] = new Obstacle(670, 400, 100, 5, Color.WHITE);
        obstacle[16] = new Obstacle(770, 240, 5, 150, Color.WHITE);
        obstacle[17] = new Obstacle(770, 480, 5, 80, Color.WHITE);

        
        //all obtainable items in Scene 5
        items = new Item[4];
        items[0] = new Item(100, 400, "Scroll", 21, "images/Scroll.png",32, 32, "This is a secret scroll");
        items[1] = new Item(510, 490, "gold", 38, "images/BagOfGold.png",32, 32, "gold");
        items[2] = new Item(680, 310, "gold", 39, "images/Gold.png",32, 32, "gold");
        items[3] = new Item(350, 350, "axe", 46, "images/Ax.png",32, 32, "gold");
        
        //readable scroll
        scroll = new Scrolls("images/Maze.png", 150, 80, items[0]);

        background = new Image("images/Scene5.png");

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
