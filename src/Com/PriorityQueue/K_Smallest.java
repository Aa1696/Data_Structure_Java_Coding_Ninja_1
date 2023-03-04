package Com.PriorityQueue;

import java.util.ArrayList;

/*
K Smallest Elements
Send Feedback
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k smallest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(n * logk) and space complexity should not be more than O(k).
Note: Order of elements in the output is not important.
Input Format :
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
The following line contains an integer, that denotes the value of k.
Output Format :
The first and only line of output print k smallest elements. The elements in the output are separated by a single space.
Constraints:
Time Limit: 1 sec
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6
4
Sample Output 1 :
1 2 3 5
 */
public class K_Smallest {
    public static void downheapify(int []arr,int i,int n){
        int parent_index=i;
        int left_child_index=2*parent_index+1;
        int right_child_index=2*parent_index+2;
        while(left_child_index<n){
            int min_index=parent_index;
            if(arr[left_child_index]<arr[min_index]){
                min_index=left_child_index;
            }
            if(right_child_index<n && arr[right_child_index]<arr[min_index]){
                min_index=right_child_index;
            }
            if(parent_index==min_index){
                return;
            }
            int tmp=arr[min_index];
            arr[min_index]=arr[parent_index];
            arr[parent_index]=tmp;
            parent_index=min_index;
            left_child_index=2*parent_index+1;
            right_child_index=2*parent_index+2;
        }
    }
    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
        // Write your code here
        int len=input.length;
        int mid=len/2;
        for(int i=mid-1;i>=0;i--){
            downheapify(input,i,len);
        }
        for(int j=len-1;j>=0;j--){
            int tmp=input[0];
            input[0]=input[j];
            input[j]=tmp;
            downheapify(input,0,j);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=len-k;i<len;i++){
            ans.add(input[i]);
        }
        return ans;

    }
}
