/**
Team Leader: Aaron Brombergues, 6131735, U01
Student:
Student:

6 - Write a program that simulates a statistics tool, by letting the user determine the minimum, the
maximum, the range (maximum – minimum), the mode (value that is repeated more often), the mean
(average), and the standard deviation of a set of numbers. These numbers, that will be stored in an
array, represent salaries in the $30K – $60K range and are to be generated randomly.
This is the definition of standard deviation,

sqrt[ (Σ(x-x̄)^2)/(n-1) ]  //sum from i=1 to n

where x̄ denotes the average, and n is the total number of elements in the array.
The program will present the user a menu with these choices:
- Populate Array
- Display Array
- Minimum
- Maximum
- Range
- Mode
- Mean
- Standard Deviation
- Exit
and will let the user run them until “Exit” is entered.
*/

import java.util.Arrays;
import java.util.Scanner;

public class project{
    
    //Displays menu
    static void displayMenu(){
        System.out.println("This is a statistics tool for salaries. Here are your choices:");
            
        System.out.println("- Populate Array\n" + "- Display Array\n" +
                "- Minimum\n" + "- Maximum\n" + "- Range\n" + "- Mode\n" + "- Mean\n" +
                "- Standard Deviation\n" + "- Exit\n");
            
        System.out.println("Please type in a choice (spelled correctly) then hit enter.");
        
        System.out.println("To show this menu again, type in \"Menu\".");
    }
    
    //Creates a randomized salary array with 1 user input (arrayLength)
    static double[] createRandomSalary(){
        Scanner in = new Scanner(System.in);
        System.out.println("How many salaries in the array?");
        int arrayLength = in.nextInt();
        
        double[] salaries = new double[arrayLength];

        for(int i=0;i<arrayLength;i++){
            salaries[i]= 30000+Math.random()*30000;
        }
        return salaries;
      }

    //Main method
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        displayMenu();
        
        //Main loop
        while(!exit){
            System.out.print(": ");
            String choice = in.nextLine();
            
            switch(choice.toUpperCase()){
                case "POPULATE ARRAY": break;
                case "DISPLAY ARRAY": break;
                case "MINIMUM": break;
                case "RANGE": break;
                case "MODE": break;
                case "MEAN": break;
                case "STANDARD DEVIATION": break;
                case "MENU": displayMenu(); break;
                case "EXIT": exit=true; break;
                default: System.out.println("Please give valid input");
            }
        }
  }
}

