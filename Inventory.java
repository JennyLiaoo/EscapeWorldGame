
/**
 * Tracks the inventory of items of the player and the chest.
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Inventory{
    //attributes 
    private ArrayList<Item> item;           //items held within the player inventory
    public static final Image inventory = new Image("images/Inventory.png");
    private int originalPlace;              //the location of the first item in the inventory
    public static final int x = 77;         //shifting over to the next item in the inventory
    private ArrayList<Item> given;          //array of items given to the chest
    //constructor
    public Inventory(Gameboard gameboard) {
        item = new ArrayList<Item>();
        originalPlace = 155;                //used to draw the placement of items in the inventory
        given = new ArrayList<Item>();

    }

    public void draw(GraphicsContext pen) {     //fix placement of obj
        pen.drawImage(inventory, 150, 550, 700, 80); 
        for(int i = 0; i < item.size(); i++) {
            //draws the items within the inventory as long as it does not exceed the inventory spots
            item.get(i).setXPos(originalPlace + i*x );      //increments its x position
            item.get(i).setYPos(560);
            item.get(i).setWidth(70);
            item.get(i).setHeight(70);
            if (i > 8) {
                item.get(i).setXPos(originalPlace + i*x + 200);  //not seen to the player
            }
            else {
                item.get(i).setXPos(originalPlace + i*x );
            }
            item.get(i).draw(pen);

        }

    }

    /**
     * Adds items to the player inventory
     */
    public void addItem(Item obtained) {      
        item.add(obtained);
    }

    /**
     * Move item from inventory into the chest inventory
     */
    public void giveItem(Item gave) {          
        given.add(gave);
    }

    /**
     * returns the chest inventory
     */
    public ArrayList<Item> getChestInventory() {
        return given;
    }

    /**
     * Get an item from the player inventory
     */
    public Item getItem(int number){      
        Item get = item.get(number);
        return get;
    }

    /**
     * removes an item from the player's inventory
     */
    public void removeItem(Item removed) { 
        int deleteIndex = -1;
        for(int i = 0; i < item.size(); i++) {
            if(item.get(i).getID() == removed.getID()) {        //finds where the item is located in the inventory
                deleteIndex = i;
                break;
            }
        }
        if(deleteIndex >= 0) { 
            item.remove(deleteIndex);                           //removes the item
        }
    }
}
