package recursion;

import java.util.HashSet;

public class TowerOfHanoi {

    public static String reverseString(String s, int i){
        if(i<0){
            return "";
        }
        return s.charAt(i) + reverseString(s,i-1);
    }

    public static int f=-1;
    public static int l=-1;
    public static void firstAndLastOccurance(String s,int i, char a){
        if(i==s.length()){
            System.out.print("first Occ " + f + " Last " + l);
            return;
        }
        if(a==s.charAt(i)){
            if(f == -1){
                f=i;
            }
            l=i;
        }
        firstAndLastOccurance(s,i+1,a);
    }

    // strictly increasing
    public static boolean checkIfArrayIsSorted(int[] a, int i){
        if(i==a.length-1){
            return true;
        }
        if(a[i+1]<=a[i]){
            return false;
        }
        return checkIfArrayIsSorted(a,i+1);
    }

    // Move all x to last
    public static String stringMove(String s, int i, char a,int count, String newStr){
        if(i==s.length()){
            for(int j=0;j<count;j++){
                newStr+=a;
            }
            return newStr;
        }
        if(s.charAt(i)==a){
            count++;
        }else{
            newStr+=s.charAt(i);
        }
        return stringMove(s, i+1, a,count,newStr);
    }


    // done my creating a array of booleans
    public static String removeDuplicates(String s, int i, boolean[] a, String newStr){
        if(i==s.length()){
            return newStr;
        }
        
        if(!a[s.charAt(i)-97]){
            a[s.charAt(i)-97]=true;
            newStr+=s.charAt(i);
        }
        return removeDuplicates(s, i+1, a, newStr);
    }

    public static int powerOf2(int n){
        return 1<<n;
    }

    // subsequences of a string
    public static void subSequences(String s, int i, String str,HashSet<String> hs){
        if(i==s.length()){
            if(!hs.contains(str)){            
                hs.add(str);
                System.out.println(str);
            }
            return;
        }
        subSequences(s,i+1, str+s.charAt(i),hs);
        subSequences(s,i+1, str,hs);
    }

    public static void main(String[] args){
        String s= "aa";
        HashSet<String> hs=new HashSet<>(); 
        subSequences(s,0,"", hs);
    }
}
