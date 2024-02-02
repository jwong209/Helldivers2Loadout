public class RacingApp {

    public static void main(String[] args) {
        /*
         * TODO: Create a pro race tour
         */
        ProRaceTour mushroomCup = new ProRaceTour();

        /*
         * TODO: Create a new racetrack
         */
        Racetrack forest500 = new Racetrack("forest 500");

        /*
         * TODO: Create 1 competitor for the racetrack
         */
        String potatoesImageUrl = "https://www.pngfind.com/pngs/m/55-556567_sacks-of-potatoes-potato-bag-png-transparent-png.png";
        String pollyImageUrl = "https://raw.githubusercontent.com/dencee/method-climber/main/assets/images/polly-programmer.png";
        String rainbowBriteImageUrl = "https://static.wikia.nocookie.net/goodendfriends/images/2/22/Clip_rainbow_brite.png/";
        Competitor polly = new Competitor(pollyImageUrl, "Polly the Programming Owl");
        Competitor rainbowBrite = new Competitor(rainbowBriteImageUrl, "Rainbow Brite");
        Competitor potatoes = new Competitor(potatoesImageUrl, "Sack o' potatoes");

        /*
         * TODO: Add your competitor(s) to the racetrack
         */
        forest500.addCompetitor(polly);
        forest500.addCompetitor(rainbowBrite);
        forest500.addCompetitor(potatoes);

        /*
         * TODO: Add the racetrack to the pro tour!
         */
        mushroomCup.addRacetrackToTheTour(forest500);

        /*
         *  TODO: Start your race from the tour!
         *   Do you see your competitor? Why aren't they moving??
         *   Go into the Competitor class and see if you can make them move
         */
        mushroomCup.startRace(forest500.getRacetrackName());

        /*
         * TODO: After getting 1 Competitor to move,
         *  try adding other competitors
         */
    }
}
