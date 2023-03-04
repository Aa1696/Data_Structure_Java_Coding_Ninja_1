package Trie;
/*
Auto complete
Send Feedback
Given n number of words and an incomplete word w. You need to auto-complete that word w.
That means, find and print all the possible words which can be formed using the incomplete word w.
Note : Order of words does not matter.
Input Format :
The first line of input contains an integer, that denotes the value of n.
The following line contains n space separated words.
The following line contains the word w, that has to be auto-completed.
Output Format :
Print all possible words in separate lines.
Constraints:
Time Limit: 1 sec
Sample Input 1 :
7
do dont no not note notes den
no
Sample Output 2 :
no
not
note
notes
Sample Input 2 :
7
do dont no not note notes den
de
Sample Output 2 :
den
Sample Input 3 :
7
do dont no not note notes den
nom
Sample Output 3 :
(Empty) There is no word which starts with "nom"
 */
import java.util.*;
class AutoTrieNode{
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public AutoTrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}
public class Auto_complete {
    private TrieNode root;
    public int count;
    public Auto_complete() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word){
        add(root, word);
    }
    private TrieNode helper_pattern(TrieNode root,String word){
        if(word.length()==0){
            return root;
        }
        int child_indx=word.charAt(0)-'a';
        TrieNode child=root.children[child_indx];
        if(child==null){
            return null;
        }
        return helper_pattern(child, word.substring(1));

    }
    public TrieNode pattern(String word){
        return helper_pattern(root,word);
    }
    public void printallwords(TrieNode root,String word,String output){
        if(root.childCount==0){
            if(output.length()>0){
                System.out.println(word+output);
            }
            return;
        }
        if(root.isTerminating){
            System.out.println(word+output);
        }
        for(TrieNode nd:root.children){
            if(nd !=null){
                String ans =output+nd.data;
                printallwords(nd,word,ans);
            }
        }
    }
    public void autoComplete(ArrayList<String> input, String word) {
        // Write your code here
        for(int i=0;i<input.size();i++){
            add(root,input.get(i));
        }
        TrieNode child=pattern(word);
        if(child==null){
            System.out.println("");
        }
        else{
            String result="";
            printallwords(child,word,result);
        }
    }
}
