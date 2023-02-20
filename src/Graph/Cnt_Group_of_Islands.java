package Graph;
import java.util.*;
public class Cnt_Group_of_Islands {
    public static int numConnected(int[][] edges, int n) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(n==0){
            return 0;
        }
        int [][]adj_mat=new int[n][n];
        boolean []visited=new boolean[n];
        // for(int i=0;i<E;i++){
        // 	int v1=sc.nextInt();
        // 	int v2=sc.nextInt();
        // 	adj_mat[v1][v2]=1;
        // 	adj_mat[v2][v1]=1;
        // }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                cnt++;
                bfs(edges,i,visited);
            }
        }
        return cnt;
    }
    public static void bfs(int[][]adj_mat,int s,boolean[] visited){
        Queue<Integer>que=new LinkedList<>();
        que.add(s);
        visited[s]=true;
        while(!que.isEmpty()){
            int curr_vertex=que.poll();
            for(int i=0;i<adj_mat.length;i++){
                if(!visited[i] && adj_mat[curr_vertex][i]==1){
                    visited[i]=true;
                    que.add(i);
                }
            }
        }

    }
}
