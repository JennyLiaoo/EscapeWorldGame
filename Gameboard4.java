
/**
 * A class that controls all the items, obstacles, etc in the fourth scene
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Gameboard4{
    //attributes
    private Obstacle[] obstacle;
    private Item[] items;
    private Scrolls scroll;
    private Image background;
    //default constructor
    public Gameboard4() { 

        obstacle = new Obstacle[8];
        obstacle[0] = new Obstacle(100, 0, 40, 130, Color.WHITE);
        obstacle[1] = new Obstacle(130, 0, 870, 140, Color.WHITE);
        obstacle[2] = new Obstacle(870, 160, 100, 160, Color.WHITE);
        obstacle[3] = new Obstacle(0, 350, 150, 300, Color.WHITE);
        obstacle[4] = new Obstacle(140, 520, 200, 240, Color.WHITE);
        obstacle[5] = new Obstacle(380, 340, 150, 350, Color.WHITE);
        obstacle[6] = new Obstacle(530, 500, 450, 100, Color.WHITE);
        obstacle[7] = new Obstacle(0, 0, 5, 320, Color.WHITE);

        //all obtainable items in Scene 4
        items = new Item[10];
        items[0] = new Item(170, 440, "RedPotion", 14, "images/RedPotion.png",32, 32, "This is a secret scroll");
        items[1] = new Item(450, 140, "RedPotion", 15, "images/RedPotion.png",32, 32, "a shiny pearl");
        items[2] = new Item(620, 470, "OrangePotion", 16, "images/OrangePotion.png",32, 32, "a potion");
        items[3] = new Item(800, 180, "YellowPotion", 17, "images/YellowPotion.png",32, 32, "This is a secret scroll");
        items[4] = new Item(670, 450, "OrangePotion", 18, "images/OrangePotion.png",32, 32, "a shiny pearl");
        items[5] = new Item(220, 500, "BluePotion", 19, "images/BluePotion.png",32, 32, "a potion");
        items[6] = new Item(570, 140, "Scroll", 20, "images/Scroll.png",32, 32, "This is a secret scroll");
        items[7] = new Item(600, 180, "BluePotion", 35, "images/BluePotion.png",32, 32, "This is a secret scroll");
        items[8] = new Item(850, 200, "GreenPotion", 36, "images/GreenPotion.png",32, 32, "a shiny pearl");
        items[9] = new Item(850, 250, "BluePotion", 37, "images/BluePotion.png",32, 32, "a potion");

        //readable scroll
        scroll = new Scrolls("images/GummyHint.png", 90, 120, items[6]);
        
        background = new Image("images/Scene4.png");

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
