package Trie;

public class Intro {
    // prefix tree
    // digital search 
    // retrivel tree
    // it is a tree in a node can have multiple children, they are also called k-array tree
    // search time complexity - o(l) - length of words
    // root is an empty node
    // prefix is not repeated

    static class Node{
        Node[] children;   // we can have 26 letters a-z , if we need to take all the java valid character then size will be 256
        boolean eow; // endOfWord
        Node(){
            children= new Node[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            eow=false;
        }
    }

    static class Trie{
        Node root;
        Trie(){
            root=new Node();
        }

        // insert
        public void insert(String word){
            Node currRoot= root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i) - 'a';
                if(currRoot.children[idx]==null){
                    currRoot.children[idx] = new Node();
                }
                if(i==word.length()-1){
                    currRoot.children[idx].eow=true;
                }
                currRoot=currRoot.children[idx];
            }
        }

        // search
        public boolean search(String word){
            Node currRoot= root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i) - 'a';
                if(currRoot.children[idx]==null){
                    return false;
                }
                if(i==word.length()-1 && !currRoot.children[idx].eow){
                    return false;
                }
                currRoot=currRoot.children[idx];
            }
            return true;
        }
    }


    // word break problem

    public static boolean wordBreak(Trie trie,String str){
        if(str.length()==0){
            return true;
        }
        boolean exists= false;
        for(int i=0;i<str.length();i++){
            if(trie.search(str.substring(0, i+1))){
                if(wordBreak(trie, str.substring(i+1))){
                    exists=true;
                }      
            }
        }
        return exists;
    }



    public static boolean wordExist(){
        String words[] = {"i","like","samsung","phone","you"};
        String word ="you";
        Trie trie= new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }
        System.out.print(wordBreak(trie, word));






        // we will use recursion to break problem in the trie
        // first insert in Trie

        return false;
    }

    public static void main(String[] args){
        // String words[] = {"abc","arsh","arshgoy", "chinmay","there"};
        // Trie trie = new Trie();
        // for(int i=0;i<words.length;i++){
        //     trie.insert(words[i]);
        // }
        // System.out.print(trie.search("arshg"));;
        wordExist();
    }
    
}
