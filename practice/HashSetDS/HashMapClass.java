package HashSetDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapClass {
    // unordered
    // o(1)

    // it is key value pair
    public static void main(String[] args){
        HashMap<String,Integer> map = new HashMap<>();

        map.put("india", 120);
        map.put("china", 140);
        map.put("usa", 140);

        System.out.println(map);
        map.put("abc", 140);

        // search
        map.containsKey("china");
        map.get("china");

        // iteration
        // new for loop
        // for(Object val : collection){}
        // so we can use this on a collection

        // ArrayList<Integer> al = new ArrayList<>();
        // for(int i =0;i<al.size();i++){}
        // for(int element : al ){} // here element will be the value in array


       for( Map.Entry<String, Integer> e : map.entrySet()){
        System.out.println(e.getKey());
        System.out.println(e.getValue());
       }

       Set<String> keys = map.keySet();
       for(String key :keys){
            System.out.println(key);
            System.out.println(map.get(key));
       } 

        // deletion
        map.remove("china");    
    }


    
}
