public class Main {
    public static void main(String[] args) {

        System.out.println("------Tests for BST implementation------\n");

        BST<Integer, String> bst = new BST<>();

        System.out.println("Add elements to the tree\n");

        bst.put(1, "1");
        bst.put(0, "0");
        bst.put(-2, "-2");
        bst.put(-1, "-1");
        bst.put(2, "2");

        System.out.println("Show values in the tree\n");

        System.out.println(bst.get(1));
        System.out.println(bst.get(0));
        System.out.println(bst.get(-2));
        System.out.println(bst.get(-1));
        System.out.println(bst.get(2));

        System.out.println("Printing keys from BST iterable\n");
        for(Integer key: bst.iterator()){
            System.out.println(key);
        }

        System.out.println("Delete a few elements from the tree\n");

        bst.delete(1);
        bst.delete(0);
        bst.delete(-2);
        bst.delete(-1);
        bst.delete(2);

        System.out.println("Show the updated tree\n");

        System.out.println(bst.get(1));
        System.out.println(bst.get(0));
        System.out.println(bst.get(-2));
        System.out.println(bst.get(-1));
        System.out.println(bst.get(2));

        System.out.println("-----------------DONE-----------------\n");

        System.out.println("------Tests for the HashTable implementation------\n");

        MyHashTable<Integer, String> hashTable = new MyHashTable<>();

        System.out.println("Add elements to hashtable\n");

        hashTable.put(1, "one");
        hashTable.put(2, "two");
        hashTable.put(3, "three");
        hashTable.put(4, "four");
        hashTable.put(5, "five");

        System.out.println("Show values in hashtable\n");

        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(3));
        System.out.println(hashTable.get(4));
        System.out.println(hashTable.get(5));

        System.out.println("Show keys in hashtable\n");

        System.out.println(hashTable.getKey("one"));
        System.out.println(hashTable.getKey("two"));
        System.out.println(hashTable.getKey("three"));
        System.out.println(hashTable.getKey("four"));
        System.out.println(hashTable.getKey("five"));

        System.out.println("Delete keys from hashtable\n");

        System.out.println(hashTable.remove(1));
        System.out.println(hashTable.remove(2));
        System.out.println(hashTable.remove(3));
        System.out.println(hashTable.remove(4));
        System.out.println(hashTable.remove(5));

        System.out.println("Check if hashtable contains values\n");

        System.out.println(hashTable.contains("one"));
        System.out.println(hashTable.contains("two"));
        System.out.println(hashTable.contains("three"));
        System.out.println(hashTable.contains("four"));
        System.out.println(hashTable.contains("five"));

        System.out.println("-----------------DONE-----------------\n");
    }
}
