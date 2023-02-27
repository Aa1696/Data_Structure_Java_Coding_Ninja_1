package Directed_Graph;

public class Tarjans_algorithm {
    int time=0;
    ArrayList<Integer>ans[];
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        boolean[]visited=new boolean[V];
        int[]low=new int[V];
        Arrays.fill(low,-1);
        int[]disc=new int[V];
        Arrays.fill(disc,-1);
        ans=new ArrayList[V];
        for(int i=0;i<V;i++){
            if(disc[i]==-1){
                dfs(adj,i,low,disc,new Stack<Integer>(),visited);
            }
        }
        ArrayList<ArrayList<Integer>>new_ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(ans[i] !=null){
                new_ans.add(ans[i]);
            }
        }
        return new_ans;

    }
    public void dfs(ArrayList<ArrayList<Integer>>adj,int u,int[]low,int[]disc,Stack<Integer>stck,boolean[]visited){
        visited[u]=true;
        low[u]=disc[u]=++time;
        stck.push(u);
        for(int i=0;i<adj.get(u).size();i++){
            int vrtx=(int)adj.get(u).get(i);
            if(disc[vrtx]==-1){
                dfs(adj,vrtx,low,disc,stck,visited);
                low[u]=(int)Math.min(low[u],low[vrtx]);
            }
            else {
                if(visited[vrtx]){
                    low[u]=(int)Math.min(low[u],disc[vrtx]);
                }

            }
        }
        if(low[u]==disc[u]){
            ArrayList<Integer>ans1=new ArrayList<>();
            while(stck.peek() !=u){
                int curr=(int)stck.pop();
                ans1.add(curr);
                visited[curr]=false;
            }
            int curr=stck.pop();
            visited[curr]=false;
            ans1.add(curr);
            Collections.sort(ans1);
            ans[ans1.get(0)]=ans1;
        }
    }
}
