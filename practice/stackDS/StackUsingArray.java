package stackDS;

import java.util.ArrayList;

public class StackUsingArray {

    static class Stack{
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty(){
            if(list.size()==0){
                return true;
            }
            return false;
        }

        public void push(int data){
            list.add(data);
        }

        public int peek(){
            if(list.size()==0){
                return -1;
            }
           return list.get(list.size()-1);
        }

        public int pop(){
            if(list.size()==0){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
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
