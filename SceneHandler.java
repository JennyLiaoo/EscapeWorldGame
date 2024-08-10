/**
 * Tracks all the scenes and ensures that everything is drawn when it is supposed to be depending on the player's position
 * @author Jenny 
 * @version May 19 2023
 */
//import libraries
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
public class SceneHandler
{
    private int sceneNumber;        //tracks which scene the player is on
    private Player player;          //player attributes
    private int xPos;
    private int yPos;
    private Gameboard scene1;       //All gameboards
    private Gameboard2 scene2;
    private Gameboard3 scene3;
    private Gameboard4 scene4;
    private Gameboard5 scene5;
    private Gameboard6 scene6;
    private Gameboard7 scene7;
    private Gameboard8 scene8;
    private Gameboard9 scene9;
    private Inventory inventory;    
    
    private boolean win;            //end game attributes
    private boolean lose;
    private Image greenWin;
    private Image redLose;
    
    public SceneHandler(Player player){
        this.player = player;
        sceneNumber = 0;            //current scene is zero
        xPos = player.getXPos();
        yPos = player.getYPos();
        scene1 = new Gameboard();
        scene2 = new Gameboard2();
        scene3 = new Gameboard3();
        scene4 = new Gameboard4();
        scene5 = new Gameboard5();
        scene6 = new Gameboard6();
        scene7 = new Gameboard7();
        scene8 = new Gameboard8();
        scene9 = new Gameboard9();
        inventory = new Inventory(scene1);
        win = false;
        lose = false;
        greenWin = new Image("images/WinScreen.png");
        redLose = new Image("images/LoseScreen.jpg");
    }

