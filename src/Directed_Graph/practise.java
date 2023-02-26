package Directed_Graph;

import java.util.Arrays;
import java.util.Scanner;

public class practise {
    public static void practise1(int n){
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=7;
        }
        dfs(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void dfs(int[]arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]-1;
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        practise1(n);
    }
}
