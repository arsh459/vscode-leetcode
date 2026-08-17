package QueueDS;

import java.util.ArrayDeque;
import java.util.Stack;

public class QuestionImplementQueueUsing2Stacks {


    // push o(n)
    static class QueueWithPushN{
        Stack<Integer> st1;
        Stack<Integer> st2;

        QueueWithPushN(){
            st1=new Stack<>();
            st2=new Stack<>();
        }

        public boolean isEmpty(){
            return st1.isEmpty();
        } 

        // enqueue o(n)
        public void add(int data){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            st1.push(data);
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }

        // dequeue - remove first element- o(1)
        public int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return st1.pop();
        }

        // peek - check first element- o(1)
        public int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return st1.peek();
        }
    }


    // pop o(n)
    static class QueueWithPopN{
        Stack<Integer> st1;
        Stack<Integer> st2;

        QueueWithPopN(){
            st1=new Stack<>();
            st2=new Stack<>();
        }

        public boolean isEmpty(){
            return st1.isEmpty();
        } 

        // enqueue o(1)
        public void add(int data){
            st1.push(data);
        }

        // dequeue - remove first element- o(n)
        public int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            int top= st2.pop();
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
            return top;
        }

        // peek - check first element- o(1)
        public int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            int top= st2.peek();
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
            return top;
        }
    }


    public static void main(String[] args){
        QueueWithPushN q= new QueueWithPushN();
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
