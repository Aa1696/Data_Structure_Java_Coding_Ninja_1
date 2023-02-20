package Graph;
import java.util.*;
public class Connecting_Dots {
    int solve(String[] board , int n, int m)
    {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        boolean [][]visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    if(helper_func(board,i,j,-1,-1,visited)==1){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    static int helper_func(String[] board,int start,int end,int i,int j,boolean[][]visited){
        if(visited[start][end]==true){
            return 1;
        }
        int [] X_dir={1,0,0,-1};
        int []Y_dir={0,1,-1,0};
        if(!visited[start][end]){
            visited[start][end] = true;
        }

        for(int l=0;l<4;l++){
            int x=X_dir[l]+start;
            int y=Y_dir[l]+end;
            if(x==i && y==j){
                continue;
            }
            if(x>=0 && y>=0 && x<board.length && y<board[x].length() && board[x].charAt(y)==board[start].charAt(end)){
                int ans=helper_func(board, x, y, start, end, visited);
                if(ans==1){
                    return 1;
                }
            }
        }
        return 0;
    }
}
