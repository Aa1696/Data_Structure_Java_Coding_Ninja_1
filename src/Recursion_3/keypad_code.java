package Recursion_3;

import java.util.Arrays;

public class keypad_code {
    public String[] keypad(int number){
        String[]str={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(number==0){
            String[]str1=new String[1];
            str1[0]="";
            return str1;
        }
        String[]output=keypad(number/10);
        String str1=str[number%10];
        String[]res=new String[output.length*str1.length()];
        int k=0;
        for(int i=0;i< output.length;i++){
            for(int j=0;j<str1.length();j++){
                res[k]=output[i]+str1.charAt(j);
                k++;
            }
        }
        return res;
    }
    public static void main(String[]args){
        int number=123;
        keypad_code kp=new keypad_code();
        String[] ans=kp.keypad(number);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
