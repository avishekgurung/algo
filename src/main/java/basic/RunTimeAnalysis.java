package basic;

/**
 * How do we compare the efficiency of two algorithms?
 * 1. Execution speed? Not a good way since the speed might depend upon the underlying hard wares.
 * 2. No of lines of code ? Again not a good way since the lines of code might depend based on the languages.
 * 3. Runtime Analysis: The ideal way is to express these algorithms as a function of n (size of input) and then
 * compare these functions with their running time analysis (RTA). The RTA of a function is a time taken by a function
 * as the size of the input increases.
 *
 * There are three type of analysis
 * 1. Best case (Big O): The longest time that the algorithm might take for an input.
 * 2. Average case:
 * 3. Worst case:
 *
 *
 *
 */


public class RunTimeAnalysis {

    int count = 0;

    public static void main(String[] args) {
        int n = -2147483648;
        System.out.println(n);
        long m = n;
        System.out.println(Math.abs(m));
    }

}
