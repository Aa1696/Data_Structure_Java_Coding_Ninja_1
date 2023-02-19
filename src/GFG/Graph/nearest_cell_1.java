package GFG.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class nearest_cell_1 {
    public int[][] nearest(int[][] grid)
    {
        // Code here

        int n=grid.length;
        int m=grid[0].length;
        int[][]ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    int dis=helper_func(grid,i,j,i,j);
                    ans[i][j]=dis;
                }
                else{
                    ans[i][j]=0;
                }
            }
        }
        return ans;
    }
    public int helper_func(int[][]grid,int i,int j,int start,int end){
        if(grid[i][j]==1){
            int dist1=Math.abs(i-start);
            int dist2=Math.abs(j-end);
            int dist=dist1+dist2;
            return dist;
        }
        int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
        ArrayList<Integer>ans=new ArrayList<>();
        //int ans=Integer.MAX_VALUE;
        for(int l=0;l<4;l++){
            int x=dir[l][0]+i;
            int y=dir[l][1]+j;
            if(x>=0 && x<grid.length && y>=0 && y<grid[i].length ){
                int res=helper_func(grid,x,y,start,end);
                ans.add(res);
            }
        }
        int minm=Integer.MAX_VALUE;
        for(int k=0;k<ans.size();k++){
            minm=Math.min(minm,ans.get(i));
        }
        return minm;
        //return ans;
    }
    public static void main(String[] args){
        int [][]ans={{0,1,1,0},{1,1,0,0}, {0,0,1,1}};
        nearest_cell_1 s1=new nearest_cell_1();
        int[][]arr=s1.nearest(ans);
        for(int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
