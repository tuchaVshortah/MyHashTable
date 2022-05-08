public class MyHashTable<K, V> {

    private class HashNode<K, V> {

        public K key;
        public V value;
        public HashNode <K, V> next = null;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size = 0;

    public MyHashTable() {
        for(int i = 0; i < M; i++){
            chainArray[i] = null;
        }
    }

    public MyHashTable(int M) {
        this.M = M;
        for(int i = 0; i < M; i++){
            chainArray[i] = null;
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {

        int chainIndex = hash(key) % M;
        chainIndex = chainIndex < 0 ? chainIndex * (-1) : chainIndex;
        HashNode<K, V> chain = chainArray[chainIndex];

        //check if the key is already in the hashtable
        while(chain != null){
            if(chain.key.equals(key)) {
                chain.value = value;
                return;
            }
            chain = chain.next;
        }

        //otherwise increase size of the hashtable and add it
        size++;

        chain = chainArray[chainIndex];
        HashNode<K, V> newNode = new HashNode<>(K, V);
        newNode.next = chain;
        chainArray[chainIndex] = newNode;

        //check if load factor is ok
        if((1.0 * size) / M >= 0.75){

            //create a temporarty copy of the hashtable
            HashNode<K, V> temp[M];
            for(int i = 0; i < size; i++){
                temp[i] = chainArray[i];
            }

            //increase load factor
            M *= 2;
            int tempSize = size;
            size = 0;

            //create new chainArray with increased capacity
            chainArray = new HashNode[M];

            //put old elements in new chainArray
            for(int i = 0; i < tempSize; i++){
                //temporary chain element
                chain = temp[i];
                while(chain != null){
                    put(chain.key, chain.value);
                    chain = chain.next;
                }
            }
        }
    }

    public V get(K key) {
        int chainIndex = hash(key) % M;
        chainIndex = chainIndex < 0 ? chainIndex * (-1) : chainIndex;

        HashNode<K, V> chain = chainArray[chainIndex];

        while(chain != null) {
            if(chain.key.equals(key)){
                return chain.value;
            }
            chain = chain.next;
        }

        //if key wasn't found
        return null;
    }

    public V remove(K key) {
        //determine offset to the target
        int chainIndex = hash(key) % M;
        chainIndex = chainIndex < 0 ? chainIndex * (-1) : chainIndex;

        HashNode<K, V> chain = chainArray[chainIndex], prev = null;

        //loop through all the elements of a chain
        while(chain != null){
            //if key is present and prev is not null (not first element case) delete pointers to an element
            //then return its value
            if(chain.key.equals(key) && prev != null){
                prev.next = chain.next;
                size--;
                return chain.value;
            }else{
                //the first element case (prev is null)
                //the second element will become the head of a chain (the first element will be deleted)
                chainArray[chainIndex] = chain.next;
                return chain.value;
            }
            prev = chain;
            chain = chain.next;
        }

        //return null to the caller if nothing was found
        return null;
    }

    public boolean contains(V value) {

        HashNode<K, V> chain;
        //iterate through all chains in the chainArray
        for(int i = 0; i < size; i++){
            chain = chainArray[i];
            while(chain != null) {
                //loop through all the nodes of a chain until null node is reached
                if (chain.value.equals(value)) {
                    //return true on success
                    return true;
                }
                chain = chain.next;
            }
        }
        //otherwise, return false
        return false;
    }

    public K getKey(V value) {

        HashNode<K, V> chain;
        //check if value is present in the chainArray
        if(contains(value)){
            for(int i = 0; i < size; i++){
                chain = chainArray[i];
                while(chain != null) {
                    //loop through all the nodes of a chain until null node is reached
                    if (chain.value.equals(value)) {
                        //return key to the value
                        return chain.key;
                    }
                    chain = chain.next;
                }
            }
        }
        //otherwise return null
        return null;
    }

}
