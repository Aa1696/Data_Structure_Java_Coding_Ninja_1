package Com.PriorityQueue;

import java.util.ArrayList;

/*
K Largest Elements
Send Feedback
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(nlogk) and space complexity should be not more than O(k).
Order of elements in the output is not important.
Input Format :
Line 1 : Size of array (n)
Line 2 : Array elements (separated by space)
Line 3 : Integer k
Output Format :
k largest elements
Sample Input :
13
2 12 9 16 10 5 3 20 25 11 1 8 6
4
Sample Output :
12
16
20
25
 */
public class K_Largest {
    public static void downheapify(int arr[],int i,int n){
        int parent_index=i;
        int left_child_index=2*parent_index+1;
        int right_child_index=2*parent_index+2;
        while(left_child_index<n){
            int max_index=parent_index;
            if(arr[left_child_index]>arr[max_index]){
                max_index=left_child_index;
            }
            if(right_child_index<n && arr[right_child_index]>arr[max_index]){
                max_index=right_child_index;
            }
            if(parent_index==max_index){
                return;
            }
            //swapping the parent_child_index with max_parent_child
            int tmp=arr[max_index];
            arr[max_index]=arr[parent_index];
            arr[parent_index]=tmp;
            //calibirating the parent_child,left_child and right_child index
            parent_index=max_index;
            left_child_index=2*parent_index+1;
            right_child_index=2*parent_index+2;
        }
    }
    public static ArrayList<Integer> kLargest(int input[], int k) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int n=input.length;
        int mid=n/2;
        //making the heap
        for(int i=mid-1;i>=0;i--){
            downheapify(input,i,n);
        }
        //sorting the heap
        for(int i=n-1;i>=0;i--){
            int tmp=input[i];
            input[i]=input[0];
            input[0]=tmp;
            downheapify(input,0,i);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int j=n-k;j<n;j++){
            ans.add(input[j]);
        }
        return ans;

    }
}
