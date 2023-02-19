package Trie;

class Trie_Node{
    char data;
    boolean terminal;
    Trie_Node children[];
    int child_count=0;
    Trie_Node(char data){
        this.data=data;
        this.terminal=false;
        this.children=new Trie_Node[26];
        this.child_count=0;
    }
}
public class Trie {
    private Trie_Node root;
    private  int num_of_word;
    Trie(){
        root=new Trie_Node('\0');
        int num_of_word=0;
    }
    private boolean helper_add(Trie_Node root,String word){
        if(word.length()==0) {
            if (!root.terminal){
                root.terminal = true;
                return true;
            }
            else{
                return false;
            }

        }
        int char_index=word.charAt(0)-'a';
        Trie_Node child= new Trie_Node(word.charAt(0));
        if(root.children[char_index]==null){
            root.children[char_index]=child;
            root.child_count++;
        }
        return helper_add(child,word.substring(1,word.length()));
    }
//    boolean helper_suffix(Trie_Node root,String word){
//
//    }
    public void add(String word){
        if(helper_add(root,word)){
            this.num_of_word++;
        }
        for(int i=0;i<word.length();i++){
            if(helper_add(root,word.substring(i))){
                this.num_of_word++;
            }
        }

    }
    private boolean helper_search(Trie_Node root,String word){
        if(word.length()==0){
            return root.terminal;
        }
        int indx=word.charAt(0)-'a';
        Trie_Node child=root.children[indx];
        if(child==null){
            return false;
        }
        return helper_search(child,word.substring(1));
    }
    public boolean search(String word){
        return helper_search(root,word);

    }
    private boolean helper_pattern_add(Trie_Node root,String word){
        if(word.length()==0){
            if(!root.terminal){
                root.terminal=true;
                return true;
            }
            else{
                return false;
            }

        }
        int child_index=word.charAt(0)-'a';
        Trie_Node child=root.children[child_index];
        if(child==null){
            child= new Trie_Node(word.charAt(0));
            root.children[child_index]=child;
            root.child_count++;
        }
        return helper_pattern_add(child,word.substring(1));
    }
    public void pattern_add(String pattern){
        if(helper_pattern_add(root,pattern)){
            this.num_of_word++;
        }
    }
    private boolean helper_search_pattern(Trie_Node root,String word){
        if(word.length()==0){
            return true;
        }
        int child_indx=word.charAt(0)-'a';
        Trie_Node child=root.children[child_indx];
        if(child==null){
            return false;
        }
        return helper_search(child,word.substring(1));
    }
    public boolean search_pattern(String word){
        return helper_search_pattern(root,word);
    }
    public boolean remove_helper(Trie_Node root,String word){
        if(word.length()==0) {
            if (root.terminal){
                root.terminal = false;
                return true;
            }
            return false;
        }
        int child_index=word.charAt(0)-'a';
        Trie_Node child_node=root.children[child_index];
        if(child_node==null){
            return false;
        }
        boolean ans=remove_helper(child_node,word.substring(1));
        if(!child_node.terminal && root.child_count==0){
            root.children[child_index]=null;
            child_node=null;
            root.child_count--;
        }
        return ans;
    }
    public void remove(String word){
            if(remove_helper(root,word)){
                this.num_of_word--;
            }

    }
    public int get_num_of_words(){
        return num_of_word;
    }
    private void helper_print(Trie_Node root,String word){
        if(root==null){
            return;
        }
        if(root.terminal){
            System.out.println(word);
        }
        for(Trie_Node nd:root.children){
            if(nd==null){
                continue;
            }
            String req_string=word + nd.data;
            helper_print(nd,req_string);
        }
    }
    public void print(){
        helper_print(this.root,"");
    }
}