    public void draw(GraphicsContext pen) {
        //obtain player position
        xPos = player.getXPos();
        yPos = player.getYPos();
        
        //checks the players position. Depending on where the player is and what is the current scene, different scenes will be drawn
        
        if(win == true) {                                   //if win
            pen.drawImage(greenWin, 0, 0, 960, 640); 
        }
        else if (lose == true){                             //if lose
            pen.drawImage(redLose, 0, 0, 960, 640); 
        }
        else if(sceneNumber == 0 && xPos <= 960) {
            sceneNumber = 0;                                //set scene number
            scene1.draw(pen);
            for (int numObs = 0; numObs < scene1.getObstacles().length; numObs++){      //draw obstacles in scene
                player.checkCollision(scene1.getObstacles()[numObs]);
            }
        }
        else if(sceneNumber == 0 && xPos >= 960) {          //exceeds boundary, switch to next scene
            player.setXPos(0);
            sceneNumber = 1;
        }
        else if (sceneNumber == 1 && xPos <= 0) {           //exceed boundary, go back to previous scene
            player.setXPos(960);
            player.setYPos(500);
            sceneNumber = 0;
        }
        else if (sceneNumber == 1 && xPos > 850 && xPos < 920 && yPos > 130 && yPos < 145) {        //exceed boundary, go to next scene
            sceneNumber = 2;
            player.setXPos(430);
            player.setYPos(30);
        }
        else if (sceneNumber == 1 && xPos < 960) {
            scene2.draw(pen);
            for (int numObs = 0; numObs < scene2.getObstacles().length; numObs++){
                player.checkCollision(scene2.getObstacles()[numObs]);
            }
        }
        else if(sceneNumber == 2 && yPos <= 500 && yPos > -20) {
            scene3.draw(pen);
            for (int numObs = 0; numObs < scene3.getObstacles().length; numObs++){
                player.checkCollision(scene3.getObstacles()[numObs]);
            }
        }
        else if(sceneNumber == 2 && yPos <= -20) {
            sceneNumber = 1;
            player.setXPos(870);
            player.setYPos(200);
        }
        else if(sceneNumber == 2 && yPos >= 500) {
            sceneNumber = 3;
            player.setXPos(10);
            player.setYPos(10);
        }
        else if(sceneNumber == 3 && yPos >= 0 && yPos <= 640 && xPos > 0 && xPos <= 960) {
            scene4.draw(pen);
            for (int numObs = 0; numObs < scene4.getObstacles().length; numObs++){
                player.checkCollision(scene4.getObstacles()[numObs]);
            }
        }
        else if (sceneNumber == 3 && yPos < 0) {
            sceneNumber = 2;
            player.setXPos(650);
            player.setYPos(500);
        }
        else if(sceneNumber == 3 && xPos >= 960) {
            sceneNumber = 4;
            player.setXPos(0);

        }
        else if(sceneNumber == 4 && xPos <= 0) {
            sceneNumber = 3;
            player.setXPos(960);
            player.setYPos(350);
        }
        else if(sceneNumber == 4 && xPos >= 0 && xPos <= 960) {
            scene5.draw(pen);
            for (int numObs = 0; numObs < scene5.getObstacles().length; numObs++){
                player.checkCollision(scene5.getObstacles()[numObs]);
            }
        }
        else if(sceneNumber == 4 && xPos >= 960) {
            sceneNumber = 5;
            player.setXPos(0);
            player.setYPos(320);
        }
        else if (sceneNumber == 5 && xPos >= 0 && xPos <= 960) {
            scene6.draw(pen);
            for (int numObs = 0; numObs < scene6.getObstacles().length; numObs++){
                player.checkCollision(scene6.getObstacles()[numObs]);
            }
        }
        else if (sceneNumber == 5 && xPos <= 0) {
            sceneNumber = 4;
            player.setXPos(960);
            player.setYPos(320);
        }
        else if (sceneNumber == 5 && xPos >= 960) {
            sceneNumber = 6;
            player.setXPos(150);
            player.setYPos(0);
        }
        else if(sceneNumber == 6 && yPos >= 0 && yPos <= 500) {
            scene7.draw(pen);
            for (int numObs = 0; numObs < scene7.getObstacles().length; numObs++){
                player.checkCollision(scene7.getObstacles()[numObs]);
            }
        }
        else if (sceneNumber == 6 && yPos <= 0) {
            sceneNumber = 5;
            player.setXPos(950);
            player.setYPos(450);
        }
        else if(sceneNumber == 6 && yPos >= 500) {
            sceneNumber = 7;
            player.setXPos(300);
            player.setYPos(10);
        }
        else if (sceneNumber == 7 && yPos >= 0 && yPos <= 640 && xPos <= 960) {
            scene8.draw(pen);
            for (int numObs = 0; numObs < scene8.getObstacles().length; numObs++){
                player.checkCollision(scene8.getObstacles()[numObs]);
            }
        }
        else if (sceneNumber == 7 && yPos <= 0) {
            sceneNumber = 6;
            player.setYPos(500);
            player.setXPos(370);
        }
        else if (sceneNumber == 7 && xPos >= 960) {
            sceneNumber = 8;
            player.setXPos(0);
            player.setYPos(320);
        }
        else if (sceneNumber == 8 && xPos >= 0) {
            scene9.draw(pen);
            for (int numObs = 0; numObs < scene9.getObstacles().length; numObs++){
                player.checkCollision(scene9.getObstacles()[numObs]);
            }
        }
        else if(sceneNumber ==8 && xPos <= 0) {
            sceneNumber = 7;
            player.setXPos(960);
            player.setYPos(280);
        }

        inventory.draw(pen);        
    }

    //getters and setters
    public Gameboard getScene1() { 
        return scene1;
    }

    public Gameboard2 getScene2() {
        return scene2;
    }

    public Gameboard3 getScene3() {
        return scene3;
    }

    public Gameboard4 getScene4() {
        return scene4;
    }

    public Gameboard5 getScene5() {
        return scene5;
    }

    public Gameboard6 getScene6() {
        return scene6;
    }

    public Gameboard7 getScene7() {
        return scene7;
    }

    public Gameboard8 getScene8() {
        return scene8;
    }

    public Gameboard9 getScene9() {
        return scene9;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getSceneNumber() {
        return sceneNumber;
    }

    //checks if won or lost
    public void setWon(boolean won) {
        if (won == true) {
            win = true;
        }
        else if (won == false) {
            lose = true;
        }
    }

}

