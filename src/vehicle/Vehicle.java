/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Module Title: Programming: Object-Oriented Approach
 * Assessment Title: File Access CA
 * Lecture: Ken Healy
 * @author Carolina Gomes Landim
 * Student Number: 2021226
 * Assessment Due Date: 06th of November, 2021
 * Date of Submission: 05th of November. 2021 
 */
public class Vehicle {

    /**
     * 1) Get Input;
     * 2) Put a file reader
     * 3) Put a write in a file
     * 4) Put a while
     * 5) Find the location in variable myV
     * 6) If there is no location error message
     * 7) Assuming space -> get everything in left of space = brand name
     * 8) Everything in right is modelName
     * 9) Check if myV there letter if not error message
     * 10) Check variable max passenger number
     * 11) Depend on numbers is going to show different on variable carType:
     *   if max passenger is 1 print Racing Car
     *   if max passenger is 2 print Sports Car
     *   if max passenger is between 3 to 5 print Saloon
     *   if max passenger is between 6 to 8 print SUV
     * 12) Put variable licenceNumber 
     * 13) Check if the licenceNumber start with numbers ,if  4th is letter,if the 5th is letter or number and if the final is number, if is not print a error message
     * 14) Check and convert the licenceNumber to see if the last numbers are between 100 to 30000, if is not print error
     * 15) Check if the first licenceNumber to see if 2020 or more
     * 16) Write the output in a file licenceNumber, modelName and carType 
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String myV, brandCar, modelName = null, carType = null;
        /** Variables:
        myV = the fullname car such as brand name and model name
        brandCar =  vehicle brand name
        modelName = vehicle model it is null for the variable doesn't appear red error
        carType = vehicle type such as Racing Car, Sports Car, Sallon or SUV. The variable is null because of the same problem that could exist in vehicle model
        */
        try {
            //Here as a rule try and catch to best results.

            Scanner myVehicle = new Scanner(new FileReader("vehicle.txt"));
            //Here use Scanner to read my file called vehicle.txt.

            BufferedWriter writeCar = new BufferedWriter(new FileWriter("status.txt", true));
            //Here use Buffered as a writer the file called status.txt 
            //Here the status.txt is true because it will be record to the file the previous one.

            while (myVehicle.hasNextLine()) {
                //here is where while the start of looping and when something happen is going to do a lot of functions and going back ans start over again.

                myV = myVehicle.nextLine();
                

                int locationSpace = myV.indexOf(" ");//find space
                if (locationSpace == -1) {
                    //Here If it doesn't find the location is going to shows an error message:
                    System.out.println(myV + " Error! There is no space");
                } else {
                    brandCar = myV.substring(0, locationSpace);
                    modelName = myV.substring(locationSpace + 1);
                    //Here It is going to check a space between vehicle brand name to vehicle model name.

                    if (!brandCar.matches("[A-Za-z]+")) {
                        //Here If my fullname car isn't a word it, get an error message:
                        
                        System.out.println(brandCar + " Error, the car brad text only  with space!");

                    }

                }
                int maxPassenger = Integer.parseInt(myVehicle.nextLine());
                //Here put maxPassenger as a number. Here start if for the max passenger

                if (maxPassenger < 1 || maxPassenger > 8) {
                    //Here check the maxPassenger must be between 1 and 8 if not show an error message: 
                    System.out.println(maxPassenger + " The maximum number of passenger need to be between 1 an 8");
                } else if (maxPassenger == 1) {
                    carType = "Racing car";
                } else if (maxPassenger == 2) {
                    carType = "Sports car";
                } else if (maxPassenger >= 3 && maxPassenger <= 5) {
                    carType = "Saloon";
                } else {
                    carType = "SUV";
                }
                //here check the car capacity which each one has a different type. Here finish the "if" for max passenger.

                String licenceNumber = myVehicle.nextLine();
                //Here output licence number. Here start another "if" for the licence number

                if ((licenceNumber.length() < 6) || (licenceNumber.length() > 9)) {
                    //Here the licence must start with 6 caracters and I put 9 as a good number for the last task. If it wasn't between 6 and 9 it should appear an error message: 
                    System.out.println(licenceNumber + " The license number must start with 3 number, the 4th must be a letter, the 5th can be letter or a number and the  final must be number");

                } else {
                    String first3 = licenceNumber.substring(0, 3);
                    //Here check the first 3 number on licence number 

                    if (!first3.matches("[0-9]+")) {
                        //Here "if" the first 3 caracters aren't number it should apear an error message:      
                        System.out.println(licenceNumber + " Error! Please type first 3 number");
                    }
                   
                    String middle1 = licenceNumber.substring(3, 4);
                    // Here is middle after the 3th number in licence number

                    if (!middle1.matches("[A-Za-z]+")) {
                        //The 4th number has a condition to be just a letter if not it is going to show an error message:
                        System.out.println(licenceNumber + " Error! Please type a letter");
                    }

                    String middle2 = licenceNumber.substring(4, 5);
                    // Here is after 4th number in licence number which had an specific condition

                    if ((!middle2.matches("[A-Za-z0-9]+"))) {
                        //Here is the 5th number in licence number that could be letter or number if it doesn't happen then appear a message error:
                        System.out.println(licenceNumber + " Error! Please type a number or a letter");
                    }
                    String last3 = licenceNumber.substring(6, 8);
                    //Here is the lastest numbers in licence number that is going to be just numbers

                    if (!last3.matches("[0-9]+")) {
                        //Here is the lastest numbers that must be a number if not, appears an error message
                        System.out.println(licenceNumber + " Error! Please type a number");
                    }
                    else{
                        if (Integer.parseInt(licenceNumber.substring(0, 2)) < 20) {
                        //Here is checking if the two first numbers start from the year 2020. If not shows the error message:        
                        System.out.println(licenceNumber + " Error. It must start with 20");
                    }
                      else  if (middle2.matches("[0-9]+")) {
                        // Here is the middle to from the licence number which will check after the letters in the middle, if the lastests numbers are between 100 and 30000   

                            if (Integer.parseInt(licenceNumber.substring(4)) >= 100 && Integer.parseInt(licenceNumber.substring(4)) <= 30000) {
                                //Here if the condition after 4th letter in the licence number is following the task:

                               
                                writeCar.write(licenceNumber + " - " + modelName + "\n" + carType);
                                writeCar.newLine();
                            }//Here is  write in a file called status.txt. If the licence number is following all conditions then shows every time that is correct.

                    } else if (middle2.matches("[A-Za-z]+")) {
                        //Here is when the 5th is a letter in licence number with is possible, then the condition above start after the 5th letter and shows if the numbers are between 100 and 3000 
                            if (Integer.parseInt(licenceNumber.substring(5)) >= 100 && Integer.parseInt(licenceNumber.substring(5)) <= 30000) {
                                    
                                
                                writeCar.write(licenceNumber + " - " + modelName + "\n" + carType);
                                writeCar.newLine();
                                //Here is writing in the file called status.txt. If the licence number is correct
                            }else {
                                System.out.println(licenceNumber + " Error! The final number must be between 100 to 30000");
                            }
                    }
                }
                }
            }
            writeCar.close();
            //Here it is when the write finished

        } catch (Exception e) {
            //Here is when there is no file or the file is empty
            System.out.println("The File is empty");

        }
    }
}
