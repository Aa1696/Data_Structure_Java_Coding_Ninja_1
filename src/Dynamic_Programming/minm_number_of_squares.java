package Dynamic_Programming;
/*
Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
Input format :
The first and the only line of input contains an integer value, 'N'.
 Output format :
Print the minimum count of numbers required.
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
12
Sample Output 1 :
3
Explanation of Sample Output 1 :
12 can be represented as :
A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)

B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)  + (2 ^ 2)

C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)

D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)

As we can see, the output should be 3.
Sample Input 2 :
9
Sample Output 2 :
1
 */
public class minm_number_of_squares {
    public static int minCount(int n) {
        //Your code goes here
        int []dp=new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return helper(n,dp);
    }
    public static int helper(int n,int[]dp){
        if(n==0){
            return 0;
        }
        int min_ans=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int ans;
            if(dp[n-(i*i)] ==-1){
                ans=helper(n-(i*i),dp);
                dp[n-(i*i)]=ans;
            }
            else{
                ans=dp[n-(i*i)];
            }
            if(min_ans>ans){
                min_ans=ans;
            }
        }
        int req_ans=min_ans+1;
        return req_ans;
    }
}
