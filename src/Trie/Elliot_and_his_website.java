package Trie;
import java.util.*;
class trie_node {
    public char data;
    public boolean isterminal;
    public int lastnumber;
    trie_node[]children;
    trie_node(char data){
        this.data=data;
        this.isterminal=false;
        this.lastnumber=0;
        this.children=new trie_node[36];
    }

}
public class Elliot_and_his_website {
    private static trie_node root;
    Elliot_and_his_website(){
        this.root=new trie_node('\0');
    }
    public static boolean find(trie_node root,String str,int indx){
        if(indx==str.length()){
            if(root.isterminal){
                return true;
            }
            return false;
        }
        int char_index=26+str.charAt(0)-'0';
        if(root.children[char_index]!=null){
            return find(root.children[char_index],str,indx+1 );
        }
        return false;

    }
    public static int addInteger(trie_node root){
        int res=0;
        for(int i=root.lastnumber;i<=20005;i++){
            String chk=String.valueOf(i);
            if(!find(root,chk,0)){
                root.lastnumber=i;
                res=i;
                break;
            }
        }
        return res;
    }
    public static int add(trie_node root, String str,int indx){
        if(indx==str.length()){
            return -1;
        }
        int char_index=str.charAt(indx)<=9?26+str.charAt(indx)-'0':str.charAt(indx)-'a';
        trie_node nd=new trie_node(str.charAt(0));
        if(root.children[char_index]==null){
            root.children[char_index]=nd;
            if(indx==str.length()-1){
                nd.isterminal=true;
                return -1;
            }
            else{
                return add(nd,str,indx+1);
            }
        }
        else{
            if(indx==str.length()-1){
                if(root.children[char_index].isterminal){
                    int k=addInteger(root.children[char_index]);
                    String st=String.valueOf(k);
                    add(root.children[char_index],st,0);
                    return k;
                }
                else{
                    root.children[char_index].isterminal=true;
                    return -1;
                }
            }
            else{
                return add(root.children[char_index],str,indx+1 );
            }
        }
        //add(nd,str,indx+1);

    }
    public static ArrayList<String> getusernames(ArrayList<String>username,int n){
        ArrayList<String>ans=new ArrayList<>();
        for(String s:username){
            if(!find(root,s,0)){
                int num=add(root,s,0);
                if(num==-1){
                    ans.add(s);
                }
                else{
                    ans.add(s+num);
                }
            }

        }
        return ans;
    }
}
