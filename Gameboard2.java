
/**
 * A class that controls all the items, obstacles, etc in the second scene
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Gameboard2{
    //attributes
    private Obstacle[] obstacle;
    private Item[] items;
    private Image background;
    private Scrolls scroll;
    private Scrolls scroll2;
    //constructor
    public Gameboard2() { 
        obstacle = new Obstacle[11];
        obstacle[0] = new Obstacle(0, 0, 400, 100, Color.WHITE);
        obstacle[1] = new Obstacle(400, 0, 560, 5, Color.WHITE);
        obstacle[2] = new Obstacle(0, 600, 60, 40, Color.WHITE);
        obstacle[3] = new Obstacle(70, 390, 250, 300, Color.WHITE);
        obstacle[4] = new Obstacle(60, 550, 900, 80, Color.WHITE);
        obstacle[5] = new Obstacle(320, 250, 200, 130, Color.WHITE);
        obstacle[6] = new Obstacle(630, 250, 180, 130, Color.WHITE);
        obstacle[7] = new Obstacle(810, 90, 40, 130, Color.WHITE);
        obstacle[8] = new Obstacle(920, 90, 40, 130, Color.WHITE);
        obstacle[9] = new Obstacle(810, 90, 150, 40, Color.BLACK);
        obstacle[10] = new Obstacle(955, 0, 5, 640, Color.BLACK);

        //all obtainable items in Scene 2
        items = new Item[6];

        items[0] = new Item(340, 390, "Scroll", 7, "images/Scroll.png",32, 32, "Contains an acrostic poem");
        items[1] = new Item(200, 100, "Necklace", 8, "images/Necklace.png",32, 32, "a necklace");
        items[2] = new Item(680, 200, "Scroll", 9, "images/Scroll.png",32, 32, "a hint for the next scene: candle");
        items[3] = new Item(610, 380, "key", 10, "images/key.png",32, 32, "a key");
        items[4] = new Item(870, 250, "jewel", 11, "images/RedJewel.png",32, 32, "a potion");
        items[5] = new Item(890, 20, "drink", 43, "images/Drink.png",32, 32, "a potion");
        
        //readable scrolls
        scroll = new Scrolls("images/AcosticPoem.png", 180, 160, items[0]);
        scroll2 = new Scrolls("images/CandleHint.png", 260, 20, items[2]);
        
        background = new Image("images/Scene2.png");
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
