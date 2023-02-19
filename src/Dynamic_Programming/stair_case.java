package Dynamic_Programming;

public class stair_case {
    public long staircase(int n){
        long []dp=new long[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=1;i<dp.length;i++){
                long p2=0,p3=0;
                long p1=dp[i-1];
                if(i-2>=0){
                    p2=dp[i-2];
                }
                if(i-3>=0){
                    p3=dp[i-3];
                }
                dp[i]=p1+p2+p3;
        }
        return dp[n];
    }
    public static void main(String[] args){
        stair_case sc=new stair_case();
        long ans=sc.staircase(6);
        System.out.println(ans);
    }
}
