package Trie;
/*
Pattern Matching
Send Feedback
Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not. Return true if the pattern is present and false otherwise.
Input Format :
The first line of input contains an integer, that denotes the value of n.
The following line contains n space-separated words.
The following line contains a string, that denotes the value of the pattern p.
Output Format :
The first and only line of output contains true if the pattern is present and false otherwise.
Constraints:
Time Limit: 1 sec
Sample Input 1 :
4
abc def ghi cba
de
Sample Output 2 :
true
Sample Input 2 :
4
abc def ghi hg
hi
Sample Output 2 :
true
Sample Input 3 :
4
abc def ghi hg
hif
Sample Output 3 :
false
 */
import java.util.*;
class pattern_TrieNode{

    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public pattern_TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}
public class Pattern_Matching {
    private TrieNode root;
    public int count;
    public Pattern_Matching() {
        root = new TrieNode('\0');
    }

    public boolean search(String word){
        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if(word.length() == 0){
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return false;
        }
        return search(child, word.substring(1));
    }
    private  void  helperadd(TrieNode root,String word){
        if(word.length()==0){
            root.isTerminating=true;
            return ;
        }
        int child_indx=word.charAt(0)-'a';
        TrieNode child = root.children[child_indx];
        if(child ==null){
            child=new TrieNode(word.charAt(0));
            root.children[child_indx]=child;
            root.childCount++;
        }
        helperadd(child,word.substring(1));

    }
    public void add(String word){
        helperadd(root,word);

    }


    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        // Write your code here
        //1st approach
        //will make add function where all string of the vector will be added
        //2nd approach
        //will put the string of arraylist iteratively in trie and correspondingly will check given word is available or not
        //Made the suffix trie of each string int the arraylist
        for(int i=0;i<vect.size();i++){
            String word=vect.get(i);
            for(int j=0;j<word.length();j++){
                add(word.substring(j));
            }
        }

        return search(pattern);

    }
}
