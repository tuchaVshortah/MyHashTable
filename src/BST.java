public class BST<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.value = val;
        }
    }

    public void put(K key, V val) {}

    public V get(K key) {
        return null;
    }

    public void delete(K key) {}

    public Iterable<K> iterator() {
        return null;
    }

}
