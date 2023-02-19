package Trie;

import java.util.ArrayList;

public class Trie_Test {
    public static void main(String[] args){
        Trie tr= new Trie();
        tr.add("sonu");
        tr.add("rajpaksha");
        System.out.println(tr.search("sonu"));
        tr.remove("sonu");
        System.out.println(tr.search("sonu"));
        System.out.println(tr.get_num_of_words());
        String str="do dont no not note notes den";
        String[]st=str.split(" ");
        ArrayList<String>str1= new ArrayList<>();

        for(int i=0;i<st.length;i++){
            System.out.println(st[i]);
            str1.add(st[i]);
        }
        for(int i=0;i<str1.size();i++){
            String words=str1.get(i);
            for(int j=0;j<words.length();j++){//making suffix Trie for every word in String ArrayList
                tr.pattern_add(words.substring(j));
            }
        }
        System.out.println(tr.get_num_of_words());
        System.out.println("Search the given word"+ tr.search("no"));
        tr.add("sonu");
        tr.print();
    }
}
