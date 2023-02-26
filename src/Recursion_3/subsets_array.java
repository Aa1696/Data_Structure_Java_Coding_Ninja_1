package Recursion_3;
/*
Return subset of an array
Send Feedback
Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.


Note : The order of subsets are not important.


Input format :

Line 1 : Size of array

Line 2 : Array elements (separated by space)

Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12
20
20 12
15
15 12
15 20
15 20 12
 */

public class subsets_array {
    public static int[][] subsets(int input[]) {
        // Write your code here
        return helper_subset(input,0);
    }
    public static int[][] helper_subset(int[] arr,int indx){
        if(indx==arr.length){
            return new int[1][0];
        }
        int[][] output=helper_subset(arr, indx+1);
        int [][] small_output=new int[2*output.length][];
        for(int i=0;i<output.length;i++){
            small_output[i]=new int[output[i].length];
            for(int j=0;j<output[i].length;j++){
                small_output[i][j]=output[i][j];
            }
        }
        for(int i=0;i<output.length;i++){
            small_output[i+output.length]=new int[output[i].length+1];
            small_output[i+output.length][0]=arr[indx];
            for(int j=1;j<=output[i].length;j++){
                small_output[i+output.length][j]=output[i][j-1];
            }
        }
        return small_output;
    }
}
