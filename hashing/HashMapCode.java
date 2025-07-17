package hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K,V>{    //instead of witing <Key data_type,Value data_type>we are writing <K,V>which is GENERIC data type which means we dont know the data type of key or value it inclue all data type

        private class Node{    //it stores the value of each linkedlist node present in buckets
            K key;
            V value;

            public Node (K key,V value){
                this.key =key;
                this.value=value;
            }
        }
        private int size;  //n =no. of nodes
        private int N;//bucket.length
        private LinkedList<Node>bucket[];  //it is a kind of array which is of size N.Here each index store a LinkedList(not LinkedList Node)

        @SuppressWarnings("unchecked")   //to supress the warning which is gicen by line 22 because there we are not providing the data type of LinkedList which gives an error msg and stop code from run so we supress that error msg use this operation carefully(uppressing warnings blindly can hide potential bugs.)
        public HashMap(){
            this.N=4;
            this.bucket=new LinkedList[4];//The array has 4 slots (so it can hold 4 linked lists)
            for(int i=0;i<4;i++){
                this.bucket[i]=new LinkedList<>();
            }
        }


        // HASHING the key values
        private int hashFunction(K key){
            int hc=key.hashCode();
            return Math.abs(hc)%N;//abs is used to get absolute value of hc and %size is used to get the value in bucket size range because hc can give any value
        }

        // SEARCHING value in LinkedList 
        private int SearchInLL(K key,int bi) {
            LinkedList<Node>ll=bucket[bi];
            int di=0;
            for (Node node : ll) {
                if(node.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        // REHASHING the key value when (lambda>threshold value )
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>oldBucket[]=bucket;
            bucket=new LinkedList[N*2];//The array has 2*N slots (so it can hold 2*N linked lists)
            N=2*N;
            for(int i=0;i<bucket.length;i++){
                bucket[i]=new LinkedList<>();
            }
            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node>ll=oldBucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node =ll.remove();
                    put(node.key,node.value);
                }
            }
        }
        
        // Putting new value and Key in HashMap
        public void put(K key,V value){
            int bi=hashFunction(key);//bi=bucket index
            int di=SearchInLL(key,bi); //di =data index
            if(di!=-1){
                Node node=bucket[bi].get(di);
                node.value=value;
            }
            else{
                bucket[bi].add(new Node(key,value));
                size++;
            }
            double lambda=(double)size/N;
            if(lambda>=2.0){
                rehash();
            }
        }
        
        // CONTAINING that key or not in HashMap
        public boolean ContainKey(K key){
            int bi=hashFunction(key);//bi=bucket index
            int di=SearchInLL(key,bi); //di =data index
            if(di!=-1){
                return true;
            }
            else{
                return false;
            }   
        }

        // GETTING the value associated with key value
        public V get(K key){
            int bi=hashFunction(key);//bi=bucket index
            int di=SearchInLL(key,bi); //di =data index
            if(di!=-1){
                Node node=bucket[bi].get(di);
                return node.value;
            }
            else{
                return null;
            }
        }
        
        // REMOVING the Node
        public V remove(K key){
            int bi=hashFunction(key);//bi=bucket index
            int di=SearchInLL(key,bi); //di =data index
            if(di!=-1){
                Node node=bucket[bi].remove(di);
                size--;
                return node.value;
            }
            else{
                return null;
            }
        }

        // KEYSET
        public ArrayList<K>keySet(){
            ArrayList<K>keys=new ArrayList<>();
            for(int i=0;i<bucket.length;i++){
                LinkedList<Node>ll=bucket[i];
                for(Node node:ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // Empty Map or not
        public boolean isEmpty(){
            return size==0;
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer>hm=new HashMap<>();
        hm.put("India", 125);
        hm.put("China", 120);
        hm.put("Bhutan", 115);
        hm.put("US", 110);
        hm.put("India", 105);
        
        ArrayList<String>keys=hm.keySet();
        for(String key:keys){
            System.out.println(key);
        }
        System.out.println(hm.get("US")); 
        hm.remove("US");
        System.out.println(hm.get("US"));
    }

}
