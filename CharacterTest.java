
/**
 * Write a description of class DiceDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

 import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class CharacterTest extends ProcessingFX {    
    public static void main(String[] args) {
        launch(args);
    }

    Sprite idleMC;
    Sprite testObj;
    int rockObtain;
    Sprite bG;
    Background firstScene;
    public void setup(GraphicsContext pen) {

        idleMC = new Sprite("images/Owlet_Monster.png", 32, 32);
        PVector pos = new PVector(0, 0);
        idleMC.setPosition(pos);
        idleMC.draw(pen);
        
        
        testObj = new Sprite("Images/Rock2.png", 32, 32);
        PVector obj = new PVector(100, 200);
        testObj.setPosition(obj);
        testObj.draw(pen);
        
        rockObtain = 0;
        
        
        bG = new Sprite("images/grass1.png", 32, 32);
        PVector posBG = new PVector(-32, -32);
        firstScene = new Background(bG, posBG, 960, 640);
        
        
    }

    public void draw(GraphicsContext pen) {
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
        firstScene.draw(pen);
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
                    System.out.println("picked up");
                    rockObtain += 1;
            }
        }
        idleMC.draw(pen);
        
     
        if (rockObtain == 0) {   
            testObj.draw(pen);
        }
      
    }
}


