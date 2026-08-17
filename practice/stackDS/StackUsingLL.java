package stackDS;

public class StackUsingLL{
    // LIFO
    // push(data)
    // pop() - find value at top and also remove it
    // peek() || top() - find value at top but don't remove it
    // it can be implemented using array, arraylist and linkedlist

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    static class Stack{
        public Node head;

        public boolean isEmpty(){
            if(head==null){
                return true;
            }
            return false;
        }

        public void push(int data){
            Node newNode= new Node(data);
            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top= head.data;
            head=head.next;
            return top;
        }
    }

    public static void main(String[] args){
        Stack st= new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        while(!st.isEmpty()){
            System.out.print(st.pop() + " "); 
        }
    }
}
