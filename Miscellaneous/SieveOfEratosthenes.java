package Miscellaneous;
import java.util.*;
class SieveOfEratosthenes{

    /*
        Sieve of Eratosthenes is a popular Algorithm used to determine the prime numbers in a given range of 1 to n.
        Time Complexity of this algorithm is O(n*log(log(n))).

        In this algorithm, we have a boolean array of size n, with all values as true. We start moving from index 1 to n and check
        if the index value is a prime or not. If the index i is prime, we go on to change the trues for all the multiples of the 
        index i, to false. 
        In this way, for n = 10, in our 1st iteration i.e. i = 2, we mark all it's multiples as false,
        i.e. for i = 4, 6, 8, 10, the sieve is false. It won't be checking the prime condition for these indexes.
        In the next iteration, for i = 3, we mark 6(which was already false) and 9 as false. i = 4 is skipped as it has false value,
        i = 5, 10 was already marked false, i = 6 is already false, and i = 7 is prime.
        
        So after the execution of this, our sieve array has true value at only 2, 3, 5, 7 indexes, which are all primes.
    */
	public static void main(String args[]) {
        // make a Scanner object
        Scanner in = new Scanner(System.in);

        // Taking Input of UpperBound
        System.out.println("Enter the upper bound of the range in which you want the Prime Numbers.");
        int n = in.nextInt();
        
        // Make a boolean array to store the prime or not based on index
        boolean Sieve[] = new boolean[n+1];

        // Adding dummy values to all elements as True
		for(int i=0;i<n;i++)
			Sieve[i] = true;
        
        //checking if i is prime, then changing all the multiples of i to false in the Sieve array
		for(int i = 2; i*i <=n; i++){
			if(Sieve[i] == true){
				for(int j = i*2; j <= n; j += i)
					Sieve[j] = false;
			}
        }

        //Printing the Sieve
		for(int i = 2; i <= n; i++){
			if(Sieve[i] == true)
				System.out.print(i + " ");
        }

        // Closing the scanner object to remove un-necessary error in the IDE
        in.close();
	}
}