
/**
 * The player that is controlled. It moves and checks for collisions with other objects.
 * 
 * @author Jenny
 * @version Jan 27 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
public class Player{
    //attributes 
    private int xPos;       //position of the character
    private int yPos;
    private String imageName;
    private int size;
    private Image player;
    
    private int obsX;       //position of things that the player can collide with and their size
    private int obsY;
    private int obsW;
    private int obsH;
    
    private boolean released;
    //default constructor
    public Player(int x, int y, String name, int size) {
        xPos = x;
        yPos = y;
        imageName = name;
        player = new Image(imageName);
        this.size = size;
        released = false;
    }

    public void draw(GraphicsContext pen) {
        pen.drawImage(player, xPos, yPos, size, size); 
    }

    /**
     * Move the player
     */
    public void up() { 
        yPos -= 5;
    }

    public void down() { 
        yPos += 5;
    }

    public void left() { 
        xPos -= 5;
    }

    public void right() { 
        xPos += 5;
    }

    /**
     * Checks collision with obstacles
     * The obstacles do not let the player pass by setting the player back
     */
    public void checkCollision(Obstacle obstacle) { 
        obsX = obstacle.getXPos();
        obsY = obstacle.getYPos();
        obsW = obstacle.getWidth();
        obsH = obstacle.getHeight();   
        if (xPos + size >= obsX && xPos <= obsX + obsW && yPos == obsY + obsH) {        //check bottom of the obstacle
            yPos += 5;
        } 
        else if (yPos + size >= obsY && yPos <= obsY + obsH && xPos + size == obsX) {   // check the left side of the obstacle
            xPos -= 5; 
        }
        else if (xPos + size >= obsX && xPos <= obsX + obsW && yPos + size == obsY) {   //check top of the obstacle
            yPos -= 5;
        }
        else if (yPos + size >= obsY && yPos <= obsY + obsH && xPos == obsX + obsW) {   //checks the right side of the obstacle
            xPos += 5; 
        }
    }

    /**
     * Checks collision with items
     */
    public boolean checkCollision(Item item) {
        obsX = item.getXPos();
        obsY = item.getYPos();
        obsW = item.getWidth();
        obsH = item.getHeight();
        if (xPos + size >= obsX && xPos <= obsX && yPos >= obsY && yPos + size <= obsY + obsH) {                //if player covers entire item
            return true;
        } 
        else if (xPos >= obsX && xPos <= obsX + obsW && yPos + size >= obsY && yPos + size <= obsY + obsH) {    //check player's bottom left corner
            return true;
        }
        else if (xPos >= obsX && xPos <= obsX + obsW && yPos >= obsY && yPos <= obsY + obsH) {                  //check top left corner
            return true;
        }
        else if (xPos + size >= obsX && xPos + size <= obsX + obsW && yPos >= obsY && yPos <= obsY + obsH) {    //check top right corner
            return true;
        }
        else if (xPos + size >= obsX && xPos + size <= obsX + obsW && yPos + size >= obsY && yPos + size <= obsY + obsH) { // bottom right corner
            return true;
        }
        return false;
    }

    /**
     * Checks collision with a chest
    */
    public boolean checkCollision(Chest chest) {
        obsX = chest.getXPos();
        obsY = chest.getYPos();
        obsW = chest.getSize();
        obsH = chest.getSize();
        if (xPos + size >= obsX && xPos <= obsX && yPos >= obsY && yPos + size <= obsY + obsH) {                //if player covers entire thing
            return true;
        } 
        else if (xPos >= obsX && xPos <= obsX + obsW && yPos + size >= obsY && yPos + size <= obsY + obsH) {    //check player's bottom left corner
            return true;
        }
        else if (xPos >= obsX && xPos <= obsX + obsW && yPos >= obsY && yPos <= obsY + obsH) {                  //check top left corner
            return true;
        }
        else if (xPos + size >= obsX && xPos + size <= obsX + obsW && yPos >= obsY && yPos <= obsY + obsH) {    //check top right corner
            return true;
        }
        else if (xPos + size >= obsX && xPos + size <= obsX + obsW && yPos + size >= obsY && yPos + size <= obsY + obsH) { // botton right corner
            return true;
        }
        return false;
    }

    //getters and setters
    public int getXPos() { 
        return xPos;
    }

    public int getYPos() { 
        return yPos;
    }

    public void setXPos(int x) { 
        xPos = x;
    }

    public void setYPos(int y) { 
        yPos = y;
    }

    public void keyReleased() {   
        released = true;
    }
}
