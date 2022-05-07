public class MyHashTable<K, V> {

    private class HashNode<K, V> {

        public K key;
        public V value;
        public HashNode <K, V> next;

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

    public MyHashTable() {}

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
        /*
        int bucketIndex = hash(key) % M < 0 index * (-1) : index;
        int hashCode = hash(key);
        HashNode<K, V> node = chainArray[bucketIndex];

        while(node != null){
            if(node.key.equals(key)) {

            }
        }
          */
    }

    public V get(K key) {
        /*
        int bucketIndex = hash(key) % M < 0 index * (-1) : index;
        int hashCode = hash(key);
        HashNode<K, V> node = chainArray[bucketIndex];

        while(node != null) {
            if(head.key.equals(key) && node.)
        }

         */
    }

    public V remove(K key) {
        int bucketIndex = hash(key) % M < 0 index * (-1) : index;
        int hashCode = hash(key);

        HashNode<K, V> node = chainArray[bucketIndex], target = null;

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
