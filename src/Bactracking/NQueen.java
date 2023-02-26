/*
You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
Input Format :
Line 1 : Integer N
Output Format :
One Line for every board configuration.
Every line will have N*N board elements printed row wise and are separated by space
Note : Don't print anything if there isn't any valid configuration.
Constraints :
1<=N<=10
Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0
 */
package Bactracking;

public class NQueen {
    public static void placeNQueens(int n){

        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Print output as specified in the question
         */
        int[][]queen=new int[n][n];
        place_queen(queen,0,n);
    }
    public static void place_queen(int [][] queen,int row,int n){
        if(row==n){
            print_array(queen);
            System.out.println();
        }
        for(int col=0;col<n;col++){
            if(is_safe(queen,row,col)){
                queen[row][col]=1;
                place_queen(queen, row+1, n);
                queen[row][col]=0;
            }
        }
    }
    public static boolean is_safe(int[][]board,int row,int column){
        int N=board.length;
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row + 1, j = column + 1; i < N && j < N; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = column + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row + 1, j = column - 1; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][column] == 1) {
                return false;
            }
        }

        for (int i = row + 1; i < N; i++) {
            if (board[i][column] == 1) {
                return false;
            }
        }

        return true;
    }
    public static void print_array(int [][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();
    }
}
