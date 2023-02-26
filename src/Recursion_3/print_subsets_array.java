package Recursion_3;
/*
Print Subsets of Array
Send Feedback
Given an integer array (of length n), find and print all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important. Just print the subsets in different lines.
Input format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Constraints :
1 <= n <= 15
 */
public class print_subsets_array {
    public static void printSubsets(int input[]) {
        // Write your code here
        int[] ans=new int[0];
        int indx=0;
        printsubsets(input,indx,ans);
    }
    public static void printsubsets(int input[],int si,int output[])
    {
        if(si==input.length)
        {
            for(int i:output){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        printsubsets(input,si+1,output);

        int newoutput[]=new int[output.length+1];
        int j=0;
        for( ;j<output.length;j++)
        {
            newoutput[j]=output[j];
        }
        newoutput[j]=input[si];
        printsubsets(input,si+1,newoutput);
    }
}
