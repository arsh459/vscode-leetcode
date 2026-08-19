package HashSetDS;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetClass {
    // set does not allow duplicates
    // it is unordered

    // It is very big thing for a ds to have all three o(1)
    // insert - O(1)
    // search - O(1)
    // remove -  O(1)
    
    public static void main(String[] args){
        HashSet<Integer> hs = new HashSet<>();

        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(1);

        hs.contains(1);
        hs.contains(2);

        hs.remove(1);
        hs.size();
        System.out.println(hs);

        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());   
        }
    } 
}
