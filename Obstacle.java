/**
 * These are obstacles that the players can collide with but cannot pass. They act as the boundary.
 *
 * @author Jenny 
 * @version May 19 2023
 */
//import libraries
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Obstacle
{
    //attributes for the rectangle
    private Color colorFill;
    private int xPos;           //position and size of the rectangles
    private int yPos;
    private int width;
    private int height;

    public Obstacle(int x, int y, int w, int h, Color f){
        xPos = x;
        yPos = y;
        width = w; 
        height = h;    
        colorFill = f;

    }

    public void draw(GraphicsContext pen) {
        pen.setFill(colorFill);

        //drawing and filling the rectangle
        pen.beginPath();
        pen.lineTo(xPos, yPos);
        pen.lineTo(xPos + width, yPos);
        pen.lineTo(xPos + width, yPos + height);
        pen.lineTo(xPos, yPos + height);
        pen.fill();
        pen.closePath();
        pen.stroke();
    }
    
    //getters and setters
    public int getXPos() { 
        return xPos; 
    }

    public int getYPos() { 
        return yPos; 
    }

    public int getWidth() { 
        return width; 
    }

    public int getHeight() { 
        return height; 
    }
}

