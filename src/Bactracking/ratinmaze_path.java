package Bactracking;

public class ratinmaze_path {
    static void ratInAMaze(int maze[][], int n) {
        /*
         * Your class should be named Solution.
         * Write your code here
         */
        int[][] path=new int[n][n];
        helper_path(maze,0,0,path,n);

    }
    static void helper_path(int[][]maze,int i,int j,int[][]path,int n){
        if(i==n-1 &&j==n-1){
            path[i][j]=1;
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    System.out.print(path[r][c] + " ");
                }
                //System.out.println();
            }
            System.out.println();
            path[i][j]=0;
            return;
        }
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return;
        }
        //traversing in different direction
        //up
        path[i][j]=1;
        helper_path(maze, i-1, j, path, n);
        //right
        helper_path(maze, i, j+1, path, n);
        //down
        helper_path(maze, i+1, j, path, n);
        //left
        helper_path(maze, i, j-1, path, n);
        path[i][j]=0;
    }
}
