package Recursion_3;

import java.util.Arrays;

public class String_Subsequence {
    public String[] subsequence(String str){
        if(str.length()==0){
            String [] output=new String[1];
            output[0]="";
            return output;
        }
        String [] output=subsequence(str.substring(1));
        String [] res= new String[2* output.length];
        //first copy the output string array in res string array
        for(int i=0;i< output.length;i++){
            res[i]=output[i];
        }
        //will add 0th index of substring with returned called recursive function to the given caller subsequence function
        for(int i=0;i< output.length;i++){
            //str.charAt(i);
            res[i+ output.length]=str.charAt(0)+output[i];
        }
        return res;
    }
    public static void main(String[] args){
        String_Subsequence sb=new String_Subsequence();
        String [] ans=sb.subsequence("abc");
        System.out.println(Arrays.toString(ans));
    }


}
