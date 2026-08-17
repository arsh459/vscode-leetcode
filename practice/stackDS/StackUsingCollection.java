package stackDS;

import java.util.Stack;

public class StackUsingCollection {

    // qus push at bottom of stack
    public static void pushAtBottomRecursion(int data, Stack<Integer> st){
        if(st.isEmpty()){
            st.push(data);
            return;
        }
        int top = st.pop();
        pushAtBottomRecursion(data, st);
        st.push(top);
    }

    // ques reverse a stack - Can be done with two stacks, but we will be using recursion
    public static void reverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int top =st.pop();
        reverse(st);
        pushAtBottomRecursion(top, st);
    }

    public static void main(String[] args){
        Stack<Integer> st= new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        pushAtBottomRecursion(5,st);

        reverse(st);

        while(!st.isEmpty()){
            System.out.print(st.pop() + " "); 
        }
    }
}
