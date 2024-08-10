
/**
 * The main class of the game
 *
 * @author Jenny
 * @version (a version number or a date)
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
public class GameBoard2Tester extends ProcessingFX {    
    public static void main(String[] args) {
        launch(args);
    }
    Gameboard2 scene;
    //Image S1BG;
    //Obstacle[] obstacle;
    //Item[] items;
    public void setup(GraphicsContext pen) {
        
        scene = new Gameboard2();

    }

    public void draw(GraphicsContext pen) {
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
       
        scene.draw(pen);
        }   
    }



