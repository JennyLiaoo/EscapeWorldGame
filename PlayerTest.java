
/**
 * Write a description of class DiceDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

 import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class PlayerTest extends ProcessingFX {    
    public static void main(String[] args) {
        launch(args);
    }

    public void setup(GraphicsContext pen) {

       
        
    }

    public void draw(GraphicsContext pen) {
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
        
    }
}


