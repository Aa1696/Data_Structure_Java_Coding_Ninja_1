package Directed_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
public class Bridge {
    //given graph matrix
    //graph is undirected
    //find the edges which are bridges
    public static ArrayList<ArrayList<Integer>> edge(int V,ArrayList<ArrayList<Integer>>graph){
        //make discovery time array to get the time at which
        //vertex was visited
        int []disc=new int[V];
        //make low value time array which indicates
        //minimum verices visited in dfs subtree tree generated
        //while doing dfs traversal rooted at v(if there is the edge between u and v)
        int []low=new int[V];
        int []parent=new int[V];
        int time=0;
        boolean[]visited=new boolean[V];
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        Arrays.fill(parent,-1);
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,low,disc,graph,time,visited,parent,ans);
            }
        }
        return ans;
    }
    public static void dfs(int u,int[]low,int[]disc,ArrayList<ArrayList<Integer>>graph,int time,boolean[]visited,int[]parent,ArrayList<ArrayList<Integer>>ans){
        low[u]=disc[u]=++time;
        visited[u]=true;
        for(int i=0;i<graph.get(u).size();i++){
            int vrtx=graph.get(u).get(i);
            if(!visited[vrtx]){
                parent[vrtx]=u;
                dfs(vrtx,low,disc,graph,time,visited,parent,ans);
                low[u]=Math.min(low[u],low[vrtx]);
                if(low[vrtx]>low[u]){
                    ArrayList<Integer>ans1=new ArrayList<>();
                    ans1.add(u);
                    ans1.add(vrtx);
                    ans.add(ans1);
                }
            }
            else if(vrtx != parent[u]){
                low[u]=Math.min(low[u],disc[vrtx]);
            }
        }
    }
    public static void main(String[]strgs){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(i,new ArrayList<Integer>());
        }
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        ArrayList<ArrayList<Integer>>ans=edge(V,graph);
        System.out.println("Bridges in the Graph");
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i).get(0) + " "+ans.get(i).get(1));
        }
    }
    /*
    5 5
    1 0
    0 2
    2 1
    0 3
    3 4
        g1.bridge();
     */

}
