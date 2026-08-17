package QueueDS;

/**
 * QueueClass
 */
public class QueueUsingArray {
    // fifo
    // Enque - add a element
    // Dequeue - remove a element
    // Front - Peek


    // using array size is fixed so before adding we will check if we can add
    static class Queue{
        int[] arr;
        private int size;
        int rear= -1;
        Queue(int size){
            arr=new int[size];
            this.size=size;
        }

        public boolean isEmpty(){
            return rear== -1;
        } 

        // enqueue o(1)
        public void add(int data){
            if(rear==size-1){
                System.out.println("queue is full");
                return;
            }
            rear++;
            arr[rear]=data;
        }

        // dequeue - remove first element- o(n)
        public int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int front=arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;
        }

        // dequeue - remove first element- o(1)
        public int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[0];
        }

        public static void main(String[] args){
            Queue q= new Queue(5);
            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);

            while (!q.isEmpty()) {
                System.out.print(q.remove() +" ");
            }

        }

    }
}