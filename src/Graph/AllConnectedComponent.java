package Graph;
import java.util.*;
import java.io.*;
public class AllConnectedComponent {
    public static void main(String[] args) throws NumberFormatException, IOException {

        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        if(V==0){
            return;
        }
        int[][]adj_mat=new int[V][V];
        boolean[]visited=new boolean[V];
        for(int i=0;i<E;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            adj_mat[v1][v2]=1;
            adj_mat[v2][v1]=1;
        }
        //  if(E==0){
        // 	 for(int i=0;i<V;i++){
        // 		 System.out.println(i);
        // 	}
        // 	 return;
        //  }
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                ArrayList<Integer> ans=new ArrayList<>();
                dfs(adj_mat,i,visited,ans);
                Collections.sort(ans);
                arr.add(ans);
            }
        }
        for(int i=0;i<arr.size();i++){
            for(Integer k:arr.get(i)){
                System.out.print(k + " ");
            }
            System.out.println();
        }


    }
    public static void dfs(int[][] adj_mat,int s,boolean[]visited,ArrayList<Integer>ans){
        visited[s]=true;
        ans.add(s);
        for(int i=0;i<adj_mat.length;i++){
            if(adj_mat[s][i]==1 && !visited[i]){
                //ans.add(i);
                dfs(adj_mat, i, visited, ans);
            }

        }
        //return ans;
    }
}
