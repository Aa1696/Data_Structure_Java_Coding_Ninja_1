package Recursion_3;
/*
Print Permutations of a String
Send Feedback
Given a string, find and print all the possible permutations of the input string.
Note : The order of permutations are not important. Just print them in different lines.
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba
 */
public class print_permutation_string {
    public static void permutations(String input){
        // Write your code here
        String st="";
        helper(input,st);
    }
    public static void helper(String str,String st){
        if(str.length()==0){
            System.out.println(st);
            return;
        }
        for(int i=0;i<str.length();i++){
            String str1=str.substring(0,i)+str.substring(i+1);
            helper(str1, st+str.charAt(i));
        }

    }
}
