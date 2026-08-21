package HashSetDS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class HashingQues {
    

    // print frequency > n/3
    public static void printFrequency(int[] a){
         HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(hm.containsKey(a[i])){
                hm.put(a[i], hm.get(a[i])+1);
            }else{
                hm.put(a[i], 1);
            }
        }

        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            if(e.getValue()>(a.length/3)){
                System.out.println(e.getKey()+" --> "+e.getValue());
            }
        }
    }

    // union of 2 arrays
    public static void union(int[] a, int[] b){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<a.length;i++){
            hs.add(a[i]);
        }

        for(int i=0;i<b.length;i++){
            hs.add(b[i]);
        }
        Iterator it= hs.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");  
        }
    }


    // union of 2 arrays
    public static void intersection(int[] a, int[] b){
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        for(int i=0;i<a.length;i++){
            hs.add(a[i]);
        }

        for(int i=0;i<b.length;i++){
            if(hs.contains(b[i])){
                hs2.add(b[i]);
            }
        }
        Iterator it= hs2.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");  
        }
    }


    // find iternary from tickets
    // "chennai"->"blr"
    // "mumbai"-> delhi
    // "goa" -> "chennai"
    // "delhi" -> "goa"
    // first find start - which will only exist once and in keys then move from 
    public static void printIternary(){
        HashMap<String,String> hs= new HashMap<>();
        hs.put("c", "b");
        hs.put("m", "d");
        hs.put("g", "c");
        hs.put("d", "g");

        String start=null;
        HashMap<String,String> hsr = new HashMap<>();
        for(String key:hs.keySet()){
            hsr.put(hs.get(key),key);
        }
        for(String key:hs.keySet()){
            if(!hsr.containsKey(key)){
                start= key;
                break;
            }
        }
        while(hs.containsKey(start)){
            System.out.println(start);
            start= hs.get(start);
        }
        System.out.println(start);
    }


    // find subarray sum equal to k
    // prefix sum approach - we get cumulative sum till index and store in another array
    // so basically sum(i,j) = prefix(j)-prefix(i-1);
    // k = prefix(j)-prefix(i-1);

    public static void printArray(int[] a){
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        // int[] a = {1, 2, 2, 2, 2, 3, 4,4, 4,4};
        // int[] b = {1, 2, 2, 7};
        // printFrequency(a);
        // union(a, b);
        // printIternary();

        int[] a ={1,2,3};
        int k =3;

        int sum =0;
        int count=0;

        HashMap<Integer,Integer> hs = new HashMap<>();     
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(sum==k){
                count++;
            }
            if(hs.containsKey(sum-k)){
                count = count + hs.get(sum-k);
            }
            hs.put(sum,hs.getOrDefault(sum,0)+1);
        }
        System.out.println("count : "+count);

    }
}
