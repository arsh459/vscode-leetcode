package QueueDS;

public class CircularQueueUsingArray {

    // in normal queue we don;t move the front just move the rear, here when we want to remove rather that shifting the element left by one
    // we just move the front by one.
    // here all things takes just o(1)

    static class Queue{
        int[] arr;
        private int size;
        int rear= -1;
        int front = -1;
        Queue(int size){
            arr=new int[size];
            this.size=size;
        }
        public boolean isEmpty(){
            return rear== -1;
        } 

        public boolean isFull(){
            return (rear-front)==size-1 || (rear-front) == -1;
        } 

        // enqueue o(1)
        public void add(int data){
            if(isFull()){
                System.out.println("queue is full");
                return;
            }
            if(front == -1){
                front=0;
            }
            rear=(rear +1)%size;
            arr[rear]=data;
        }

        // dequeue - remove first element- o(1)
        public int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int first=arr[front];
            if(front==rear){
                front=-1;
                rear=-1;
            }else{
                front=(front+1)%size;
            }
            return first;
        }

        // dequeue - remove first element- o(1)
        public int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[front];
        }
    }



    public static void main(String[] args){
            Queue q= new Queue(5);
            q.add(1);
            q.add(2);
            q.remove();
            q.add(3);
            q.add(4);

            while (!q.isEmpty()) {
                System.out.print(q.peek() +" ");
                q.remove();
            }

        }
    
}
