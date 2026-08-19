package BinaryTreeDS;

import java.util.ArrayList;

public class BST {
    // bt
    // left subtree values < root
    // right subtree values > root
    // left and right subtrees are also bst and there are no duplicates

    // inorder traversal of bst it will give a sorted sequence


    // BST tree make search efficient just like binary search
    // it will make worst time of O(Height of tree);
    // in case of perfectly balanced tree H = log(n);
    // in case of skewed trees, means all nodes is going on single side it can look as linear tree


    // Build a BST
    // initial root node will be null

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    static class BinarySearchTree{
        static int index =-1;


        // O(Height)
        public static Node insert(Node root, int val){
            if(root == null){
                root= new Node(val);
                return root;
            }
            if(root.data>val){
                root.left = insert(root.left, val);
            }else{
                root.right = insert(root.right, val);
            }
            return root;
        }

        // buildBST
        public Node buildBST(int[] nodes){
            Node root =null;
            for(int i=0;i<nodes.length;i++){
                root=insert(root, nodes[i]);
            }
            return root;
        }

        // inorder traversal - will give sorted ascending list
        public void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // search - will give boolean if found - O(H)
        public boolean search(Node root, int key){
            if(root==null){
                return false;
            }

            if(root.data==key){
                return true;
            }

            if(root.data>key){
                return search(root.left, key);
            }else{
                return search(root.right, key);
            }
        }

        // delete a node in BST
        // case 1 - node is leaf simply delete the node
        // case 2 - node has a single child - delete node and connect parent to child of deleted node
        // case 3 - node has 2 children - replace with inorder sucessor

        public Node delete(Node root, int val){
            if(root==null){
                return root;
            }

            if(root.data>val){
                root.left = delete(root.left,val);
            }else if(root.data<val) {
                root.right=delete(root.right, val);
            }else{

                // case 1
                if(root.left==null && root.right==null){
                    return null;
                }

                // case 2
                else if(root.left==null){
                    return root.right;
                }

                else if(root.right==null){
                    return root.left;
                }

                // case 3
                else{
                    Node inorderSuccessor= inorderSuccessor(root.right);
                    root.data=inorderSuccessor.data;
                    root.right =delete(root.right, inorderSuccessor.data);
                }
            }

            return root;
        }

        public Node inorderSuccessor(Node root){
            if(root.left==null){
                return root;
            }
            return inorderSuccessor(root.left);
        }

        // print in range x= 6 to y= 10 in bst
        // case 1 if x<root<y call in left also and right also in left search between x to root and root to y
        // case 2 root<=x call in right sub tree
        // case root >=y call in left subtree
        public void printInRange(Node root, int x, int y){
            if(root==null){
                return;
            }

            if(root.data>=x && root.data<=y){
                printInRange(root.left, x, y);
                System.out.print(root.data+" ");
                printInRange(root.right, x, y);
            }
            else if(root.data>y){
                printInRange(root.left, x, y);
            }else{
                printInRange(root.right, x, y);
            }
        } 
        
        // Root to leaf paths
        // print all the paths from root to leaf

        public static void printNodeArray(ArrayList<Node> pathTraversed){
            for(int i=0;i<pathTraversed.size();i++){
                System.out.print(pathTraversed.get(i).data +"-->");
            }
            System.out.print("Null");
            System.out.println();
        }


        public void path(Node root, ArrayList<Node> pathTraversed){
            if(root==null){
                printNodeArray(pathTraversed);
                return;
            }
            pathTraversed.add(root);
            if(root.left==null && root.right==null){
                printNodeArray(pathTraversed);
            }else if(root.right==null){
                path(root.left,pathTraversed);
            }else if(root.left==null){
                path(root.right,pathTraversed);
            }else{
                path(root.left,pathTraversed);
                path(root.right,pathTraversed);
            }
            pathTraversed.remove(root);
        }
    }

    public static void main(String[] args){
        int nodes[] = {8,5,3,6,10,11,14};
        BinarySearchTree bst = new BinarySearchTree();
        Node root = bst.buildBST(nodes);
        bst.inorder(root);
        // if(bst.search(root, 5)){
        //     System.out.println("Found");
        // }else{
        //     System.out.println("Not Found");
        // };
        // bst.delete(root, 5);
        // bst.inorder(root);
        System.out.println();
        // bst.printInRange(root, 2, 3);

        bst.path(root, new ArrayList<>());
    }
}
