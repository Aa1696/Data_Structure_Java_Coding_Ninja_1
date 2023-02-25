package Directed_Graph;

import java.util.*;

public class number_of_paths_between_source_destination {
    public static void printpaths(int V, ArrayList<ArrayList<Integer>>adj,int source,int dest){
        //boolean[]visited=new boolean[V];
        //int ans=0;
        boolean[]visited=new boolean[V];
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(source);
        dfs(source,dest,adj,ans,visited);
    }
    public static void dfs(int source, int dest, ArrayList<ArrayList<Integer>>adj, ArrayList<Integer> ans, boolean[]visited){
        if(source==dest){
            System.out.println(ans);
            return;
        }
        visited[source]=true;
//        boolean ans=false;
        for(int i=0;i<adj.get(source).size();i++){
            int vrtx=adj.get(source).get(i);
            if(!visited[vrtx]){
                ans.add(vrtx);
                dfs(vrtx, dest,adj,ans,visited);
                ans.remove(vrtx);
            }
        }
        visited[source]=false;
    }
    public static int count_path_by_dfs(int V,ArrayList<ArrayList<Integer>>adj,int source,int destination){

        int cnt=dfs(adj,source,destination);
        return cnt;
    }
    public static int dfs(ArrayList<ArrayList<Integer>>adj,int s,int d){
        if(s==d){
            return 1;
        }
        int ans=0;
        for(int i=0;i<adj.get(s).size();i++){
            int vrtx=adj.get(s).get(i);
            ans +=dfs(adj,vrtx,d);
        }
        return ans;
    }
    public static int cnt_path_by_bfs(int V,ArrayList<ArrayList<Integer>>adj,int s,int d){
        Queue<Integer>que=new LinkedList<>();
        que.add(s);
        int cnt=0;
        if(s==d){
            cnt++;
        }
        while(!que.isEmpty()){
            int node=que.poll();
            for(int i=0;i<adj.get(node).size();i++){
                int vrtx=adj.get(node).get(i);
                if(vrtx==d){
                    cnt++;
                }
                else if(vrtx !=d){
                    que.add(vrtx);
                }
            }
        }
        return cnt;
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
        int s= sc.nextInt();
        int d=sc.nextInt();
        //printpaths(V,adj,s,d);
        System.out.println("count the number of paths between source and destination");
        //System.out.println(count_path_by_dfs(V,adj,s,d));
        System.out.println(cnt_path_by_bfs(V,adj,s,d));
    }
}
