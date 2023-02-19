package Dynamic_Programming;

public class maximum_square_matrix_with_all_zeros {
    static int maximum_square_matrix(int[][]input){
        int n=input.length;
        int m=input[0].length;
        int max_val=0;
        if(n==0 || m==0){//if 2d array is empty
            return 0;
        }
        //creating 2d dp array
        int [][]dp=new int [n][m];
        for(int i=0;i<n;i++){
            if(input[i][0]==0){
                dp[i][0]=1;
            }

        }
        for(int i=1;i<m;i++){
            if(input[0][i]==0){
                dp[0][i]=1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(input[i][j]==0){
                    int ans1=dp[i-1][j];
                    int ans2=dp[i-1][j-1];
                    int ans3=dp[i][j-1];
                    dp[i][j]=Math.min(ans1,Math.min(ans2,ans3))+1;
                }
                if(dp[i][j]>max_val){
                    max_val=dp[i][j];
                }
            }
        }
        return max_val;
    }
}
