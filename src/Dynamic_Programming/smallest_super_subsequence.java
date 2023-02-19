package Dynamic_Programming;

public class smallest_super_subsequence {
    static int super_subsequence(String str1,String str2){
        int n1=str1.length();
        int n2=str2.length();
        int [][]dp=new int[n1+1][n2+1];
        //Covering the base cases and corner cases
        for(int i=n2;i>=0;i--){
            dp[n1][i]=n2-i;
        }
        for(int i=n1;i>=0;i--){
            dp[i][n2]=n1-i;
        }
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+1;
                }
                else{
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+1;
                }
            }
        }
        return dp[0][0];
    }
}
