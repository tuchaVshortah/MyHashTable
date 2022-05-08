import java.util.*;

public class BST<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left = null, right = null;
        public Node(K key, V val) {
            this.key = key;
            this.value = val;
        }
    }

    public void put(K key, V val) {
        Node tempRoot = root;

        /*
        if(root == null || root.key.compareTo(node.key) == 0){
            root = node;
            return;
        }

        tempRoot = root;
        while(tempRoot.key.compareTo(node.key) == 1){
            if(tempRoot.left != null){
                tempRoot = tempRoot.left;
            }else{
                tempRoot.left = node;
                return;
            }
        }

        tempRoot = root;
        while(tempRoot.key.compareTo(node.key) == -1){
            if(tempRoot.right != null){
                tempRoot = tempRoot.right;
            }else{
                tempRoot.right = node;
                return;
            }
        }

         */

        tempRoot = root;
        while(true){
            if(tempRoot == null){
                tempRoot = new Node(key, val);
            }else if(tempRoot.key.compareTo(key) == 1){
                tempRoot = tempRoot.left;
            }else if(tempRoot.key.compareTo(key) == -1){
                tempRoot = tempRoot.right;
            }else if(tempRoot.key.compareTo(key) == 0){
                tempRoot.value = val;
            }
        }
    }

    public V get(K key) {
        Node tempRoot = root;
        while(true){
            if(tempRoot == null){
                return null;
            }else if(tempRoot.key.compareTo(key) == 1){
                tempRoot = tempRoot.left;
            }else if(tempRoot.key.compareTo(key) == -1){
                tempRoot = tempRoot.right;
            }else if(tempRoot.key.compareTo(key) == 0){
                return tempRoot.value;
            }
        }
    }

    public void delete(K key) {
        Node tempRoot = root;
        while(true){
            if(tempRoot == null){
                return;
            }else if(tempRoot.key.compareTo(key) == 1){
                tempRoot = tempRoot.left;
            }else if(tempRoot.key.compareTo(key) == -1){
                tempRoot = tempRoot.right;
            }else if(tempRoot.key.compareTo(key) == 0){
                if(tempRoot.left == null){
                    tempRoot = tempRoot.right;
                }else if(tempRoot.right == null){
                    tempRoot = tempRoot.left;
                }else if(tempRoot.left == null && tempRoot.right == null){
                    tempRoot = null;
                }else if(tempRoot.left != null && tempRoot.right != null){
                    Node successor = tempRoot.right;
                    while(successor.left != null){
                        successor = successor.left;
                    }
                    successor.left = tempRoot.left;
                    tempRoot = successor;
                }
            }
        }
    }

    public Iterable<K> iterator() {
        Node tempRoot = root;
        List<K> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(tempRoot != null){
            stack.push(tempRoot);
            tempRoot = tempRoot.left;
        }

        while(!stack.isEmpty()){
            tempRoot = stack.pop();
            list.add(tempRoot.left.key);
            if(tempRoot.right != null){
                tempRoot = tempRoot.right;
                stack.push(tempRoot);
                while(tempRoot.left != null){
                    tempRoot = tempRoot.left;
                    stack.push(tempRoot);
                }
            }
        }
        return list;
    }

}
