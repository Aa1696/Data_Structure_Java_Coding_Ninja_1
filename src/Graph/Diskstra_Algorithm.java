package Graph;
import java.util.*;
public class Diskstra_Algorithm {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][]graph=new int[v][v];
        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int weight=sc.nextInt();
            graph[v1][v2]=weight;
            graph[v2][v1]=weight;
        }
        int []distance=new int[v];
        int source=0;
        distance[source]=0;
        for(int i=1;i<v;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        boolean visited[]=new boolean[v];
        diskstra_algo(graph,distance,visited);
        for(int i=0;i<v;i++){
            System.out.println(i + " "+distance[i]);
        }
    }
    public static void diskstra_algo(int[][]graph,int[]distance,boolean[]visited){
        int n=distance.length;
        for(int i=0;i<n;i++){
            int minm_verix=find_minm(distance,visited);//to find the minimum weighted unvisited vertex.
            visited[minm_verix]=true;//mark it visited
            for(int j=0;j<n;j++){
                if(!visited[j] && graph[minm_verix][j]>0){
                    int curr_distance=distance[minm_verix]+graph[minm_verix][j];
                    //Need to find the minimum distance from the source to curr_vertex.
                    distance[j]= Math.min(distance[j],curr_distance);
                }
            }
        }
    }
    public static int find_minm(int distance[],boolean visited[]){
        int min_vrtx=-1;
        for(int i=0;i<distance.length;i++){
            if(!visited[i] && ((min_vrtx==-1)||distance[min_vrtx]>distance[i])){
                min_vrtx=i;
            }
        }
        return min_vrtx;
    }

}
