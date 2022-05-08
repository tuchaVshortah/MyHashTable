import java.util.*;

public class BST<K extends Comparable<K>, V> {

    private Node root = null;

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

        if(root == null){
            root = new Node(key, val);
            return;
        }
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

        while(true){
            if(tempRoot.key.compareTo(key) > 0 && tempRoot.left == null){
                tempRoot.left = new Node(key, val);
                tempRoot = tempRoot.left;
                break;
            }else if(tempRoot.key.compareTo(key) > 0 && tempRoot.left != null){
                tempRoot = tempRoot.left;
            }else if(tempRoot.key.compareTo(key) < 0 && tempRoot.right == null){
                tempRoot.right = new Node(key, val);
                tempRoot = tempRoot.right;
                break;
            }else if(tempRoot.key.compareTo(key) < 0 && tempRoot.right != null){
                tempRoot = tempRoot.right;
            }else if(tempRoot.key.compareTo(key) == 0){
                tempRoot.value = val;
                break;
            }
        }
        System.out.println("put (K, V): " + key + " " + val);
    }

    public V get(K key) {
        Node tempRoot = root;
        while(true){
            if(tempRoot == null){
                return null;
            }else if(tempRoot.key.compareTo(key) > 0){
                tempRoot = tempRoot.left;
            }else if(tempRoot.key.compareTo(key) < 0){
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
            }else if(tempRoot.key.compareTo(key) > 0){
                tempRoot = tempRoot.left;
            }else if(tempRoot.key.compareTo(key) < 0){
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
        while(tempRoot != null){
            stack.push(tempRoot);
            tempRoot = tempRoot.left;
        }

        while(!stack.isEmpty()){
            tempRoot = stack.pop();
            if(tempRoot.left != null){
                list.add(tempRoot.left.key);
                System.out.println("DEBUG: " + tempRoot.left.key);
            }

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
