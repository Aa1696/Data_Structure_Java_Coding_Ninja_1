package Graph;
import java.io.IOException;
import java.util.*;
/*
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
2. E is the number of edges present in graph G.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
The following line contain two integers, that denote the value of v1 and v2.
Output Format :
The first and only line of output contains true, if there is a path between v1 and v2 and false otherwise.
Constraints :
0 <= V <= 1000
0 <= E <= 1000
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= V - 1
0 <= v2 <= V - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false
 */

public class HasPAth {
    public static void main(String[] args) throws NumberFormatException, IOException {
        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        if(V==0){
            return;
        }
        int E=sc.nextInt();
        if(E==0){
            System.out.println(false);
            return;
        }
        int [][] mat=new int[V][V];
        for(int i=0;i<E;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            mat[v1][v2]=1;
            mat[v2][v1]=1;
        }
        int new_v1=sc.nextInt();
        int new_v2=sc.nextInt();
        if(new_v1>=V || new_v2>=V){
            System.out.println(false);
            return;
        }
        boolean [] visited=new boolean[V];
        System.out.print(path(mat,new_v1,new_v2,visited));
    }
    public static boolean path(int[][] mat,int v1,int v2,boolean[] visited){
        if(mat[v1][v2]==1){
            return true;
        }

        visited[v1]=true;
        boolean res=false;
        for(int i=0;i<mat.length;i++){
            if(mat[v1][i]==1 && visited[i]==false){
                res=path(mat, i, v2, visited);
            }
            if(res==true){
                return true;
            }
        }
        return false;
    }
}
