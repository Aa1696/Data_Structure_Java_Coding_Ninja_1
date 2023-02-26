/*
Return Keypad Code
Send Feedback
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note : 1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf
 */
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
