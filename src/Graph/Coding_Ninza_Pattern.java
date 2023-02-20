package Graph;
import java.util.*;
public class Coding_Ninza_Pattern {
    int solve(String[] Graph , int N, int M)
    {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        String str="CODINGNINJA";
        boolean [][]visited=new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(Graph[i].charAt(j)=='C'){
                    char ch=str.charAt(0);
                    boolean ans=helper_func(Graph,i,j,visited,str.substring(1));
                    if(ans){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    static boolean helper_func(String[]Graph,int i,int j,boolean[][]visited,String str){
        if(str.isEmpty()){
            visited[i][j]=true;
            return true;
        }
        if(!visited[i][j]){
            visited[i][j] = true;
        }

        char ch1=str.charAt(0);
        int[][]dir={{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
        for(int l=0;l<dir.length;l++){
            int x=dir[l][0]+i;
            int y=dir[l][1]+j;
            if(x>=0 && x<Graph.length&&y>=0&&y<Graph[x].length()&&!visited[x][y]&&Graph[x].charAt(y)==ch1){
                boolean ans=helper_func(Graph, x, y, visited, str.substring(1));
                if(ans){
                    return true;
                }
            }
        }
        visited[i][j]=false;
        return false;
    }
}
