
/**
 * A class that controls all the items, obstacles, etc in the sixth scene
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Gameboard6{
    //attributes
    private Obstacle[] obstacle;
    private Item[] items;
    private Scrolls scroll;
    private Image background;
    //constructor
    public Gameboard6() { 

        obstacle = new Obstacle[7];
        obstacle[0] = new Obstacle(0, 0, 150, 120, Color.WHITE);
        obstacle[1] = new Obstacle(170, 0, 270, 260, Color.WHITE);
        obstacle[2] = new Obstacle(400, 0, 560, 140, Color.WHITE);
        obstacle[3] = new Obstacle(540, 200, 160, 160, Color.WHITE);
        obstacle[4] = new Obstacle(820, 240, 160, 160, Color.WHITE);
        obstacle[5] = new Obstacle(170, 340, 280, 180, Color.WHITE);
        obstacle[6] = new Obstacle(0, 500, 960, 150, Color.WHITE);

        //all obtainable items in Scene 6
        items = new Item[8];
        items[0] = new Item(120, 400, "Scroll", 22, "images/Scroll.png",32, 32, "This is a secret scroll");
        items[1] = new Item(230, 200, "Clock", 32, "images/Clock.png",32, 32, "a clock that points towards certain things");
        items[2] = new Item(100, 150, "Horn", 40, "images/Horn.png",32, 32, "a clock that points towards certain things");
        items[3] = new Item(680, 180, "Flowers", 41, "images/BasketOfFlowers.png",32, 32, "a clock that points towards certain things");
        items[4] = new Item(450, 450, "Robot", 42, "images/RobotHead.png",32, 32, "a clock that points towards certain things");
        items[5] = new Item(790, 370, "top", 47, "images/top.png",32, 32, "a clock that points towards certain things");
        items[6] = new Item(450, 130, "tail", 48, "images/Tail.png",32, 32, "a clock that points towards certain things");
        items[7] = new Item(740, 120, "pendant", 49, "images/BluePendant.png",32, 32, "a clock that points towards certain things");
        
        //readable scroll
        scroll = new Scrolls("images/ClockHint.png", 200, 240, items[0]);
        //background
        background = new Image("images/Scene6.png");

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
