
/**
 * These draw the background tiles that create the base of the scenery
 *
 * @author Jenny
 * @version Jan 27 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Background{
    //attributes 
    //allows to create new scenes in main
    Sprite bG;
    int w;
    int h;
    PVector pos;
    
    //default constructor
    public Background(Sprite backSprite, PVector bGpos, int screenWidth, int screenHeight) {
        bG = backSprite;
        w = screenWidth;
        h = screenHeight;
        pos = bGpos;
    }
        public void draw(GraphicsContext pen) {
         
        int numTilesRow = h / 32;
        int numTilesCol = w / 32;
        
        int goBack = 0 - w + (w - 32 * numTilesCol);
        
        PVector pos2 = pos;
            for(int numRowDraw = 0; numRowDraw < numTilesRow; numRowDraw++) {
                for(int numColDraw = 0; numColDraw < numTilesCol; numColDraw++) {
                    bG.draw(pen);
                    pos2 = pos2.add(new PVector(32, 0));
                    bG.setPosition(pos2);
            }
            pos2 = pos2.add(new PVector(goBack, 32));
            bG.setPosition(pos2);
        }
        
    }
}
