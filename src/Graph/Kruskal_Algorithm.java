package Graph;
import java.util.*;
public class Kruskal_Algorithm {
    public static Edge[] kruskalalgorithm(Edge[]edges,int n){
        //sorting the array with edge objects because
        //we are making minimum spanning tree ,so, minimum edges will be taken in consideration
        //unless it is not interesting,it means that, it is not causing for cycle formation.
        Arrays.sort(edges);
        Edge[]mst=new Edge[n-1];//all feasible edges or interesting edges will be stored in mst edge object array container
        int []parent=new int[n];//index will be the vertex and element at the given index will be its parent.
        for(int j=0;j<n;j++){
            parent[j]=j;//initially all vertex will be its parent.
        }
        //purpose for count is to traverse all edges in the and find its feasibility
        //i is for traversing the edge object array container.
        int count=0,i=0;
        while(count !=n-1){
            Edge currentedge=edges[i++];
            int v1parent=findparent(currentedge.v1,parent);
            int v2parent=findparent(currentedge.v2,parent);
            if(v1parent != v2parent){
                mst[count]=currentedge;
                count++;
            }
        }
        return mst;
    }
    public static int findparent(int v,int []parent){
        //So initially all vertices are parent of itself
        //when we reach a vertex which is itself the parent

        //vertex is starting from 0 and when it is stored in array
        //then for total number of vertex say it v
        //then we will make the array with size of v
        //since vertices will be from 0 to v-1;
        //so the array container will be the best choice

        //Base case is when vertex is itself the parent
        if(v==parent[v]){
            return v;
        }
        //else we will go to find the vertex parent
        return findparent(parent[v],parent);
    }
    public static void main(String[] args){
        //purpose is to create the minimum spanning tree from the weighted adirected graph
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//Taking the number of vertices as a input from user
        int e=sc.nextInt();//Taking input of number of edges from user
        //purpose of creating the containers of object called edge
        //instead of adjacency matrix is that we need to deal with the edge
        //vertices and to find its parent ,so we are not dealing with connection of vertices
        //but instead of it we are dealing vertices parent
        Edge[] edges=new Edge[e];
        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int weight=sc.nextInt();
            Edge edge=new Edge(v1,v2,weight);
            edges[i]=edge;
        }
        //We need to print the vertices
        //and along with it's, weight in one line
        //of the edges which are feasible for making minimum spanning tree
        //minimum vertex will first print and then greater vertex.
        Edge[] mst=kruskalalgorithm(edges,n);
        for(int i=0;i< mst.length;i++){
            if(mst[i].v1<mst[i].v2){
                System.out.println(mst[i].v1 + " "+mst[i].v2 + " "+mst[i].weight);
            }
            else{
                System.out.println(mst[i].v2 + " "+mst[i].v1 + " "+mst[i].weight);
            }
        }
    }
}
