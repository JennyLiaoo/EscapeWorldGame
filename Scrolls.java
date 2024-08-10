
/**
 * When player reads a scroll, an image pops up to display what is written on the scroll.
 * If it is collected in inventory, it can no longer be read
 *
 * @author Jenny
 * @version May 19 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
public class Scrolls{
    //attributes 
    private int xPos;
    private int yPos;
    private Image hint;
    private int height;
    private int width;
    private Item scroll;
    //constructor
    public Scrolls(String image, int w, int h, Item item) {
        scroll = item;
        xPos = item.getXPos() + 20;     //gets the position of the item/scroll image
        yPos = item.getYPos() - 20;
        hint = new Image(image);
        height = h;
        width = w;
    }

    public void draw(GraphicsContext pen) {
        xPos = scroll.getXPos() + 20;   //draws beside it
        yPos = scroll.getYPos() - 20;
        pen.drawImage(hint, xPos, yPos, width, height); 
    }
}
