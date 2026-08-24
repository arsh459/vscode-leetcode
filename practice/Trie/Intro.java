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

        // get node count
        public int countNodes(Node root){
            if(root==null){
                return 0;
            }

            int validChildCount=0;
            for(int i=0;i<root.children.length;i++){
                if(root.children[i]!=null){
                    validChildCount+=countNodes(root.children[i]);
                } 
            }
            return validChildCount+1;
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

    public static void wordExist(){
        String words[] = {"i","like","samsung","phone","you"};
        String word ="you";
        Trie trie= new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }
        System.out.print(wordBreak(trie, word));
    }

    // prefix exist
    public static void prefixExists(){
        String words[] = {"i","like","samsung","phone","your"};
        String word ="same";
        Trie trie= new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }

        Node currRoot= trie.root;
        boolean exists=true;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(currRoot.children[idx]==null){
                exists=false;
                break;
            }
            currRoot=currRoot.children[idx];
        }
        System.out.print(exists);
    }

    // count unique substrings
    //substrings are just all prefixes of all suffixes or all suffixes of all prefixes
    // apple  prefixes -"", a,ap,app,appl,apple
            //suffixes -"" ,e, le, ple, pple, apple 
    //  we will solve by all prefixes of all suffixes
    // Trie ds have all unique prefixes that's why called prefix tree
    public static void countUniqueSubstring(){
        String s = "ababa";
        Trie trie = new Trie();
        for(int i=0;i<s.length();i++){
            trie.insert(s.substring(i));
        }
        
        // total number of nodes in trie are just unique substrings
        System.out.print(trie.countNodes(trie.root));

    }



    // Longest word for which all its prefixes also exists as a word
    // it will means we have to find longest path with every node as eow=true
    public static void longestWordPrefix(){
        String words[] = {"a","ap","app","appl","apple","samsung","phone","your"};
        Trie trie= new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }
        traverse(trie.root, new StringBuilder(""));
    }

    public static String ans= "";
    public static void traverse(Node root, StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null && root.children[i].eow){
                temp.append((char)i+'a');
                if(temp.length()>ans.length()){
                    ans= temp.toString();
                }
                traverse(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args){
        // String words[] = {"abc","arsh","arshgoy", "chinmay","there"};
        // Trie trie = new Trie();
        // for(int i=0;i<words.length;i++){
        //     trie.insert(words[i]);
        // }
        // System.out.print(trie.search("arshg"));;
        // wordExist();
        // prefixExists();
        // countUniqueSubstring();
        longestWordPrefix();
        

    }
    
}
