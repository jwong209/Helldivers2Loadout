import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/*
 * This class holds the variables and methods for a single racetrack
 *  - can add competitors to the race
 *  - can start race
 *  - can update and draw each competitor while the race is in progress
 */
public class Racetrack extends JPanel implements ActionListener {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int LANE_START_Y = 50;
    public static final int LANE_HEIGHT = 150;
    public static final String BACKGROUND_IMAGE_URL = "https://img.freepik.com/free-photo/green-grass-texture_1249-15.jpg";

    private String name;
    private int laneNum = 0;
    private boolean isRaceStarted = false;
    private List<Competitor> competitors;

    public Racetrack(String racetrackName){
        this();
        this.name = racetrackName;
    }

    public void addCompetitor(Competitor competitor){

        int laneStartY = LANE_START_Y + (this.laneNum * LANE_HEIGHT);
        competitor.setY(laneStartY);
        this.competitors.add(competitor);

        this.laneNum += 1;
    }

    public String getRacetrackName(){
        return this.name;
    }

    void drawCompetitors(Graphics g){
        if( this.competitors != null ) {
            /*
             * Only update competitor's position when race has started
             */
            if (this.isRaceStarted) {
                for (Competitor eachCompetitor : this.competitors) {
                    eachCompetitor.update();

                    /*
                     * DMC: Check if someone crossed the finish line!
                     */
                    if(eachCompetitor.getX() > WIDTH){
                        this.isRaceStarted = false;
                        JOptionPane.showMessageDialog(null, eachCompetitor.getName() + " has won!!");
                    }
                }
            }

            /*
             * Always draw competitors, even if race hasn't started
             */
            for (Competitor eachCompetitor : this.competitors) {
                eachCompetitor.draw(g);
            }
        }
    }































    /*
     * Daniel's super secret code
     * Avert your eyes NOW!
     */

    JFrame frame;
    Timer timer;
    BufferedImage bgImage;

    private Racetrack(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setTitle(this.name);
        frame.add(this);
        frame.pack();
        bgImage = loadImage(BACKGROUND_IMAGE_URL);

        timer = new Timer(1000 / 60, this);
        timer.start();

        competitors = new ArrayList<Competitor>();

        repaint();
    }

    public void startRace(){
        isRaceStarted = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        drawBackground(g);
        drawCompetitors(g);
    }
    
    void drawBackground(Graphics g){
        g.drawImage(bgImage, 0, 0, WIDTH, HEIGHT, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static BufferedImage loadImage(String imageFileURL) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(URI.create(imageFileURL).toURL());
        } catch (Exception e){
            System.out.println("Unable to find file: " + imageFileURL);
            e.printStackTrace();
        }

        return image;
    }
}
