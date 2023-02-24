package Directed_Graph;

import java.util.*;

public class cycle_detection {
    public static boolean cycle_detection_using_bfs(int V, ArrayList<ArrayList<Integer>>adj){
        //create indegree array
        int []indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int vrtx=adj.get(i).get(j);
                indegree[vrtx]++;
            }
        }
        //crete que to add those vertex which are hsving 0 indegree;
        Queue<Integer>que=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                que.add(i);
            }
        }
        //maintain the que till it is empty
        //traverse the 0indegree neighbour and reduce it's indgree
        //if neighbour indegree becomes zero then it will added in the que
        //we will also maintain the cnt of the 0 indegree
        //if cnt is equal to V then there is no cycle as program has traversed each vertex
        int cnt=0;
        while(!que.isEmpty()){
            int vrtx=que.poll();
            cnt++;
            for(int i=0;i<adj.get(vrtx).size();i++){
                int new_vrtx=adj.get(vrtx).get(i);
                indegree[new_vrtx]--;
                if(indegree[new_vrtx]==0){
                    que.add(new_vrtx);
                }
            }
        }
        return (cnt !=V);

    }
    public static boolean cycle_detection_using_dfs(int V,ArrayList<ArrayList<Integer>>adj){
        //purpose is to search at each vertex whether it will cause
        //for cycle detection
        //we will main two boolean array
        //first one visited will map the visited vertex
        //second one ,need to think for now
        Stack<Integer>stck=new Stack<>();
        boolean[]visited=new boolean[V];
        boolean[]stck_arr=new boolean[V];
        for(int i=0;i<V;i++){
            if(dfs(i,adj,visited,stck_arr)){
                return true;
            }
        }
        return false;
    }
    public static boolean dfs(int s,ArrayList<ArrayList<Integer>>adj,boolean[]visited,boolean[] stck_arr){
        visited[s]=true;
        stck_arr[s]=true;
        for(int i=0;i<adj.get(s).size();i++){
            if(!visited[adj.get(s).get(i)] && dfs(adj.get(s).get(i),adj,visited,stck_arr)){
                return true;
            }
            else if(stck_arr[adj.get(s).get(i)]==true){
                return true;
            }
        }
        stck_arr[s]=false;
        return false;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>(V);
        for(int i=0;i<V;i++){
            adj.add(i,new ArrayList<Integer>());
        }
        for(int i=0;i<E;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            adj.get(v1).add(v2);
        }
        boolean ans=cycle_detection_using_bfs(V,adj);
        boolean ans1=cycle_detection_using_dfs(V,adj);
        System.out.println("Using BFS");
        System.out.println(ans);
        System.out.println("Using DFS");
        System.out.println(ans1);
    }
}
