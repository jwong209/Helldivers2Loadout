import java.awt.*;
import java.awt.image.BufferedImage;

public class Competitor {
    private BufferedImage image;

    /*
     * TODO: Add some variables to keep track of the
     *  competitor's position
     */


    public Competitor(String imageURL){
        image = Racetrack.loadImage(imageURL);
    }

    public void update(){
        /*
         * TODO: Move the competitor some distance each game frame
         *  - for random distance: new Random().nextInt(10);
         */

    }

    public void draw(Graphics g){
        /*
         * TODO: Replace int literals with variables as needed
         */
        //                 x, y,  width, height
        g.drawImage(image, 0, 50, 100,   100, null);
    }
}
