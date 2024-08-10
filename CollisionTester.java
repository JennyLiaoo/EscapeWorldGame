
/**
 * Write a description of class DiceDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

 import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class CollisionTester extends ProcessingFX {    
    public static void main(String[] args) {
        launch(args);
    }


    PVector pos;
    
    Sprite idleMC;
    Sprite testObj;
    int rockObtain;
    int trackScene;
    
    boolean collide;
    public void setup(GraphicsContext pen) {

        idleMC = new Sprite("images/Owlet_Monster.png", 32, 32);
        idleMC.draw(pen);
        
        
        testObj = new Sprite("Images/Rock2.png", 32, 32);
        PVector obj = new PVector(100, 200);
        testObj.setPosition(obj);
        testObj.draw(pen);
        
        rockObtain = 0;
        
        collide = false;
        
    }

    public void draw(GraphicsContext pen) {
        
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
        
        pos = idleMC.getPosition();
        double characterX = pos.getXComp();
        double characterY = pos.getYComp();
        
         if (rockObtain == 0) {   
            testObj.draw(pen);
        }
        
        //Collide not working, always true: to be fixed
        if (key.pressed) {
                System.out.println("Key has been pressed");
                if(key.key == 'w' || key.key == 'W') {
                    System.out.println("UP");
                    idleMC.up();
                }
                else if(key.key == 'a' || key.key == 'A') {
                    idleMC.left();
                }
                else if(key.key == 's' || key.key == 'S') {
                    idleMC.down();
                }
                else if(key.key == 'd' || key.key == 'D') {
                    idleMC.right();
                }
                else if (key.key == 'p' || key.key == 'P')  {
                    collide = idleMC.checkCollision(testObj);
                    if (collide = true) {
                        System.out.println("picked up");
                        rockObtain += 1;
                    }
                    else if (collide = false) {
                        System.out.println("Nothing to pick up");
                    }
                    
            }
        }
        idleMC.draw(pen);
        
     
       
      
      
    }
}


