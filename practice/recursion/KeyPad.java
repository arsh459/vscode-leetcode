package recursion;

import java.util.HashSet;

public class KeyPad {
    public static String[] keypad={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    
    // subsequences of a string
    public static void combinations(String s, int i,String str){
        if(i==s.length()){
            System.out.println(str);
            return;
        }
        String ks= keypad[s.charAt(i)-'0'];
        for(int j=0;j<ks.length();j++){
            combinations(s, i+1, str+ks.charAt(j));
        }
    }

    public static void main(String[] args){
        String s= "012";
        combinations(s,0,"");
    }
}
