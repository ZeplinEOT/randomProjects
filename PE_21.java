import java.io.*;
import java.util.*;

public class Solution {

    //globally declared summation variables.
    protected static long firstSum, secondSum, finalSum;

    /**
    * Main method calls summing method using parameters from a user's input.
    * With different sums, amicable numbers are found under a certain provided limit.
    * Once a pair of amicable numbers are found, they are added together and printed.
    *
    * @param String[] args NULL
    **/
    public static void main(String[] args) {
        
        //new scanner creation.
        Scanner scan = new Scanner(System.in);

        //number of sum calculations to occur.
        int queries = scan.nextInt();

        HashMap<Integer, Long> amicableSummations = new HashMap<Integer, Long>();

        //loop finds amicable pairs up to given bound (100,000) and sums them.
        for (int index = 1; index < 100000; index++) {

            //first sum is calculated.
            firstSum = findSumOfDivisors(index);
                
            //checks for amicable instance.
            if (index == firstSum) { continue; }

            //second sum is computed.
            secondSum = findSumOfDivisors(firstSum);

            //checks for amicable intance again and adds sums if instance exists.
            if (index != firstSum && index == secondSum) { 
                    
                //adds to sum and inserts into map.
                finalSum += index;
                amicableSummations.put(index, finalSum); 

            } else { amicableSummations.put(index, finalSum); }
        }

        //while prints for each query.
        while (queries-- > 0) {
            
            //prints solutions.
            int numberInput = scan.nextInt();
            System.out.println(amicableSummations.get(numberInput));
        }
    }

    /**
    * Method receives an integer and sums all of its proper divisors.
    *
    *
    * @param int inputNumber any natural number to be provided.
    * @return sumOfDivisors sum of all divisors of the provided number.
    **/
    protected static long findSumOfDivisors(final long inputNumber) {

        //sum is initialized as one, not zero.
        long sumOfDivisors = 1;

        //loop calculates sum of divisors of the parameter input.
        for (long divisor = 2; divisor <= Math.sqrt(inputNumber); divisor++) {

            //divisor check.
            if (inputNumber % divisor == 0) { 
                
                //summation.
                sumOfDivisors += divisor; 

                //dividing only once for better Big-O.
                long division = inputNumber / divisor;

                //case check for perfect squares.
                if (division != divisor) { sumOfDivisors += division; }
            }
        }

        //sum of all proper divisors is returned.
        return sumOfDivisors;
    }
}