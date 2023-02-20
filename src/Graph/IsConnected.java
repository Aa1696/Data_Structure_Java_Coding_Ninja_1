package Graph;
import java.util.*;
import java.io.*;
public class IsConnected {
    public static void main(String[] args) throws NumberFormatException, IOException {

        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        if(V==0){
            System.out.println(true);
            return;
        }
        // if(E==0||V==0){
        // 	return;
        // }
        int[][] adj_mat=new int[V][V];
        boolean []visited=new boolean[V];
        for(int i=0;i<E;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            adj_mat[v1][v2]=1;
            adj_mat[v2][v1]=1;
        }
        dfs(adj_mat,0,visited);
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);


    }
    public static void dfs(int[][]adj_mat,int s,boolean []visited){
        visited[s]=true;
        for(int i=0;i<adj_mat.length;i++){
            if(!visited[i] && adj_mat[s][i]==1){
                dfs(adj_mat, i, visited);
            }
        }
    }
}
