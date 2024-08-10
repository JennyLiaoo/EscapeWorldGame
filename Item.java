
/**
 * All the items that are obtainable by the player
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
public class Item{
    //attributes 
    private int xPos;
    private int yPos;
    private String itemName;
    private int ID;             //used to compare items
    private Image item;
    private int width;
    private int height;
    private String message;

    //constructor
    public Item(int x,int y, String name, int ID, String image, int w, int h, String message) {
        xPos = x;
        yPos = y;
        itemName = name;
        this.ID = ID;
        item = new Image(image);
        height = h;
        width = w;
        this.message = message;

    }

    public void draw(GraphicsContext pen) {
        pen.drawImage(item, xPos, yPos, width, height); 

    }

    //getters and setters
    public String getMessage() {
        return message;
    }

    public int getID() {
        return ID;
    }

    public int getXPos() { 
        return xPos; 
    }

    public void setXPos(int x) { 
        xPos = x; 
    }

    public int getYPos() { 
        return yPos; 
    }

    public void setYPos(int y) { 
        yPos = y; 
    }

    public int getWidth() { 
        return width; 
    }

    public int getHeight() { 
        return height; 
    }

    public void setWidth(int w) { 
        width = w; 
    }

    public void setHeight(int h) { 
        height = h; 
    }
}
