package String;
import java.util.*;
import java.util.Scanner;

public class Basics_of_string {
    public String split_string(String str){
        String []res=str.split(" ");
        String result="";
        for(int i=0;i<res.length;i++){
            result =result+reverse(res[i]) + " ";
        }
        return result;
    }
    public String reverse(String str1){
        if(str1.length()==1){
            return str1;
        }
        int end=str1.length()-1;
        String result="";
        for(int i=end;i>=0;i--){
            char tmp=str1.charAt(i);
            result =result +tmp;
        }
        return result;
    }
    public void coding(){
        int n=10,r=6;
        int factn=1,factr=1,factnr=1;
        for(int i=2;i<=n;i++)
        {
            factn*=i;
            if(i<=r)
                factr*=i;
            if(i<=n-r)
                factnr*=i;
        }
        int ncr=factn/(factr*factnr);
        System.out.print(ncr);
    }
    public static void main(String[] args){
        Basics_of_string bsc=new Basics_of_string();
       // bsc.coding();
        String str="Hello, I am Aadil!";
        String ans1=bsc.split_string(str);
        System.out.println(ans1);
//        String a ="abcd";
//        String b="abcda";
       //System.out.println(ans);

    }
}
