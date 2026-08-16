package ll;

import java.util.LinkedList;
import java.util.Scanner;

public class LLQ {
    Node head;
    private int size=0;
    public int getSize(){
        return size;
    }
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            size++;
            return;
        }

        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }

        currNode.next=newNode;
        size++;
    }


    public int search(int data){
        int index=-1;
        Node currNode=head;

        for(int i=0;i<size;i++){
            if(currNode.data==data){
                index=i;
                break;
            }
            currNode=currNode.next;
        }
        return index;
    }

    public void delete(int data){
        if(head==null){
            return;
        }
        Node currNode=head;
        while(currNode.next != null){
            if(currNode.next.data>25){
                currNode.next=currNode.next.next;
            }else{
                currNode=currNode.next;
            }
        }
        if(head.data>25){
            head=head.next;
        }
    }

    public void printList(){
        if(this.head==null){
            System.out.println("NULL");
            return;
        }
        Node currNode= this.head;
        while(currNode != null){
            System.out.print(currNode.data+" -> ");
            currNode=currNode.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void main(String[] args){
        LLQ l= new LLQ();
        Scanner sc= new Scanner(System.in);

        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            l.addLast(sc.nextInt());
        }
        sc.close();
        // System.out.println(l.search(7));
        l.delete(25);
        l.printList();

    }
}
