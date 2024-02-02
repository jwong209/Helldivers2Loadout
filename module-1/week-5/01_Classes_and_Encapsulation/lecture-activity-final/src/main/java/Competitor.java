import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Competitor {
    private BufferedImage image;

    /*
     * TODO: Add some variables to keep track of the
     *  competitor's position
     */
    private int x = 0;
    private int y = 0;
    private String name;

    public Competitor(String imageURL, String name){
        this.image = Racetrack.loadImage(imageURL);
        this.name = name;
    }

    public void update(){
        /*
         * TODO: Move the competitor some distance each game frame
         *  - for random distance: new Random().nextInt(10);
         */
        int randomDistance = new Random().nextInt(10);
        this.x += randomDistance;
    }

    public void draw(Graphics g){
        /*
         * TODO: Replace int literals with variables as needed
         */
        //                 x, y,  width, height
        g.drawImage(image, x, y, 100,   100, null);
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public String getName(){
        return this.name;
    }
}
