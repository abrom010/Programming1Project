/**
 6 - Write a program that simulates a statistics tool, by letting the user determine the minimum, the
 maximum, the range (maximum – minimum), the mode (value that is repeated more often), the mean
 (average), and the standard deviation of a set of numbers. These numbers, that will be stored in an
 array, represent salaries in the $30K – $60K range and are to be generated randomly.
 This is the definition of standard deviation,

 sqrt[ (Σ(x_i -x̄)^2)/(n-1) ]  //sum from i=1 to n

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
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Project{
    public static void main(String[] args){

        boolean exit = false;
        int arrayLength;

        System.out.println("This program simulates a statistics tool that can be used to compare a number of salaries.");
        System.out.println("How many salaries will be generated?");

        do{
            arrayLength=requestArrayLength();
        } while(arrayLength==-1);

        int[] salaryArray = new int[arrayLength];
        displayMenu();

        //Main loop
        while(!exit){
            System.out.print(": ");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            switch(choice){
                case 1:
                    salaryArray = createRandomSalary(arrayLength);
                    break;

                case 2:
                    System.out.println(Arrays.toString(salaryArray));
                    break;

                case 3:
                    System.out.println("Minimum is: "+getMinimum(salaryArray));
                    break;

                case 4:
                    System.out.println("Maximum is: "+getMaximum(salaryArray));
                    break;

                case 5:
                    System.out.println("Range is: "+(getMaximum(salaryArray)-getMinimum(salaryArray)));
                    break;

                case 6:
                    printMode(salaryArray);
                    break;

                case 7:
                    System.out.println("Mean is: "+getAverage(salaryArray));
                    break;

                case 8:
                    System.out.println("Standard deviation is: "+getStandardDeviation(salaryArray));
                    break;

                case 9: exit=true; break;
                case 0: displayMenu(); break;
                default: System.out.println("Please give valid input");
            }
        }
    }

    //Gets an array length from user
    static int requestArrayLength(){
        Scanner in = new Scanner(System.in);
        try {
            double lengthBuffer = in.nextDouble();
            if (lengthBuffer < 1 || lengthBuffer % 1 != 0) {
                System.out.println("Must be a natural number");
            } else {
                return (int) lengthBuffer;
            }
            return -1;

        }catch(InputMismatchException e){
            System.out.println("Please input a number");
            return -1;
        }
    }

    //Displays menu
    static void displayMenu(){
        System.out.println("Here are your choices:");

        System.out.println("1 - Populate Array\n" + "2 - Display Array\n" +
                "3 - Minimum\n" + "4 - Maximum\n" + "5 - Range\n" + "6 - Mode\n" + "7 - Mean\n" +
                "8 - Standard Deviation\n" + "9 - Exit\n");

        System.out.println("Please type in a number, then hit enter.");

        System.out.println("To show this menu again, type in 0.\n");
    }

    //Creates a randomized salary array (30k-60k)
    static int[] createRandomSalary(int arrayLength){
        Scanner in = new Scanner(System.in);

        int[] salaries = new int[arrayLength];

        for(int i=0;i<arrayLength;i++){
            salaries[i]= 30000+(int)(Math.random()*30001);
        }
        return salaries;
    }

    //Gets a minimum
    static int getMinimum(int[] salaryArray){
        int min=60000;
        for(int i=0;i<salaryArray.length;i++){
            min =salaryArray[i]<min?salaryArray[i]:min;
        }
        return min;
    }

    //Gets a maximum
    static int getMaximum(int[] salaryArray){
        int max=0;
        for(int i=0;i<salaryArray.length;i++){
            max =salaryArray[i]>max?salaryArray[i]:max;
        }
        return max;
    }

    //Prints mode. Supports multiple modes and no mode.
    static void printMode(int[] salaryArray){
        ArrayList<Integer> mode = new ArrayList<Integer>();
        int maxCount = 0;
        System.out.println("Calculating...");

        for (int i=0;i<salaryArray.length;i++) {
            int value = salaryArray[i];
            int count = 0;

            for (int j = 0; j < salaryArray.length; j++) {
                if (salaryArray[j] == value) count++;

                if (count > maxCount) {
                    mode.clear();
                    mode.add(value);
                    maxCount = count;
                }else if(count==maxCount && !mode.contains(value)){
                    mode.add(value);
                }}};

        if(maxCount==1&&salaryArray.length!=1) {
            System.out.println("No mode");
        }else {
            System.out.println("Mode(s): " + mode + " found " + maxCount + " times");
        }
    }

    //Gets an average
    static float getAverage(int[] salaryArray){
        float sum = 0;
        for(int i=0;i<salaryArray.length;i++){
            sum+=salaryArray[i];
        }
        return sum/salaryArray.length;
    }

    //Gets standard deviation
    static float getStandardDeviation(int[] salaryArray){
        float sum=0;
        float standardDeviation=0;
        for(int i=0;i<salaryArray.length;i++){
            sum+=(float)Math.pow(salaryArray[i]-getAverage(salaryArray), 2);
            standardDeviation = (float)Math.sqrt(sum/(salaryArray.length-1));
        }
        return standardDeviation;
    }

}
