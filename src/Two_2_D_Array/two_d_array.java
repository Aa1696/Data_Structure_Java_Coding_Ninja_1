package Two_2_D_Array;

import java.util.Arrays;

public class two_d_array {
    public static int[][] helper_subset(int []arr,int indx){
        if(indx==arr.length){
            return new int[1][0];
        }
        int[][] output=helper_subset(arr,indx+1);
        int [][] small_output=new int[2*output.length][];
        for(int i=0;i<output.length;i++){
            small_output[i]=new int[output[i].length];
            for(int j=0;j<output[i].length;j++){
                small_output[i][j]=output[i][j];
            }
        }
        for(int i=0;i<output.length;i++){
            small_output[i+output.length]=new int[output[i].length+1];
            small_output[i+output.length][0]=arr[indx];
            //System.out.println(small_output[i+ output.length][0]);
            for(int j=1;j<=output[i].length;j++){
                small_output[i+output.length][j]=output[i][j-1];
                //System.out.println(small_output[i+ output.length][j]);
            }
        }
        return small_output;
    }
    public static void main(String[] args){
        int []arr={1,2,3};
        int [][] ans=helper_subset(arr,0);
        for(int i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
