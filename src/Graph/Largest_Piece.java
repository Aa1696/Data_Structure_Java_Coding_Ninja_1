package Graph;
/*
It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
Input Format :
The first line of input contains an integer, that denotes the value of N.
Each of the following N lines contain N space separated integers.
Output Format :
Print the count of '1's in the biggest piece of '1's, according to the description in the task.
Constraints :
1 <= N <= 1000
Time Limit: 1 sec
Sample Input 1:
2
1 1
0 1
Sample Output 1:
3
 */
public class Largest_Piece {
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int dfs(String[] edge, int n) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        boolean [][]visited=new boolean[n][];
        for(int i=0;i<n;i++){
            int m=edge[i].length();
            visited[i]=new boolean[m];
        }
        int glob_ans=0;
        for(int i=0;i<n;i++){
            int m=edge[i].length();
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    if(edge[i].charAt(j)=='1'){
                        int ans=helper_func(edge,i,j,visited);
                        glob_ans=Math.max(ans,glob_ans);
                    }
                }
            }
        }
        return glob_ans;
    }
    public static int helper_func(String[] edge,int cord1,int cord2 ,boolean[][]visited){
        if(visited[cord1][cord2]){
            return 0;
        }
        if(!visited[cord1][cord2]){
            visited[cord1][cord2] = true;
        }
        int cnt=1;
        for(int i=0;i<dir.length;i++){
            int x=dir[i][0]+cord1;
            int y=dir[i][1]+cord2;
            if(x>=0 && x<edge.length&&y>=0&&y<edge[0].length()&&edge[x].charAt(y)=='1' && !visited[x][y]){
                cnt +=helper_func(edge, x, y,visited);
            }
        }
        return cnt;
    }
}
