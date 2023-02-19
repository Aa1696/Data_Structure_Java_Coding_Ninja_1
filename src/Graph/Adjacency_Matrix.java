package Graph;
import java.util.*;
public class Adjacency_Matrix {
    public static void helper_bfs(int[][] adj_mat,int vertex,boolean[] visited){
        Queue<Integer>que=new LinkedList<>();
        que.add(vertex);
        visited[vertex]=true;
        while(!que.isEmpty()){
            int nw_vertex=que.poll();
            System.out.print(nw_vertex + " ");
            for(int i=0;i< adj_mat.length;i++) {
                if (adj_mat[nw_vertex][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }

    }
    public static void bfs(int[][]adj_mat){
        boolean []visited=new boolean[adj_mat.length];
        for(int i=0;i< adj_mat.length;i++){
            if(!visited[i]){
                helper_bfs(adj_mat,i,visited);
            }
        }

    }
    public static void helper_dfs(int[][]adj_mat,int vertex,boolean []visited){
        System.out.print(vertex +" ");
        visited[vertex]=true;
        for(int i=0;i<adj_mat.length;i++){
            if(adj_mat[vertex][i]==1 && visited[i]==false){
                helper_dfs(adj_mat,i,visited);
            }
        }
    }
    public static void dfs(int[][] adj_mat){
        boolean []visited=new boolean[adj_mat.length];
        for(int i=0;i< adj_mat.length;i++){
            if(!visited[i]){
                helper_dfs(adj_mat,i,visited);
            }
        }

    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        int [][]mat=new int[n][n];
        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            mat[v1][v2]=1;
            mat[v2][v1]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Print BFS");
        bfs(mat);
        System.out.println();
        System.out.println("Print DFS");
        dfs(mat);


    }
}
