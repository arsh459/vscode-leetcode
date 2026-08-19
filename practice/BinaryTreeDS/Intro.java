package BinaryTreeDS;

import java.text.NumberFormat.Style;
import java.util.LinkedList;
import java.util.Queue;

public class Intro {
    // tree have parent node - root
    // leaf nodes that don;t have child
    // in case Binary trees they have left child and right child
    // ancestors 

    // root is at level 1 
    // depth is also level

    // subTree
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    static class BinaryTree{
        static int index = -1;

        // Preorder build tree 
        public Node buildTreePreorder(int[] nodes){
            index++;
            if(nodes[index]==-1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left=buildTreePreorder(nodes);
            newNode.right=buildTreePreorder(nodes);
            return newNode;
        }

        // Preorder traversal - first root then left then right
        // here root will come at start
        // DFS
        public void traversePreorder(Node root){
            if(root==null){
                // It can be printed with or without -1
                System.out.print(-1 +" ");
                return;
            }
            System.out.print(root.data +" ");
            traversePreorder(root.left);
            traversePreorder(root.right);
        }

        // Inorder traversal - First rule is print left subtree and then root and right subtree
        // here root will come in middle
        // DFS
        public void traverseInorder(Node root){
            if(root==null){
                return;
            }
            traverseInorder(root.left);
            System.out.print(root.data +" ");
            traverseInorder(root.right);
        }

        // Inorder traversal - First rule is print left subtree and then right and root
        // here root will come at end
        // DFS
        public void traversePostorder(Node root){
            if(root==null){
                return;
            }
            traversePostorder(root.left);
            traversePostorder(root.right);
            System.out.print(root.data +" ");
        }

        // Level order traversal - print level by level
        // here root will come at start
        // it will be done iterately and not it recursion
        // we will use queue for this
        // BFS
        // we will use null to show next line
        public void traverseLevelorder(Node root){
            if(root==null){
                return;
            }


            Queue<Node> q= new LinkedList<Node>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.poll();
                if(currNode==null){
                    if(q.isEmpty()){
                        break;
                    }
                    q.add(currNode);
                    System.out.println();
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        public int countNodes(Node root){
            if(root==null){
                return 0;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;  
        }

        public int sumNodes(Node root){
            if(root==null){
                return 0;
            }
            return sumNodes(root.left) + sumNodes(root.right) + root.data;  
        }

        // distance to deepest node means highest level
        public int heightOfTree(Node root){
            if(root==null){
                return 0;
            }

            int leftHeight = heightOfTree(root.left);
            int rightHeight= heightOfTree(root.right);
            return Math.max(leftHeight, rightHeight)+1;
        }


        // diameter of a node - Number of nodes in longest path between any 2 nodes
        // 2 cases are there 
        // 1. path goes throught root
        // 2. path does not go through root


        // O(n2)
        // approach 1 is find max(lsD,rsD, lsH+rsH+1) - it is based on fact either maxDia will lie in left subtree or rightSubTree or it will pass through root
        public int diameter(Node root){
            if(root==null){
                return 0;
            }
            int leftTreeDia = diameter(root.left);
            int rightTreeDia = diameter(root.right);
            int rootTreeDia= heightOfTree(root.left) + heightOfTree(root.right)+ 1; // it takes O(n)
            return Math.max(Math.max(rightTreeDia, leftTreeDia),rootTreeDia);
        }

        // O(n)
        // approach 2 
        // we will find height and diameter of each node and save them
        static class TreeInfo{
            int ht;
            int dia;
            TreeInfo(int ht, int dia){
                this.ht=ht;
                this.dia=dia;
            }

        }
        public TreeInfo HeightAnddiameterOfNode(Node root){
            if(root==null){
                return new TreeInfo(0, 0);
            }
            TreeInfo left = HeightAnddiameterOfNode(root.left);
            TreeInfo right = HeightAnddiameterOfNode(root.right);
            int rootDia= left.ht+ right.ht+1;

            int myHeight = Math.max(left.ht, right.ht)+1;
            int myDia = Math.max(rootDia, Math.max(left.dia, right.dia));
            return new TreeInfo(myHeight, myDia);
        }

        // Subtree of another tree - we have to find if one tree is subtree of another tree
        // see leetcode question of sub-tree of another tree

        // sum of nodes at kth level // for tomorrow for practice
    }


    public static void main(String[] args){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree bt= new BinaryTree();
        Node root = bt.buildTreePreorder(nodes);
        System.out.println(root.data);
        bt.traverseLevelorder(root);
        System.out.println(); 

        System.out.print(bt.countNodes(root)); 
        System.out.print(bt.sumNodes(root)); 
        System.out.println(bt.heightOfTree(root)); 
        System.out.println(bt.diameter(root)); 

        System.out.println(bt.HeightAnddiameterOfNode(root).dia);
        System.out.println(bt.HeightAnddiameterOfNode(root).ht);

    }
}
