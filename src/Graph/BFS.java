package Graph;
import java.io.IOException;
import java.util.*;
public class BFS {
    public static void bfs(int[][]adj_mat,int v,boolean[]visited){
        Queue<Integer>que=new LinkedList<>();
        que.add(v);
        visited[v]=true;
        while(!que.isEmpty()){
            int nw_vertex=que.poll();
            System.out.print(nw_vertex + " ");
            for(int i=0;i<adj_mat.length;i++){
                if(adj_mat[nw_vertex][i]==1 && visited[i]==false){
                    que.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner sc= new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        int[][]mat=new int[V][V];
        for(int i=0;i<E;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            mat[v2][v1]=1;
            mat[v1][v2]=1;
        }
        if (V == 0) {
            return;
        }
        if (E == 0) {
            for (int i = 0; i < V; i++) {
                System.out.print(i + " ");
            }
            return;
        }
        boolean []visited=new boolean[V];
        for(int i=0;i<mat.length;i++){
            if(!visited[i]){
                bfs(mat,i,visited);
            }
        }



    }
}
