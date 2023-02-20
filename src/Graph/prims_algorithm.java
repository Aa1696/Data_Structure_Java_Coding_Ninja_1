package Graph;
import java.util.*;
public class prims_algorithm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();

        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        int [][]graph=new int[V][V];
        for(int i=0;i<E;i++){
            int v1=s.nextInt();
            int v2=s.nextInt();
            int weight=s.nextInt();
            graph[v1][v2]=weight;
            graph[v2][v1]=weight;
        }
        boolean[] visited=new boolean[V];
        int []parent=new int[V];
        int [] weight=new int[V];
        int source=0;
        parent[source]=-1;
        weight[source]=0;
        for(int i=1;i<V;i++){
            weight[i]=Integer.MAX_VALUE;
        }

        prims_algorithm(graph,parent,weight,source,visited,V);
        for(int i=1;i<V;i++){
            if(i<parent[i]){
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
            else{
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }

        }
    }
    public static void prims_algorithm(int[][]graph,int[]parent,int[]weight,int source,boolean[]visited,int v){
        //visited[source]=true;
        for(int i=0;i<v;i++){
            //find minimum weighted unvisited vertex using visited and parent array.
            int v1=findminm(weight,visited);
            visited[v1]=true;
            for(int j=0;j<v;j++){
                if(graph[v1][j]>0 && !visited[j]){
                    if(weight[j]>graph[v1][j]){
                        weight[j]=graph[v1][j];
                        parent[j]=v1;
                    }
                }
            }
        }

    }
    public static int findminm(int[] weight,boolean[]visited){
        int min_vertix=-1;
        for(int i=0;i<visited.length;i++){
            if(!visited[i] && (min_vertix ==-1 ||weight[min_vertix]>weight[i] )){
                min_vertix=i;
            }
        }
        return min_vertix;
    }
}
