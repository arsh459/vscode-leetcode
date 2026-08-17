package QueueDS;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingCollection {
    public static void main(String[] args){

        // as queue is interface, we are making queue using linkedList class
        // it is implemented using arrayDequeue
        // Queue<Integer> q= new LinkedList<>();
        Queue<Integer> q= new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.print(q.peek() +" ");
            q.remove();
        }
    }
}
