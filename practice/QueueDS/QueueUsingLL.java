package QueueDS;

public class QueueUsingLL {
    // fifo
    // Enque - add a element
    // Dequeue - remove a element
    // Front - Peek


    // here there is no limitation of size


    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }


    static class Queue{
        Node head;
        Node tail;
        private int size;

        public boolean isEmpty(){
            return head==null;
        } 

        // enqueue o(1)
        public void add(int data){
            Node newNode=new Node(data);
            size++;
            if(isEmpty()){
                head=newNode;
                tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }

        // dequeue - remove first element- o(1)
        public int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            size--;
            int front=head.data;
            if(head==tail){
                tail=head.next;
            }
            head=head.next;
            return front;
        }

        // dequeue - remove first element- o(1)
        public int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return head.data;
        }

        

    }

    public static void main(String[] args){
        Queue q= new Queue();
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
