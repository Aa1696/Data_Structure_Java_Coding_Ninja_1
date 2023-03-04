package Com.PriorityQueue;
/*
Code : Max Priority Queue
Send Feedback
Implement the class for Max Priority Queue which includes following functions -
1. getSize -
Return the size of priority queue i.e. number of elements present in the priority queue.
2. isEmpty -
Check if priority queue is empty or not. Return true or false accordingly.
3. insert -
Given an element, insert that element in the priority queue at the correct position.
4. getMax -
Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.
5. removeMax -
Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.
Note : main function is given for your reference which we are using internally to test the class.
 */
import java.util.*;
public class Max_Priority_Queue {
    private ArrayList<Integer>heap=new ArrayList<>();
    boolean isEmpty() {
        // Implement the isEmpty() function here
        if(heap.size()==0){
            return true;
        }
        return false;
    }

    int getSize() {
        // Implement the getSize() function here
        return heap.size();
    }

    int getMax() {
        // Implement the getMax() function here
        if(isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return heap.get(0);
    }

    void insert(int element) {
        // Implement the insert() function here
        heap.add(element);
        int child_index=heap.size()-1;
        int parent_index=(child_index-1)/2;
        // upheapify
        while(child_index>0){
            //when parent_index value is less than child_index value then int the heap bith will be swapped
            if(heap.get(parent_index)<heap.get(child_index)){
                int tmp=heap.get(parent_index);
                heap.set(parent_index,heap.get(child_index));
                heap.set(child_index,tmp);
                child_index=parent_index;
                parent_index=(child_index-1)/2;
            }
            else{
                return;
            }
        }

    }

    int removeMax() {
        // Implement the removeMax() function here
        if(isEmpty()){
            return Integer.MAX_VALUE;
        }
        int ans=heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int parent_index=0;
        int left_child_index=1;
        int right_child_index=2;
        while(left_child_index<heap.size()){
            int max_index=parent_index;
            if(heap.get(left_child_index)>heap.get(max_index)){
                max_index=left_child_index;
            }
            if(right_child_index<heap.size()){
                if(heap.get(right_child_index)>heap.get(max_index)){
                    max_index=right_child_index;
                }
            }
            if(max_index==parent_index){
                break;
            }
            //swapping the parent_index with max_index
            int tmp=heap.get(parent_index);
            heap.set(parent_index, heap.get(max_index));
            heap.set(max_index,tmp);
            //Assigning the parent_index ,left_child_index,right_child_index
            parent_index=max_index;
            left_child_index=2*parent_index+1;
            right_child_index=2*parent_index+2;
        }
        return ans;
    }
}
