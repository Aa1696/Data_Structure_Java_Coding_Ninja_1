package Graph;

public class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;
    Edge(int v1,int v2,int weight){
        this.v1=v1;
        this.v2=v2;
        this.weight=weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
    /*
    6 11
    0 1 1
    0 2 5
    1 3 3
    1 2 6
    0 3 4
    2 3 10
    2 4 8
    2 5 9
    3 5 6
    3 4 7
    4 5 2

     */
}
