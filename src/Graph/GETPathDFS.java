package Graph;
import java.util.*;
import java.io.*;
public class GETPathDFS {
    public static void main(String[] args) throws NumberFormatException, IOException {

        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        if(V==0){
            return;
        }
        int E=sc.nextInt();
        if(E==0){
            System.out.println();
            return;
        }
        int[][]mat=new int[V][V];
        for(int i=0;i<E;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            mat[v1][v2]=1;
            mat[v2][v1]=1;
        }
        int source=sc.nextInt();
        int destination=sc.nextInt();
        if(source>=V || destination>=V){
            return;
        }
        boolean []visited=new boolean[V];
        ArrayList<Integer>arr=dfs(mat,source,destination,visited);
        if(arr !=null){
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }


    }
    public static ArrayList<Integer> dfs(int[][]adj_mat,int s,int e,boolean[]visited){
        visited[s]=true;
        if(s==e){
            ArrayList<Integer>ans=new ArrayList<>();
            ans.add(s);
            return ans;
        }
        visited[s]=true;
        //boolean res=false;
        for(int i=0;i<adj_mat.length;i++){
            if(adj_mat[s][i]==1 && !visited[i]){
                ArrayList<Integer> ans=dfs(adj_mat, i, e, visited);
                if(ans !=null){
                    ans.add(s);
                    return ans;
                }

            }
        }
        //ArrayList<Integer>ans=new ArrayList<>();
        return null;
    }
}
