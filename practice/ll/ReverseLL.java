package ll;

import java.util.LinkedList;

public class ReverseLL {
    public static void main(String[] args){
        LinkedList<String> ll = new LinkedList<>(); 
        ll.add("b");
        ll.add("c");
        ll.add("d");
        ll.add("e");
        ll.addFirst("a");
        System.out.print(ll);

    }    
}
