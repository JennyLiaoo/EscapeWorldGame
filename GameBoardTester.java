
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
public class GameBoardTester extends ProcessingFX {    
    public static void main(String[] args) {
        launch(args);
    }
    Gameboard scene;
    //Image S1BG;
    //Obstacle[] obstacle;
    //Item[] items;
    public void setup(GraphicsContext pen) {
        
        
        //All static obstacles in scene 1
        Obstacle[] obstacle = new Obstacle[11];

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
        obstacle[10] = new Obstacle(240, 590, 760, 60, Color.WHITE);
        
        //all obtainable items in Scene 1
        Item[] items = new Item[2];
        items[0] = new Item(300, 200, "Scroll", 1, "images/Scroll.png",32, 32, "This is a secret scroll");
        items[1] = new Item(250, 400, "Pearl", 2, "images/Pearl.png",32, 32, "a shiny pearl");
    
        
        Image S1BG = new Image("images/Scene1.png");
        scene = new Gameboard();

    }

    public void draw(GraphicsContext pen) {
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
       
        scene.draw(pen);
        }   
    }



