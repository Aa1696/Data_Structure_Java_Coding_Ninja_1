package Dynamic_Programming;
/*
LCS - Problem
Send Feedback
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.
For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.
Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Input format :
The first line of input contains the string 'S' of length 'M'.

The second line of the input contains the string 'T' of length 'N'.
Output format :
Return the length of the Longest Common Subsequence.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3.
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.
 */
public class Longest_Common_Subsequence {
    public static int lcs(String s, String t) {
        //Your code goes here
        int m=s.length();
        int n=t.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=-1;
            }
        }
        return lcsdp(s,t,0,0,dp);
    }
    public static int lcsdp(String s,String t,int i,int j,int[][]dp){
        if(i==s.length() || j==t.length()){
            return 0;
        }
        int myans;
        int sm_ans;
        int ans1,ans2;
        if (s.charAt(i) == t.charAt(j)) {
            if(dp[i+1][j+1]==-1){
                sm_ans = lcsdp(s, t, i + 1, j + 1,dp);
                dp[i+1][j+1]=sm_ans;
            }
            else{
                sm_ans=dp[i+1][j+1];
            }
            myans = sm_ans + 1;
        } else {
            if(dp[i][j+1]==-1){
                ans1 = lcsdp(s, t, i, j + 1,dp);
                dp[i][j+1]=ans1;
            }
            else{
                ans1=dp[i][j+1];
            }
            if(dp[i+1][j]==-1){
                ans2=lcsdp(s,t,i+1,j,dp);
                dp[i+1][j]=ans2;
            }
            else{
                ans2=dp[i+1][j];
            }
            myans = Math.max(ans1, ans2);
        }
        return myans;

    }
    public static int helper(String s,String t,int i,int j){
        if(i==s.length() || j==t.length()){
            return 0;
        }
        int myans;
        if(s.charAt(i)==t.charAt(j)){
            myans=helper(s,t,i+1,j+1);
            myans= myans+1;
        }
        else{
            int ans1=helper(s, t, i, j+1);
            int ans2=helper(s, t, i+1, j);
            myans=Math.max(ans1,ans2);
        }
        return myans;
    }
}
