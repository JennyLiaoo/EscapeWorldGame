
/**
 * A class that controls all the items, obstacles, scrolls, and chest in the first scene
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Gameboard{
    //attributes 
    private Image background;
    private Obstacle[] obstacle;
    private Item[] items;
    private Chest chest;
    private Item[] password; 
    private Scrolls scroll;
    private Scrolls scroll2;
    private Scrolls scroll3;
    //constructor
    public Gameboard() { 
        obstacle = new Obstacle[11];
        obstacle[0] = new Obstacle(0, 0, 370, 200, Color.WHITE);
        obstacle[1] = new Obstacle(370, 0, 60, 70, Color.WHITE);
        obstacle[2] = new Obstacle(450, 0, 210, 10, Color.WHITE);
        obstacle[3] = new Obstacle(680, 0, 300, 70, Color.WHITE);
        obstacle[4] = new Obstacle(750, 90, 320, 120, Color.WHITE);
        obstacle[5] = new Obstacle(0, 210, 50, 260, Color.WHITE);
        obstacle[6] = new Obstacle(380, 210, 110, 110, Color.WHITE);
        obstacle[7] = new Obstacle(630, 210, 400, 110, Color.WHITE);
        obstacle[8] = new Obstacle(840, 320, 120, 80, Color.WHITE);
        obstacle[9] = new Obstacle(0, 460, 220, 220, Color.WHITE);
        obstacle[10] = new Obstacle(240, 540, 760, 60, Color.BLACK);

        //all obtainable items in Scene 1
        items = new Item[8];
        items[0] = new Item(500, 80, "Scroll", 1, "images/Scroll.png",32, 32, "MorseCode");
        items[1] = new Item(250, 230, "Mushroom", 2, "images/mushroom.png",32, 32, "an odd mushroom");
        items[2] = new Item(70, 420, "Feather", 3, "images/feather.png", 32, 32, "a light feather");
        items[3] = new Item(800, 380, "Sack", 4, "images/Sack.png", 32, 32, "a sack of potatoes");
        items[4] = new Item(690, 300, "Cheese", 5, "images/Cheese.png", 32, 32, "cheese!");
        items[5] = new Item(800, 500, "Paper", 6, "images/Paper.png", 32,32, "paper... or a diary??");
        items[6] = new Item(360, 290, "Scroll", 34, "images/Scroll.png",32, 32, "Cheese Hint");
        items[7] = new Item(550, 80, "Enveloppe", 50, "images/Enveloppe.png",32, 32, "Cheese Hint");

        background = new Image("images/Scene1.png");

        //readable scrolls
        scroll = new Scrolls("images/MorseCode.png", 180, 240, items[0]);
        scroll2 = new Scrolls("images/CheeseHint.png", 300, 30, items[6]);
        scroll3 = new Scrolls("images/Storyline.png", 380, 75, items[7]);

        //password of the chest, needs these items to be unlocked
        password = new Item[17];
        password[0] = new Item(690, 300, "Cheese", 5, "images/Cheese.png", 32, 32, "cheese!");
        password[1] = new Item(200, 100, "Necklace", 8, "images/Necklace.png",32, 32, "a necklace");
        password[2] = new Item(610, 380, "key", 10, "images/key.png",32, 32, "a key");
        password[3] = new Item(800, 320, "Candle", 13, "images/Candles.png",32, 32, "obtainable candles");
        password[4] = new Item(170, 440, "RedPotion", 14, "images/RedPotion.png",32, 32, "This is a secret scroll");
        password[5] = new Item(450, 140, "RedPotion", 15, "images/RedPotion.png",32, 32, "a shiny pearl");
        password[6] = new Item(620, 470, "OrangePotion", 16, "images/OrangePotion.png",32, 32, "a potion");
        password[7] = new Item(670, 450, "OrangePotion", 18, "images/OrangePotion.png",32, 32, "a shiny pearl");
        password[8] = new Item(800, 180, "YellowPotion", 17, "images/YellowPotion.png",32, 32, "This is a secret scroll");
        password[9] = new Item(850, 200, "GreenPotion", 36, "images/GreenPotion.png",32, 32, "a shiny pearl");
        password[10] = new Item(510, 490, "gold", 38, "images/BagOfGold.png",32, 32, "gold");
        password[11] = new Item(100, 150, "Horn", 40, "images/Horn.png",32, 32, "a clock that points towards certain things");
        password[12] = new Item(680, 180, "Flowers", 41, "images/BasketOfFlowers.png",32, 32, "a clock that points towards certain things");
        password[13] = new Item(450, 450, "Robot", 42, "images/RobotHead.png",32, 32, "a clock that points towards certain things");
        password[14] = new Item(750, 330, "card", 26, "images/Card.png",32, 32, "a potion");
        password[15] = new Item(250, 130, "Snowy Ruins 2", 31, "images/Snow_ruins4.png",32, 32, "ruins");
        password[16] = new Item(870, 450, "Crown", 30, "images/Crown.png",32, 32, "a potion");

        //not used anymore: originally would give back an item when correct
        Item stored = new Item(250, 400, "Card", 10, "images/Card.png",32, 32, "a 5 card");
        chest = new Chest(password, stored, 700, 80, 32);
    }

    public void draw(GraphicsContext pen) {
        for (int numObs = 0; numObs < obstacle.length; numObs++){
            Obstacle obs = obstacle[numObs];
            obs.draw(pen);
        }   
        pen.drawImage(background, 0, 0, 960, 640); 

        chest.draw(pen);
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

    public Chest getChest() {
        return chest;
    }

    public Item[] getPassword() {
        return password;
    }

    public Scrolls getHint() {
        return scroll;
    }

    public Scrolls getHint2() {
        return scroll2;
    }

    public Scrolls getHint3() {
        return scroll3;
    }
}
