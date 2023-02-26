/*
Code: Rat In A Maze
Send Feedback
You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
Input Format
Line 1: Integer N
Next N Lines: Each line will contain ith row elements (separated by space)
Output Format :
The output line contains true if any path exists for the rat to reach its destination otherwise print false.
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
true
Sample Input 2 :
3
1 0 1
1 0 1
0 1 1
Sample Output 2 :
 false
 */
package Bactracking;

public class rat_in_maze {
    public static boolean ratInAMaze(int maze[][]){

        /*Your class should be named Solution.
         *Don't write main().
         *Don't take input, it is passed as function argument.
         *Don't print output.
         *Taking input and printing output is handled automatically.
         */
        int n=maze.length;
        int [][] path=new int[n][n];
        return rat_path(maze,0,0,path,n);
    }
    public static boolean rat_path(int[][] maze,int i,int j,int[][]path,int n){
        //Base Condition
        if(i<0 || i>=n || j<0||j>=n||maze[i][j]==0||path[i][j]==1){
            return false;
        }
        //mark the current grid as visited
        path[i][j]=1;
        //if rat is already at destination
        if(i==n-1&&j==n-1){
            return true;
        }
        //Now Traversing will start in four directions
        //Moving up
        if(rat_path(maze,i-1,j,path,n)){
            return true;
        }
        //Moving right
        if(rat_path(maze,i,j+1,path,n)){
            return true;
        }
        //Moving Down
        if(rat_path(maze,i+1,j,path,n)){
            return true;
        }
        //Moving Left
        if(rat_path(maze, i, j-1, path, n)){
            return true;
        }
        return false;
    }
}
