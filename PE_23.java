import java.io.*;
import java.util.*;

public class Solution {

    //Limit for calculating abudant numbers.
    protected static int NUMBER_LIMIT = 28123;
    
    //Boolean array will verify which numbers are abudant under the computational limit.
    protected static boolean[] numbersOfAbundance = new boolean[NUMBER_LIMIT];

    /**
    * Main methods calls methods that determine whether a user provided number contains
    * an abundant number.
    *
    * @param String[] args NULL
    **/
    public static void main(String[] args) {

        //all abundant numbers are calculated and declared in the boolean array.
        findAbundantNumbers();
        
        //new scanner creation.
        Scanner scan = new Scanner(System.in);

        //number of instances to occur.
        int queries = scan.nextInt();

        //while prints for each query.
        while (queries-- > 0) {
            
            //current number is scanned.
            int numberInput = scan.nextInt();
            
            //Checks for whether the input is an abundant number.
            if (numberInput > NUMBER_LIMIT) { System.out.println("YES"); } 
            else if (isAbundant(numberInput)) { System.out.println("YES"); }
            else { System.out.println("NO"); }
        }

        //scanner closed.
        scan.close();
    }

    /**
    * Method receives an integer and calculates its sum of divisors.
    *
    *
    * @param int inputNumber Any natural number to be provided.
    * @return sumOfDivisors Computed sum of the divisors.
    **/
    protected static int getSum(final int inputNumber) {

        //integer initialized for summation of all divisors.
        int sumOfDivisors = 0;

        //loop calculates the sum of divisors of the given integer.
        for (int divisor = 2; divisor * divisor < inputNumber; divisor++) {

            //divisor check.
            if (inputNumber % divisor == 0) { 
                
                //summation. 
                sumOfDivisors += (divisor + inputNumber / divisor); 
            }
        }

        //sum of zero check.
        if (sumOfDivisors != 0) { 
            
            sumOfDivisors++;
            return sumOfDivisors;
        
        }

        //sum of all divisors is computed.
        return sumOfDivisors;
    }

    /**
    * Method calculates each abundant number and initialzes them as a boolean value
    * inside of a boolean array.
    *
    * Abundant integers are set to true and vice versa.
    **/
    protected static void findAbundantNumbers() {

        //each number is checked up to the number limit of 28,123.
        for (int index = 1; index <= NUMBER_LIMIT; index++) {
            
            if (index > 6 && index % 6 == 0) { 
                
                numbersOfAbundance[index] = true; 

            } else { if (index < getSum(index)) { numbersOfAbundance[index] = true; } }
        }
    }

    /**
    * Method verifies whether a provided integer is abudant.
    * It uses the boolean 'numbersOfAbudance' to do so.
    * 
    * @param int numberInput Integer to be evaluated for abundancy.
    * @return true OR false If number is abudant.
    **/
    protected static boolean isAbundant(final int numberInput) {
        
        //input is modified.
        int modifiedInput = (numberInput + 1) / 2;
        
        //loop verifies abundancy. Returns true if abundant.
        for (int index = 1; index <= modifiedInput; index++) {
            
            //each index is checked.
            if (numbersOfAbundance[index] && numbersOfAbundance[numberInput - index]) { 
                
                return true; 
            }
        }
        
        //number is not abundant.
        return false;
    }
}
