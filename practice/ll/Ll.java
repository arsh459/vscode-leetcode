package ll;

// here there is no need to use this we can directly write head

class Ll {
    Node head;
    private int size;

    Ll(){
        this.size=0;
    }

    public int getSize(){
        return size;
    }


    class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
        }
    }


    // add first
    public void add(String data){
        Node newNode= new Node(data);
        if(this.head==null){
            this.head=newNode;
            size++;
            return;
        }
        newNode.next=this.head;
        this.head=newNode;
        size++;
    }

    // add last
    public void addLast(String data){
        Node newNode= new Node(data);
        if(this.head==null){
            this.head=newNode;
            size++;
            return;
        }
        Node currNode= this.head;
        while(currNode.next != null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
        size++;
    }

    // delete first
    public void delete(){
        if(this.head==null){
            return;
        }
        this.head= this.head.next;
        size--;
    }

    // delete last
    public void deleteLast(){
        if(this.head==null || this.head.next==null){
            this.head=null;
            size=0;
            return;
        }
        Node lastNode = this.head.next;
        Node secondLastNode=this.head;

        while(lastNode.next != null){
            lastNode=lastNode.next;
            secondLastNode=secondLastNode.next;
        }
        secondLastNode.next=null;
        size--;

    }

    // insert at index
    public void insert(int i, String data){
        if(i>size || i<0){
            System.out.println("invalid value");
            return;
        }


        Node newNode = new Node(data);
        if(head==null || i==0){
            newNode.next=head;
            head=newNode;        
            size++;
            return;
        }

        Node currNode=head;
        for(int j=1;j<i;j++){
            currNode=currNode.next;
        }
        newNode.next=currNode.next;
        currNode.next=newNode;
        size++;
    }

    // print ll
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


    // very important using iteration
    public void reverse(){
        Node prevNode= null;
        Node currNode=head;
        Node nextNode = head.next;
        while(nextNode!=null){
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;
            nextNode=nextNode.next;
        }
        currNode.next=prevNode;
        head=currNode;
    }

    // very important using recursion
    public Node reverseUsingRec(Node node){
        if(head==null || node.next==null){
            head=node;
            return node;
        }
        Node newNode = reverseUsingRec(node.next);
        newNode.next=node;
        node.next=null;
        return node;
    }

    public Node swapTwo(Node head){
        if(head.next==null){
            return head;
        }
        Node newHead = swapTwo(head.next.next);
        Node prevNode=head;
        Node currNode=head.next;

        newHead.next=prevNode;
        prevNode.next=currNode;
        currNode.next=null;
        return currNode;
    }
    public static void main(String[] args){
        Ll list = new Ll();
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        // list.addLast("e");
        // list.add("a");
        // list.insert(3, "k");
        list.printList();
        
        // list.delete();
        // list.printList();

        // list.deleteLast();
        // list.printList();
        // System.out.print(list.getSize()); ;

        // list.reverseUsingRec(list.head);

        list.swapTwo(list.head);
        list.printList();
    }
}