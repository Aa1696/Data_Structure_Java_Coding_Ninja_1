package Graph;

public class Coonecting_Dots {
    int solve(String[] board , int n, int m)
    {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        boolean [][]visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]){
                    char ch = board[i].charAt(j);
                    boolean ans = helper_func(board, ch, i, j, i, j, visited, n, m,0);
                    //visited=new boolean[n][m];
                    if (ans) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    boolean helper_func(String[] board,char ch,int i,int j,int start,int end,boolean[][]visited,int n,int m,int cnt){
        boolean d1=(i+1<n && !(i+1==start && j==end) && visited[i+1][j] );
        boolean d2=(j+1<m && !(i==start && j+1==end) && visited[i][j+1]);
        boolean d3=(i-1>=0 && !(i-1==start && j==end) && visited[i-1][j] );
        boolean d4=(j-1>=0 && !(i==start && j-1==end) && visited[i][j-1]);
        if(d1||d2||d3||d4){
            return true;
        }
        visited[i][j]=true;
        boolean ans=false;
        char ch1=board[i].charAt(j);
        if(i+1<n && !visited[i][j] && ch1==ch){
            ans=ans||helper_func(board, ch, i+1, j, start, end, visited, n, m,cnt+1);
        }
        if(j+1<m && !visited[i][j] && ch1==ch){
            ans = ans||helper_func(board, ch, i, j+1, start, end, visited, n, m,cnt+1);
        }
        if(i-1>=0 && !visited[i][j] &&ch1==ch){
            ans=ans||helper_func(board, ch, i-1, j, start, end, visited, n, m,cnt+1);
        }
        if(j-1>=0 && !visited[i][j] && ch1==ch){
            ans=ans||helper_func(board, ch, i, j-1, start, end, visited, n, m,cnt+1);
        }
        if(cnt<4){
            return false;
        }
        return ans;
    }
    public static void main(String[] args){
        int n=2;
        int m=2;
        String[]str=new String[n];
        str[0]="AA";
        str[1]="AB";
        Coonecting_Dots cd1=new Coonecting_Dots();
        int ans=cd1.solve(str,n,m);
        if(ans==1){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }

    }
}
