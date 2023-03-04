package Com.PriorityQueue;
/*
Check Max-Heap
Send Feedback
Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains true if it represents max-heap and false if it is not a max-heap.
Constraints:
1 <= N <= 10^5
1 <= Ai <= 10^5
Time Limit: 1 sec
Sample Input 1:
8
42 20 18 6 14 11 9 4
Sample Output 1:
true
 */
public class Check_Max_Heap {
    public static boolean checkMaxHeap(int arr[]) {
        /*
         * Your class should be named Solution Don't write main(). Don't read input, it
         * is passed as function argument. Return output and don't print it. Taking
         * input and printing output is handled automatically.
         */
        int n=arr.length;
        int parent_index=0;
        int left_child_index=2*parent_index+1;
        int right_child_index=2*parent_index+2;
        while(left_child_index<n){
            if(arr[parent_index]<arr[left_child_index]){
                return false;
            }
            if(right_child_index<n && arr[parent_index]<arr[right_child_index]){
                return false;
            }
            parent_index +=1;
            left_child_index=2*parent_index+1;
            right_child_index=2*parent_index+2;

        }
        return true;
    }
}
