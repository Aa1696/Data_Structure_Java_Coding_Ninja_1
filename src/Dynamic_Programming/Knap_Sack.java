package Dynamic_Programming;

import java.util.ArrayList;

public class Knap_Sack {
    public int knap_sack(int[]val,int []weigth,int W){
        ArrayList<Integer>arr=new ArrayList<>();
        int n=val.length;
        int[][]dp=new int[n+1][W+1];
        for(int i=n-1;i>=0;i--){
            for(int w=0;w<=W;w++){
                int ans;
                if(weigth[i]<=w){
                    int ans1=val[i]+ dp[i+1][W-weigth[i]];
                    int ans2=dp[i+1][w];
                    ans=Math.max(ans1,ans2);
                }
                else{
                    ans=dp[i+1][w];
                }
                dp[i][w]=ans;
            }

        }
        return dp[0][W];
    }
    public static void main(String[] args){
        int[]val={200,300,100};
        int[]weight={20,25,30};
        Knap_Sack kp=new Knap_Sack();
        int W=50;
        int ans=kp.knap_sack(val,weight,W);
        System.out.println("ans:"+ans);
    }
}
