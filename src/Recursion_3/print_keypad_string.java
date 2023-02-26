package Recursion_3;

/*
Print Keypad Combinations Code
Send Feedback
Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
Note : The order of strings are not important. Just print different strings in new lines.
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
public class print_keypad_string {
    public static void helper(int input,String str){
        String [] key={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(input==0){
            System.out.println(str);
            return;
        }
        int last_digit=input%10;
        int small_input=input/10;
        String st=key[last_digit];
        for(int i=0;i<key[last_digit].length();i++){
            helper(small_input, st.charAt(i)+str);
        }
    }
    public static void printKeypad(int input){
        // Write your code here
        helper(input,"");


    }
}
