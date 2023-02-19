package Dynamic_Programming;

public class subset_sum {
    //iterative solution of subset sum present in the array
    //Time complexity:O(sum*n)
    //n=length of the array
    static boolean issubsetpresent(int[]arr,int sum){
        int n=arr.length;
        //dp[i][j] will be true if we can create arr subset sum of j from first i elements
        boolean[][]dp=new boolean[n+1][sum];
        //if sum is zero then answer is true
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        //if sum is not zero and set is empty then answer is false
        for(int i=1;i<=sum;i++){
            dp[0][i]=false;
        }
        //fill the dp array in bottom up manner
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j<arr[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        boolean result=dp[n][sum];
        return result;

    }
    //Memoization techniques for solving subset sum problem present in the array
    static boolean is_subset_present_memoization(int []arr,int n,int sum){
        int[][]dp=new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]=-1;
            }
        }
        if(ishelper(arr,n,sum,dp) !=0){
            return true;
        }
        return false;
    }
    static int ishelper(int []arr,int n,int sum,int[][]dp){
        //corner cases and base cases
        if(sum==0){
            return 1;
        }
        if(n<=0){
            return 0;
        }
        if(dp[n-1][sum] !=-1){
            return dp[n-1][sum];
        }
        if(arr[n-1]>sum){
            return dp[n-1][sum]=ishelper(arr,n-1,sum,dp);
        }
        else{
            if(ishelper(arr,n-1,sum,dp)!=0 || ishelper(arr,n-1,sum-arr[n-1],dp)!=0){
                return dp[n-1][sum]=1;
            }
            else{
                return dp[n-1][sum]=0;
            }
        }
    }
}
