package Directed_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class articulation_point {
    public static void articulationpoint(ArrayList<ArrayList<Integer>>adj,int V){
        int []discovery_time=new int[V];
        boolean[]visited=new boolean[V];
        int time=1;
        dfs(adj,0,discovery_time,visited,time);
        System.out.println(Arrays.toString(discovery_time));
    }
    public static void dfs(ArrayList<ArrayList<Integer>>adj,int s,int[]discovery_time,boolean[]visited,int time){
        if(visited[s]==true){
            return;
        }
        visited[s]=true;
        discovery_time[s]=time++;
        for(int i=0;i<adj.get(s).size();i++){
            int vrtx=adj.get(s).get(i);
            dfs(adj,vrtx,discovery_time,visited,time);
        }
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E= sc.nextInt();
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(i,new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        articulationpoint(adj,V);
    }
}
