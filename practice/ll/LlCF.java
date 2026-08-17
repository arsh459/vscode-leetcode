package ll;

import java.util.LinkedList;

public class LlCF {

    
    public static void main(String[] args){
        LinkedList<String> ll = new LinkedList<>(); 
        ll.add("b");
        ll.add("c");
        ll.add("d");
        ll.add("e");
        ll.addFirst("a");
        System.out.print(ll);

        ll.get(0); // to get data at any index

        ll.remove(); // by default remove first
        ll.remove(2); // by default remove first
        ll.removeLast(); // by default remove first
        System.out.print(ll);
    }  
}
