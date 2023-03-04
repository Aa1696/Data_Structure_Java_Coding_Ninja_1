package Com.PriorityQueue;
/*
Inplace Heap Sort
Send Feedback
Given an integer array of size N. Sort this array (in decreasing order) using heap sort.
Note: Space complexity should be O(1).
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array or N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains array elements after sorting. The elements of the array in the output are separated by single space.
Constraints :
1 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1:
6
2 6 8 5 4 3
Sample Output 1:
8 6 5 4 3 2
 */
public class Inplace_Heap_Sort {
    public static void downheapify(int arr[],int i,int n){
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
            int tmp=arr[parent_index];
            arr[parent_index]=arr[min_index];
            arr[min_index]=tmp;

            //Assigning the parent,left and child index
            parent_index=min_index;
            left_child_index=2*parent_index+1;
            right_child_index=2*parent_index+2;
        }

    }
    public static void inplaceHeapSort(int arr[]) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given input itself.
         * Taking input and printing output is handled automatically.
         */
        int mid=arr.length/2;
        int n=arr.length;
        //Building the Heap
        for(int i=mid-1;i>=0;i--){
            //downheapify
            downheapify(arr,i,n-1);
        }
        //removing the element and putting at  the element at their respective position
        for(int i=n-1;i>=0;i--){
            int tmp=arr[i];
            arr[i]=arr[0];
            arr[0]=tmp;
            downheapify(arr,0,i);
        }

    }
}
