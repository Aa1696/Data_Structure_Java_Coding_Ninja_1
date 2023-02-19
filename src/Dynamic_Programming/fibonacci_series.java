package Dynamic_Programming;

import java.util.Scanner;

public class fibonacci_series {
    public int fibo(int []dp,int n){
        if(n==0||n==1){
            return n;
        }
        int left,right;
        if(dp[n-1]==-1){
            left=fibo(dp,n-1);
            dp[n-1]=left;
        }
        else{
            left=dp[n-1];
        }
        if(dp[n-2]==-1){
            right=fibo(dp,n-2);
            dp[n-2]=right;
        }
        else{
            right=dp[n-2];
        }
        int ans=left+right;
        return ans;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int []dp=new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        fibonacci_series fb=new fibonacci_series();
        System.out.println(fb.fibo(dp,n));
    }
}
