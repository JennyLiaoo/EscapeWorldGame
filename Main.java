
/**
 * The main class of the game
 *
 * @author Jenny
 * @version May 19 2023
 */
//import libraries
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;

public class Main extends ProcessingFX {    
    public static void main(String[] args) {
        launch(args);
    }

    private Player player;
    private SceneHandler scene;
    private int sceneNum;
    private boolean released;

    public void setup(GraphicsContext pen) {
        player = new Player(540, 70, "images/Owlet_Monster.png", 40);
        player.draw(pen);
        scene = new SceneHandler(player);
        sceneNum = 0;           //scene tracker
        released = false;       //when key released
    }

    public void draw(GraphicsContext pen) {
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
        scene.draw(pen);        //draws the background

        //this may look like a lot, but it is because I have many, many gameboards
        if (key.pressed) {      //all events when keys are pressed

            //player movements
            if(key.key == 'w' || key.key == 'W') {
                player.up();
            }
            else if(key.key == 'a' || key.key == 'A') {
                player.left();
            }
            else if(key.key == 's' || key.key == 'S') {
                player.down();
            }
            else if(key.key == 'd' || key.key == 'D') {
                player.right();
            }
            else if(key.key == 'p' || key.key == 'P') {     //checks for items and adds them into the inventory, like picking up an object
                int sceneNum = scene.getSceneNumber();      //obtain the current scene number (tracks which gameboard)
                if (sceneNum == 0) {
                    for(int i = 0; i < scene.getScene1().getItems().length; i++){
                        boolean pickUp = player.checkCollision(scene.getScene1().getItems()[i]);        //check collision with item
                        if (pickUp) {   
                            scene.getInventory().addItem(scene.getScene1().getItems()[i]);              //add to inventory
                        }
                    }
                }
                else if (sceneNum == 1) {
                    for(int i = 0; i < scene.getScene2().getItems().length; i++){
                        boolean pickUp = player.checkCollision(scene.getScene2().getItems()[i]);
                        if (pickUp) {
                            scene.getInventory().addItem(scene.getScene2().getItems()[i]);
                        }
                    }
                }
                else if(sceneNum == 2) {
                    for(int i = 0; i < scene.getScene3().getItems().length; i++){
                        boolean pickUp = player.checkCollision(scene.getScene3().getItems()[i]);
                        if (pickUp) {
                            scene.getInventory().addItem(scene.getScene3().getItems()[i]);
                        }
                    }
                }
                else if(sceneNum == 3) {
                    for(int i = 0; i < scene.getScene4().getItems().length; i++){
                        boolean pickUp = player.checkCollision(scene.getScene4().getItems()[i]);
                        if (pickUp) {
                            scene.getInventory().addItem(scene.getScene4().getItems()[i]);
                        }
                    }
                }
                else if(sceneNum == 4) {
                    for(int i = 0; i < scene.getScene5().getItems().length; i++){
                        boolean pickUp = player.checkCollision(scene.getScene5().getItems()[i]);
                        if (pickUp) {
                            scene.getInventory().addItem(scene.getScene5().getItems()[i]);
                        }
                    }
                }
                else if(sceneNum == 5) {
                    for(int i = 0; i < scene.getScene6().getItems().length; i++){
                        boolean pickUp = player.checkCollision(scene.getScene6().getItems()[i]);
                        if (pickUp) {
                            scene.getInventory().addItem(scene.getScene6().getItems()[i]);
                        }
                    }
                }
                else if(sceneNum == 6) {
                    for(int i = 0; i < scene.getScene7().getItems().length; i++){
                        boolean pickUp = player.checkCollision(scene.getScene7().getItems()[i]);
                        if (pickUp) {
                            scene.getInventory().addItem(scene.getScene7().getItems()[i]);
                        }
                    }
                }
                else if(sceneNum == 7) {
                    for(int i = 0; i < scene.getScene8().getItems().length; i++){
                        boolean pickUp = player.checkCollision(scene.getScene8().getItems()[i]);
                        if (pickUp) {
                            scene.getInventory().addItem(scene.getScene8().getItems()[i]);
                        }
                    }
                }
                else if(sceneNum == 8) {
                    for(int i = 0; i < scene.getScene9().getItems().length; i++){
                        boolean pickUp = player.checkCollision(scene.getScene9().getItems()[i]);
                        if (pickUp) {
                            scene.getInventory().addItem(scene.getScene9().getItems()[i]);
                        }
                    }
                }

            }
            else if(key.key == 'r' || key.key == 'R') {     //if r is clicked, player can read scrolls
                int sceneNum = scene.getSceneNumber();
                if(sceneNum == 0) {
                    boolean scrollTouch = player.checkCollision(scene.getScene1().getItems()[0]);       //checks which scroll (readable item) is being touched
                    boolean scrollTouch2 = player.checkCollision(scene.getScene1().getItems()[6]);
                    boolean scrollTouch3 = player.checkCollision(scene.getScene1().getItems()[7]);
                    if (scrollTouch) {
                        scene.getScene1().getHint().draw(pen);                                          //draws the hint, or the readable content
                    }
                    else if (scrollTouch2) {
                        scene.getScene1().getHint2().draw(pen);
                    }
                    else if (scrollTouch3) {
                        scene.getScene1().getHint3().draw(pen);
                    }
                }
                else if(sceneNum == 1) {
                    boolean scrollTouch = player.checkCollision(scene.getScene2().getItems()[0]);
                    boolean scrollTouch2 = player.checkCollision(scene.getScene2().getItems()[2]);
                    if (scrollTouch) {
                        scene.getScene2().getHint().draw(pen);     
                    }
                    else if (scrollTouch2) {
                        scene.getScene2().getHint2().draw(pen);
                    }
                }
                else if(sceneNum == 3) {
                    boolean scrollTouch = player.checkCollision(scene.getScene4().getItems()[6]);
                    if (scrollTouch) {
                        scene.getScene4().getHint().draw(pen);     
                    }
                }
                else if(sceneNum == 4) {
                    boolean scrollTouch = player.checkCollision(scene.getScene5().getItems()[0]);
                    if (scrollTouch) {
                        scene.getScene5().getHint().draw(pen);     
                    }
                }
                else if(sceneNum == 5) {
                    boolean scrollTouch = player.checkCollision(scene.getScene6().getItems()[0]);
                    if (scrollTouch) {
                        scene.getScene6().getHint().draw(pen);     
                    }
                }
                else if(sceneNum == 6) {
                    boolean scrollTouch = player.checkCollision(scene.getScene7().getItems()[0]);
                    if (scrollTouch) {
                        scene.getScene7().getHint().draw(pen);     
                    }
                }
                else if(sceneNum == 7) {
                    boolean scrollTouch = player.checkCollision(scene.getScene8().getItems()[0]);
                    boolean scrollTouch2 = player.checkCollision(scene.getScene8().getItems()[3]);
                    if (scrollTouch) {
                        scene.getScene8().getHint().draw(pen);     
                    }
                    else if (scrollTouch2) {
                        scene.getScene8().getHint2().draw(pen);
                    }
                }
            }

            boolean chest = player.checkCollision(scene.getScene1().getChest());        //checks collision with the chest
            if (chest) { 
                int num = (int)key.key - 48;                                            //using ASCII to find out which key is pressed
                if (num >= 1 && num <= 9 && released == true) {                         
                    released = false;
                    scene.getInventory().giveItem(scene.getInventory().getItem(num-1)); //gives the chest the item based on the number clicked
                    scene.getInventory().removeItem(scene.getInventory().getItem(num-1)); //removes the given item from the inventory
                }
                if(key.key == 'g') {                                                    //checks the password
                    boolean checkPass = scene.getScene1().getChest().checkPassword(scene.getInventory().getChestInventory());        
                    scene.setWon(checkPass);                                            //changes scene depending on win or lose                                   
                }
            } 
        }
        player.draw(pen);
    }

    /**
     * Tracks if a key has been released
     * If released, the variable will be true
     */
    public void keyReleased() {   
        released = true;
    }
}

