public class Union_Find_Algorithm {
    int V,E;//number of vertices
    Edge[]edge;
    class Edge{
        int src,dest;
    };
    Union_Find_Algorithm(int v,int e){
        this.V=v;
        this.E=e;
        for(int i=0;i<E;i++){
            edge[i]=new Edge();
        }
    }
    public int find(int[]parent,int u){
        if(parent[u]==u){
            return u;
        }
        return find(parent,parent[u]);
    }
    void union(int[] parent,int u,int v){
        parent[u]=v;
    }
    int iscycle(Union_Find_Algorithm graph){
        int []parent=new int[graph.V];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
        for(int i=0;i<graph.E;i++){
            int p1= graph.find(parent,graph.edge[i].src);
            int p2= graph.find(parent,graph.edge[i].dest);
            if(p1==p2){
                return 1;
            }
            graph.union(parent,graph.edge[i].src,graph.edge[i].dest);
        }
        return 0;
    }
}
