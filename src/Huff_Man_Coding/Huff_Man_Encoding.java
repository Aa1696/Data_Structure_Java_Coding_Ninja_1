package Huff_Man_Coding;

import java.util.*;

class HuffMan{
    int freq;
    Character c;
    HuffMan left;
    HuffMan right;
    HuffMan(int freq,char c){
        this.freq=freq;
        this.c=c;
        this.left=null;
        this.right=null;

    }

    public HuffMan() {

    }
}
class Mycomparator implements Comparator<HuffMan>{

    @Override
    public int compare(HuffMan x, HuffMan y) {
        return x.freq-y.freq;
    }
}
public class Huff_Man_Encoding {
    public static void printcode(HuffMan root,String s){
        if(root.left==null && root.right==null && Character.isLetter(root.c)){
            System.out.println(root.c + " "+ s);
            return;
        }
        //recursive call of respective left and right subtree
        printcode(root.left,s +  "0");
        printcode(root.right,s+"1");

    }
    public static void main(String[] args){
        char[] arr={ 'a', 'b', 'c', 'd', 'e', 'f' };;
        int []freq={ 5, 9, 12, 13, 16, 45 };
        int n=arr.length;
        //make the node of each frequencies coresponding to the characters
        PriorityQueue<HuffMan>pq=new PriorityQueue<>(n,new Mycomparator());
        for(int i=0;i<arr.length;i++){
            HuffMan hf= new HuffMan(freq[i],arr[i]);
            pq.add(hf);
        }
        HuffMan root=null;
        while(pq.size()>1){
            HuffMan x=pq.peek();
            pq.poll();
            HuffMan y=pq.peek();
            pq.poll();
            int frq=x.freq+y.freq;
            HuffMan fn1= new HuffMan();//make the node with added with frequencies
            fn1.freq=frq;
            fn1.c='-';
            fn1.left=x;
            fn1.right=y;
            root=fn1;
            pq.add(fn1);
        }
        printcode(root,"");

    }

}
