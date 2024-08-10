
/**
 * The chest is the thing that takes in objects and checks them to see if the objects given 
 * is equal to the password. If it is, then the player wins the game
 *
 * @author Jenny
 * @version May 19 2023
 */                                                    
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class Chest{
    //attributes 
    private Item[] password;                //an array of items needed to win the game
    private Item stored;                    //no longer needed: an item stored in the chest to give to the player
    public static final Image chest = new Image("images/Chest.png");
    private int xPos;                       //x and y position of the chest
    private int yPos;
    private int size;

    //constructor
    public Chest(Item[] pass, Item stored, int x, int y, int size) {
        password = pass;
        this.stored = stored;
        xPos = x;
        yPos = y;
        this.size = size;

    }

    public void draw(GraphicsContext pen) {
        pen.drawImage(chest, xPos, yPos, size, size);
    }

    /**
     * Compares the given items by the player
     * with the array of items in the password
     */
    public boolean checkPassword(ArrayList<Item> given) {   
        int counter = 0;                                        
        if (given.size() == password.length) {                          //check if lengths are the same
            for (int i = 0; i < given.size(); i++) {
                for (int j = 0; j < password.length; j++) {
                    if(given.get(i).getID() == password[j].getID()) {   //compares the integer assigned ID of the items
                        counter++;                                      //increments if an item is correct
                    }
                }
            }            
        }
        if (counter == password.length) {
            return true;
        }
        return false;
    }

    /**
     * returns an item to the player if it is correct
     * no longer used/needed in the code
     */
    public Item giveItem() {   
        return stored;
    }

    //getters and setters
    public int getXPos() { 
        return xPos; 
    } 
    
    public int getYPos() { 
        return yPos; 
    }
    
    public int getSize() { 
        return size; 
    }
    
    public void setXPos(int x) {
        xPos = x;
    }
    
    public void setYPos(int y) {
        yPos = y;
    }
    
    public Item[] getPassword() {
        return password;
    }
}
