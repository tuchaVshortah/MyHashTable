public class Main {
    public static void main(String[] args) {
        BST<Integer, String> temp = new BST<>();

        System.out.println("Add elements to the tree\n");

        temp.put(1, "1");
        temp.put(0, "0");
        temp.put(-2, "-2");
        temp.put(-1, "-1");
        temp.put(2, "2");

        System.out.println("Show elements in the tree\n");

        System.out.println(temp.get(1));
        System.out.println(temp.get(0));
        System.out.println(temp.get(-2));
        System.out.println(temp.get(-1));
        System.out.println(temp.get(2));

        System.out.println("Printing keys from the BST iterable\n");
        for(Integer key: temp.iterator()){
            System.out.println(key);
        }

        System.out.println("Delete a few elements from the tree\n");

        temp.delete(1);
        temp.delete(0);
        temp.delete(-2);
        temp.delete(-1);
        temp.delete(2);

        System.out.println("Show the updated tree\n");

        System.out.println(temp.get(1));
        System.out.println(temp.get(0));
        System.out.println(temp.get(-2));
        System.out.println(temp.get(-1));
        System.out.println(temp.get(2));

    }
}
