package recursion;

public class TowerOfHanoi {
    public static String reverseString(String s, int i){
        if(i<0){
            return "";
        }
        return s.charAt(i) + reverseString(s,i-1);
    }

    public static String firstAndLastOccurance(String s, char a){
        if(i<0){
            return "";
        }
        return s.charAt(i) + reverseString(s,i-1);
    }

    public static void main(String[] args){
        String s ="Abcd";
        System.out.println(reverseString(s,s.length()-1));  
    }
}
