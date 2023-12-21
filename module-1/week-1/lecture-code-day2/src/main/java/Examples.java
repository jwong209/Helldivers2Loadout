public class Examples {
    public String isEven(int number){

        if(number % 2 == 0) {
            return "even";
        } else if(number % 2 == 1) {
            return "odd";
        }

        // code here, uh oh no string is returned ack!!!!
        //return "";
    }
    // ^ There is an error here...why?

    // Given averageModuleScore of 0 - 3
    public boolean checkGoodAcademicStanding(double averageModuleScore) {

        // Answer 1
//        if( averageModuleScore >= 2.0 ){
//            return true;
//        } else {
//            return false;
//        }

        // Answer 2
//        if( averageModuleScore >= 2.0 ){
//            return true;
//
//            // no code after this point ^
//        }
//        return false;

        // Answer 3
        return averageModuleScore >= 2.0;
    }
}
