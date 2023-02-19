package LinkedList;

import java.util.*;

public class Node_Test {
    public static boolean isPalindrome(Node<Integer> head) {
        //Your code goes here
        Node<Integer>curr=head;
        Node<Integer>prev=null;
        Node<Integer>tmp;
        while(curr !=null){
            tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        print(prev);
        print(head);
        while(prev !=null && head !=null){
            if(prev.data != head.data){
                return false;
            }
            prev=prev.next;
            head=head.next;
        }
        return true;
    }

    public static Node<Integer> Take_Input(){
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        Node<Integer> head=null;
        Node<Integer>tail=null;
        while(data != -1){
            Node<Integer> nd=new Node<>(data);
            if(head==null){
                head=nd;
                tail=nd;
            }
            else{
                tail.next=nd;
                tail=tail.next;
            }
            data=sc.nextInt();
        }
        return head;

    }
    public static Node<Integer> Create_Linked_List(){
        Node<Integer> nd1= new Node<>(10);
        Node<Integer> nd2=new Node<>(20);
        nd1.next=nd2;
        Node<Integer> nd3=new Node<>(30);
        nd2.next=nd3;
        Node<Integer> nd4=new Node<>(40);
        nd3.next=nd4;
        return nd1;

    }
    public static void print(Node<Integer>head){
        Node<Integer> tmp=head;
        while(tmp !=null){
            System.out.print(tmp.data +" ");
            tmp=tmp.next;
        }
    }
    public static void main(String[] args){
//        Node<Integer>node=new Node<>(20);
//        Node<Integer>head=Create_Linked_List();
//        System.out.println(head);
//        print(head);
        Node<Integer>hd=Take_Input();
        isPalindrome(hd);

        //System.out.println(node.next);//By default refernce has null value
    }
}
