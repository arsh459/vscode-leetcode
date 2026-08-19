package HashSetDS;

import java.util.ArrayList;
import java.util.LinkedList;



// average is o(lambda)
// worst is O(n) - it is when hashfunction is return the same index and all elements are getting added on same bucket element
// or we have to do rehashing again and again
public class HashMapImpl {
    // key is unique

    // put
    // get 
    // containsKey
    // remove
    // size
    // keySet()

    // it is internally implemented using Array of linkedList
    // we will have n nodes as much as data
    // we will N as no of linkedList in array mean array size and it is same as number of bucket
    // n/N - Lamba - means total nodes are divided into N buckets so average linkedList size is Lamba, which is constant value or threshold value,
    // if linkedList size increase more than lambda then we increase the size of array and increase n, it is also called rehashing


    // put(key,value)  - find(key) + insert(Key)
    // for finding first we will key to a hash function which will return bucket index(index of array) and then we will search the linkedList 
    // if we find any element we update it otherwise we add it at last or first of linkedList(which is of max constant size)
    // so time complexity is O(lambda)

    // for rehashing, a array of double size is created and then hash is calculated for each element and put in new array 



    static class HashMap<K,V>{
        class Node{
            K key;
            V value;

            Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];  // N = buckets.length


        public HashMap(){
            this.N= 4;
            this.buckets= new LinkedList[4];
            for(int i=0;i<N;i++){
                buckets[i]=new LinkedList<>();
            }
        }


        // put function
        private int hashFunction(K key){
            int bI= key.hashCode(); // it can be any integer so take modulus with N
            return Math.abs(bI) % N;
        }

        private int searchInLinkedList(K key, int bi){
            LinkedList<Node> li = buckets[bi];
            for(int i=0;i<li.size();i++){
                if(li.get(i).key==key){
                    return i;
                }
            }
            return -1;
        }

        public void rehash(){
            LinkedList<Node> oldBuckets[] =buckets;
            buckets= new LinkedList[N*2];
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>();
            }

            for(int i=0;i<oldBuckets.length;i++){
                LinkedList<Node> li = oldBuckets[i];
                for(int j=0;j<li.size();j++){
                    put(li.get(j).key, li.get(j).value);
                }
            }
        }

        public void put(K key, V value){
            int bI = hashFunction(key);
            int dI = searchInLinkedList(key,bI);
            if(dI==-1){
                buckets[bI].add(new Node(key, value));
                n++;
            }else{
                Node data =buckets[bI].get(dI);
                data.value= value;
            }

            double lambda = (double)n/N;
            if(lambda>2){ // it can be anything like 5, 6 it is just a constant
                rehash();
            }
        }


        // get 
        public V get(K key){
            int bI = hashFunction(key);
            int dI = searchInLinkedList(key,bI);
            if(dI==-1){
                return null;
            }else{
                Node data =buckets[bI].get(dI);
                return data.value;
            }
        }

        // containsKey
        public boolean containsKey(K key){
            int bI = hashFunction(key);
            int dI = searchInLinkedList(key,bI);
            if(dI==-1){
                return false;
            }else{
                return true;
            }
        }

        // remove
        public V remove(K key){
            int bI = hashFunction(key);
            int dI = searchInLinkedList(key,bI);
            if(dI==-1){
                return null;
            }else{
                Node data =buckets[bI].remove(dI);
                n--;
                return data.value;
            }
        }

        // isEmpty
        public boolean isEmpty(K key){
            return n==0;
        }

        // keySet
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> li = buckets[i];
                for(int j=0;j<li.size();j++){
                    Node node = li.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // print
        public void print(){
            ArrayList<K> li = keySet();
            for(int i=0;i<li.size();i++){
                System.out.println(li.get(i) + " --> " + get(li.get(i)));
            }
            System.out.println();
        }

    }



    public static void main(String[] args){
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("usa", 140);
        hm.put("india", 120);
        hm.put("usa", 130);
        hm.print();

        hm.remove("usa");
        hm.print();
    }
}
