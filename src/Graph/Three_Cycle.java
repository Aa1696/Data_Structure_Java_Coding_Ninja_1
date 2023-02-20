package Graph;
/*
Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges, then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.
Input Format :
The first line of input contains two space separated integers, that denotes the value of N and M.
Each of the following M lines contain two integers, that denote the vertices which have an undirected edge between them. Let us denote the two vertices with the symbol u and v.
Output Format :
Print the count the number of 3-cycles in the given graph
Constraints :
0 <= N <= 100
0 <= M <= (N*(N-1))/2
0 <= u <= N - 1
0 <= v <= N - 1
Time Limit: 1 sec
Sample Input 1:
3 3
0 1
1 2
2 0
Sample Output 1:
1
 */
import java.util.*;
import java.io.*;
public class Three_Cycle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int solve(boolean[][] graph, int n) {
        /*
         * Your class should be named Solution
         * You may write your code here
         */

        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]==true){
                    for(int k=0;k<n;k++){
                        if(k !=i && graph[k][j]==true && graph[i][k]==true){
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt/6;
        // boolean[] visited=new boolean[n];
        //  for(int i=0;i<graph.length;i++){

        // 	 if(!visited[i]){
        // 		int count_0 = 0;
        // 		int ans=dfs(graph,i,i,visited,count_0);
        // 		if(ans==3){
        // 			cnt++;
        // 		}
        // 	 }

        // }
        // return cnt;

    }
    public static int dfs(boolean[][]graph,int s,int e,boolean[]visited,int cnt){
        if(cnt>3){
            return 0;
        }
        if(s==e && cnt==3){
            return cnt;
        }
        if(s !=e){
            visited[s]=true;
        }
        for(int i=0;i<graph.length;i++){
            if(graph[s][i]==true && !visited[i]){
                //int ans=cnt;
                if(dfs(graph,i,e,visited,cnt+1)==3){
                    visited[i]=false;
                    return cnt;
                }
                visited[i]=false;
            }
        }
        return 0;
    }

    public static boolean[][] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int m = Integer.parseInt(strNums[1]);

        boolean[][] graphs = new boolean[n][n];
        int firstvertex, secondvertex;

        for (int i = 0; i < m; i++) {
            String[] strNums1;
            strNums1 = br.readLine().split("\\s");
            firstvertex = Integer.parseInt(strNums1[0]);
            secondvertex = Integer.parseInt(strNums1[1]);
            graphs[firstvertex][secondvertex] = true;
            graphs[secondvertex][firstvertex] = true;
        }
        return graphs;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        boolean[][] graphs = takeInput();

        int ans = solve(graphs, graphs.length);
        System.out.println(ans);

    }
}
