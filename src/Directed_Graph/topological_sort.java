package Directed_Graph;
import java.util.*;

public class topological_sort {
    //using BFS
    public static int[] topological(int V,ArrayList<ArrayList<Integer>>adj){
        Queue<Integer>que=new LinkedList<>();
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int vrtx=adj.get(i).get(j);
                indegree[vrtx]++;
            }
        }
        System.out.println("using bfs"+Arrays.toString(indegree));
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int vrtx=que.poll();
            ans.add(vrtx);
            for(int i=0;i<adj.get(vrtx).size();i++){
                int nw_vrtx=adj.get(vrtx).get(i);
                indegree[nw_vrtx]--;
                if(indegree[nw_vrtx]==0){
                    que.add(nw_vrtx);
                }
            }
        }
        int []ans1=new int[V];
        for(int i=0;i<V;i++){
            ans1[i]=ans.get(i);
        }

        return ans1;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int E=sc.nextInt();
        int V=sc.nextInt();
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>(V);
        for(int i=0;i<V;i++){
            adj.add(i,new ArrayList<Integer>());
        }
        for(int i=0;i<E;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            adj.get(v1).add(v2);
        }
        int[]ans=topological(V,adj);
        int[]ans1=topologicalsort_dfs(V,adj);
        System.out.println("Using BFS");
        System.out.println(Arrays.toString(ans));
        System.out.println("Using DFS");
        System.out.println(Arrays.toString(ans1));
    }
    //Topological sort using DFS;
    static int[] topologicalsort_dfs(int V,ArrayList<ArrayList<Integer>>adj){
        //visit all vertices
        //find it's neighbour
        //if neighbour is not visited
        //iterate over the neighbour
        //if current vertex has no neighbour then that element will be pushed into the stack
        Stack<Integer>stck=new Stack<>();
        boolean[]visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,stck,visited,adj);
            }
        }
        int[]ans=new int[V];
        int indx=0;
        System.out.println("using dfs"+stck);
        while(!stck.isEmpty()){
            int vrtx=stck.pop();
            ans[indx]=vrtx;
            indx++;
        }
        return ans;
    }
    static void dfs(int u,Stack<Integer>stck,boolean[]visited,ArrayList<ArrayList<Integer>>adj){
        visited[u]=true;
        for(int i=0;i<adj.get(u).size();i++){
            int vrtx=adj.get(u).get(i);
            if(!visited[vrtx]){
                dfs(vrtx,stck,visited,adj);
            }
        }
        stck.add(u);

    }
}
/*
5 5
0 1
2 1
2 4
1 4
1 3
 */
