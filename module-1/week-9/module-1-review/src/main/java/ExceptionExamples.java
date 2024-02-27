import exceptions.CarMaintenanceException;
import exceptions.OilChangeException;
import exceptions.OutOfFuelException;
import exceptions.TireRotationException;
import vehicle.Car;
import vehicle.CarNoException;

import java.io.*;
import java.util.Random;

public class ExceptionExamples {

    public static void main(String[] args) throws FileNotFoundException {

        Object obj = new Object();
        String str = "";
        String str2 = "";
        str.equals(str2);

        ExceptionExamples examples = new ExceptionExamples();

        //examples.carWithoutExceptions();
        examples.carWithExceptions();
    }

    public void carWithoutExceptions(){

        CarNoException car = new CarNoException();

        for (int i = 0; i < 300; i++) {

            int randomDistance = getRandomInt(50, 200);
            writeLog("Driving " + randomDistance + " miles, total: " + car.getOdometer());
            int errorCode = car.drive(randomDistance);

            if(errorCode == CarNoException.REQUIRES_OIL_CHANGE){
                writeLog("========== Changing oil ==========");
            } else if( errorCode == CarNoException.REQUIRES_MAINTENANCE){
                writeLog("========== Performing car maintenance ==========");
            } else if( errorCode == CarNoException.REQUIRES_TIRE_ROTATION){
                writeLog("========== Performing tire rotation ==========");
            } else if( errorCode == CarNoException.REQUIRES_FUEL){
                writeLog("========== Getting more fuel ==========");
            }
        }
    }

    public void carWithExceptions() {

        Car car = new Car();

        for (int i = 0; i < 300; i++) {
            try {

                int randomDistance = getRandomInt(50, 200);
                writeLog("Driving " + randomDistance + " miles, total: " + car.getOdometer());
                car.drive(randomDistance);

            } catch (OilChangeException e) {
                writeLog("========== Changing oil ==========");
            } catch (CarMaintenanceException e) {
                writeLog("========== Performing car maintenance ==========");
            } catch (TireRotationException e) {
                writeLog("========== Performing tire rotation ==========");
            } catch (OutOfFuelException e) {
                writeLog("========== Getting more fuel ==========");
            }
        }
    }

    public static int getRandomInt(int min, int max){
        return new Random().nextInt(max - min) + min;
    }

    public void writeLog(String message){

        File logFile = new File("car-log.log");

        try(PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {

            writer.println(message);
            writer.flush();

        } catch(FileNotFoundException e){
            System.out.println("[Error] file not found");
        }
    }
}