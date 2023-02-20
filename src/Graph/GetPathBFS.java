package Graph;
import java.util.*;
import java.io.*;
public class GetPathBFS {
    public static void main(String[] args) throws NumberFormatException, IOException {
        /*
         * Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        if (V == 0 || E == 0) {
            return;
        }
        int[][] adj_matrix = new int[V][V];
        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adj_matrix[v1][v2] = 1;
            adj_matrix[v2][v1] = 1;
        }
        int source = sc.nextInt();
        int destination = sc.nextInt();
        boolean[] visited = new boolean[V];
        // HashMap<Integer,Integer>map=new HashMap<>();
        //

        HashMap<Integer, Integer> ans = bfs(adj_matrix, source, destination, visited);
        if (ans.containsKey(destination)) {
            int key = destination;
            while (key != -1) {
                System.out.print(key + " ");
                key = ans.get(key);
            }
        }

    }

    public static HashMap<Integer, Integer> bfs(int[][] adj_matrix, int s, int e, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        HashMap<Integer, Integer> ans = new HashMap<>();
        ans.put(s, -1);
        que.add(s);
        visited[s] = true;
        while (!que.isEmpty()) {
            int curr_vertex = que.poll();
            for (int i = 0; i < adj_matrix.length; i++) {
                if (!visited[i] && adj_matrix[curr_vertex][i] == 1) {
                    que.add(i);
                    visited[i] = true;
                    ans.put(i, curr_vertex);
                    if (i == e) {
                        return ans;
                    }
                }
            }

        }

        return ans;

    }
}
