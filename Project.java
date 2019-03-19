/**
Team Leader: Aaron Brombergues, 6131735, U01
Student: Justin Lee, 5445086, U01
Student: Natali Gutierrez, 6109509, U01

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
import java.util.Scanner;

public class Project{
    
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
    static float[] createRandomSalary(int arrayLength){
        Scanner in = new Scanner(System.in);
        
        float[] salaries = new float[arrayLength];

        for(int i=0;i<arrayLength;i++){
            salaries[i]= 30000+(float)Math.random()*30000;
        }
        return salaries;
      }
    
    //Gets a minimum
    static float getMinimum(float[] salaryArray){
        float min=60000;
        for(int i=0;i<salaryArray.length;i++){
            min =salaryArray[i]<min?salaryArray[i]:min;
        }
        return min;
    }
    
    //Gets a maximum
    static float getMaximum(float[] salaryArray){
        float max=30000;
        for(int i=0;i<salaryArray.length;i++){
            max =salaryArray[i]>max?salaryArray[i]:max;
        }
        return max;
    }
    
    //Gets a mode. If no mode, outputs 0
    static float getMode(float[] salaryArray){
        float mode = 0;
        int maxCount = 0;
        
        for (int i=0;i<salaryArray.length;i++){
            float value = salaryArray[i];
            int count = 0;
            for (int j=0;j<salaryArray.length;j++){
                if (salaryArray[j] == value) count++;
                if (count>maxCount){
                    mode = value;
                    maxCount = count;
                if(count==1){
                    mode = 0;
        }}}}
        
        return mode;
    }
    
    //Gets an average
    static float getAverage(float[] salaryArray){
        float sum = 0;
        for(int i=0;i<salaryArray.length;i++){
            sum+=salaryArray[i];
        }
        return sum/salaryArray.length;
    }
    
    //Gets standard deviation
    static float getStandardDeviation(float[] salaryArray){
        float sum=0;
        float standardDeviation=0;
        for(int i=0;i<salaryArray.length;i++){
            sum+=(float)Math.pow(salaryArray[i]-getAverage(salaryArray), 2);
            standardDeviation = (float)Math.sqrt(sum/(salaryArray.length-1));
        }
        return standardDeviation;
    }

    //Main method
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        boolean populated = false;
        
        //Getting an array length from user
        System.out.println("This program simulates a statistics tool that can be used to compare a number of salaries.");
        System.out.println("How many salaries will be generated?");
        int arrayLength = in.nextInt();
        float[] salaryArray = new float[arrayLength];
        
        displayMenu();
        
        //Main loop
        while(!exit){
            System.out.print(": ");
            int choice = in.nextInt();
            
            switch(choice){
                case 1:
                    salaryArray = createRandomSalary(arrayLength);
                    populated = true;
                    break;
                    
                case 2:
                    System.out.println(Arrays.toString(salaryArray));
                    break;
                    
                case 3:
                    System.out.println("Minimum is: "+getMinimum(salaryArray));
                    break;
                    
                case 4:
                	if(populated) {
                		System.out.println("Maximum is: "+getMaximum(salaryArray));
                	}else {
                		System.out.println("Maximum is: 0.0");
                	}
                	break;
                    
                case 5:
                	if(populated) {
                		System.out.println("Range is: "+(getMaximum(salaryArray)-getMinimum(salaryArray)));
                	}else {
                		System.out.println("Range is: 0.0");
                	}break;
                    
                case 6:
                	if(populated) {
	                    if(getMode(salaryArray)!=0){
	                    System.out.println("Mode is: "+getMode(salaryArray));
	                    }
	                    else {
	                    	System.out.println("No mode.");
	                    }
                	}else {
                		System.out.println("Mode is: 0.0");
                	}break;
                    
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
        in.close();
    }
}

