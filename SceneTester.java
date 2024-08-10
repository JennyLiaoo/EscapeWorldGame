
/**
 * Write a description of class DiceDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

 import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class SceneTester extends ProcessingFX {    
    public static void main(String[] args) {
        launch(args);
    }

    Sprite bG;
    Sprite bG2;
    Background firstScene;
    Background secondScene;
    PVector pos;
    
    Sprite idleMC;
    Sprite testObj;
    int rockObtain;
    int trackScene;
    public void setup(GraphicsContext pen) {

        idleMC = new Sprite("images/Owlet_Monster.png", 32, 32);
        idleMC.draw(pen);
        
        
        testObj = new Sprite("Images/Rock2.png", 32, 32);
        PVector obj = new PVector(100, 200);
        testObj.setPosition(obj);
        testObj.draw(pen);
        
        rockObtain = 0;
        
        bG = new Sprite("images/grass1.png", 32, 32);
        bG2 = new Sprite("images/Brick.png", 32, 32);
        
        
        PVector posBG = new PVector(-32, -32);
        
        firstScene = new Background(bG, posBG, 960, 640);
        secondScene = new Background(bG2, posBG, 960, 640);
        
        trackScene = 0;
        
        
    }

    public void draw(GraphicsContext pen) {
        
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
        
        pos = idleMC.getPosition();
        double characterX = pos.getXComp();
        double characterY = pos.getYComp();
        
        PVector neutralLeft = new PVector(0, characterY);
        PVector neutralRight = new PVector(960, characterY);
        
        if(trackScene == 0 && characterX < 960) { //character is in first scene and not past the right
            firstScene.draw(pen);
        }
        else if (trackScene == 0 && characterX >= 960) { //character is in the first scen but has passed the right boundary so switch scenes
            trackScene = 1;
            secondScene.draw(pen);
            idleMC.setPosition(neutralLeft);
        }
        else if (trackScene == 1 && characterX >= 0 && characterX <= 960) { // character is in the second scene
            secondScene.draw(pen);
        }
        else if(trackScene == 1 && characterX < 0) { // character is in the second scene but has passed the left boundary, so switch to first scene
            trackScene = 0;
            firstScene.draw(pen);
            idleMC.setPosition(neutralRight);
        }
    
       
        
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


