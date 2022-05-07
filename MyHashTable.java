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
        return key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {

        int chainIndex = hash(key) % M < 0 index * (-1) : index;
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
            tempSize = size;
            size = 0;

            //create new chainArray with increased capacity
            chainArray = new HashNode[M];

            //put old elements in new chainArray
            for(int i = 0; i < tempSize; i++){
                //temporary chain element
                chain = temp[i];
                while(chain != null){
                    add(chain.key, chain.value);
                    chain = chain.next;
                }
            }
        }
    }

    public V get(K key) {
        int chainIndex = hash(key) % M < 0 index * (-1) : index;

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

        int chainIndex = hash(key) % M < 0 index * (-1) : index;
        int hashCode = hash(key);

        HashNode<K, V> node = chainArray[chainIndex], target = null;

        while(node != null){
            if(node.key.equals(key)) break;
            target = node;
            node = node.next;
        }

        if(node == null) return null;

        if(target != null){
            target.next = node.next;
        } else {

        }
    }

    public boolean contains(V value) {}

    public K getKey(V value) {}

}
