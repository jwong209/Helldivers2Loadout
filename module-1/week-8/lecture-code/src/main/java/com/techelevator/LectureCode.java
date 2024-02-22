package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class LectureCode {
    private final String TEST_FILE_PATH = "test-file.txt";

    public static void main(String[] args) {
        new LectureCode().run();
    }

    public void run(){

        File testFile = new File(TEST_FILE_PATH);
        File secondTestFile = new File("src/main/java/com/techelevator/read-test-file.txt");

        checkFileExists(testFile);
        checkFileExists(secondTestFile);

        readFile(testFile);
        readFile(secondTestFile);

        createDirectory("test-directory");

        try {
            writeFile(testFile);
            writeFileAppend(testFile);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found!");
            e.printStackTrace();
        }

        readAndWriteFile(secondTestFile, new File("test-directory", "counts.txt"));
    }

    private void readAndWriteFile(File fileToRead, File fileToWrite) {

        try( Scanner readScanner = new Scanner(fileToRead);
             PrintWriter writer = new PrintWriter(new FileOutputStream(fileToWrite, true)))
        {

            int lineNumber = 1;

            // Desired output: line 1 has 3 ts
            while(readScanner.hasNextLine()){

                String readLine = readScanner.nextLine();

                String stringWithTsRemoved = readLine.replaceAll("t", "");
                int numTs = readLine.length() - stringWithTsRemoved.length();

                // Line 1 has 2 ts
                // Line 2 has 5 ts
                writer.println("line " + lineNumber + " has " + numTs + " ts" );
                writer.flush();

                lineNumber += 1;
            }

        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeFileAppend(File fileToWrite) throws FileNotFoundException {

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileToWrite, true))) {
            String textToWrite = "This is some appended text";
            writer.println(textToWrite);
            writer.flush();
        }
    }

    public void writeFile(File fileToWrite) throws FileNotFoundException {

        try (PrintWriter writer = new PrintWriter(fileToWrite)) {

            // ln => \n
            String textToWrite = "Hello class!\nHow's is file IO going?";
            writer.println(textToWrite);
            writer.flush();
        }
    }

    public void createDirectory(String dirPath){

        File newDirectory = new File(dirPath);

        if(newDirectory.exists()){
            System.out.println("File already exists at path: " + dirPath);
        } else {
            System.out.println("Creating directory at: " + newDirectory.getPath());
            newDirectory.mkdir();
        }
    }


    public boolean checkFileExists(File fileObj) {
        boolean exists = fileObj.exists();
        System.out.println("Does " + fileObj.getPath() + " exist? " + exists );
        return exists;
    }

    public void readFile(File fileToRead){
        try (Scanner readScanner = new Scanner(fileToRead)) {

            System.out.println("Reading: " + fileToRead.getPath());

            while(readScanner.hasNextLine()){
                String lineRead = readScanner.nextLine();
                System.out.println(lineRead);
            }

            System.out.println();

        } catch(FileNotFoundException e) {
            System.out.println("File not found!!!!");
        }
    }

    public void createFile(String filePath){

        File newFile = new File(filePath);

        if(newFile.exists()){
            System.out.println("File already exists at path: " + filePath);
        } else {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
