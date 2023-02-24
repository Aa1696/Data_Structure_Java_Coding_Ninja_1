package Directed_Graph;
import java.util.*;
import java.util.ArrayList;
import java.util.Stack;

public class kosaraju_algorithm_strongly_components {
    public static void kosaraju(int V, ArrayList<ArrayList<Integer>>adj){
        Stack<Integer>stck=new Stack<>();
        //do topological sort to get the elements in ordered fashion
        //ordered fashion means if there is the edge between u and v
        //then u should come before v
        boolean[]visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,adj,stck,visited);
            }
        }
        //Transpose the given adjacency graph
        //such that if there is a directed edge between u and v
        //then that edge should be reversed and there should be a edge between v and u
        ArrayList<ArrayList<Integer>>adj1=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj1.add(i,new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int vrtx=adj.get(i).get(j);
                adj1.get(vrtx).add(i);
            }
        }
        //traverse the new adjacency matrix using topological order of original adjacency matrix
        boolean[]new_visited=new boolean[V];
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        while(!stck.isEmpty()){
            int vrtx=stck.pop();
            if(!new_visited[vrtx]){
                ArrayList<Integer>ans1=new ArrayList<>();
                dfs1(vrtx,adj1,ans1,new_visited);
                ans.add(ans1);
            }
        }
        //printing the strongly connected components
        for(int i=0;i<ans.size();i++){
           for(int j=0;j<ans.get(i).size();j++){
               System.out.print(ans.get(i).get(j) + " ");
           }
            System.out.println();
        }
    }
    public static void dfs1(int u,ArrayList<ArrayList<Integer>>adj1,ArrayList<Integer>ans1,boolean[]new_visited){
        new_visited[u]=true;
        for(int i=0;i<adj1.get(u).size();i++){
            int vrtx=adj1.get(u).get(i);
            if(!new_visited[vrtx]){
                dfs1(vrtx,adj1,ans1,new_visited);
            }
        }
        ans1.add(u);
    }
    public static void dfs(int u,ArrayList<ArrayList<Integer>>adj,Stack<Integer>stck,boolean[]visited){
        visited[u]=true;
        for(int i=0;i<adj.get(u).size();i++){
            int vrtx=adj.get(u).get(i);
            if(!visited[vrtx]){
                dfs(vrtx,adj,stck,visited);
            }
        }
        stck.push(u);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(i,new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
        }
        kosaraju(V,adj);
    }

}
