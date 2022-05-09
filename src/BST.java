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

        //check if root is null
        //if so, create a new node for root
        //then return
        if(root == null){
            root = new Node(key, val);
            return;
        }

        //otherwise, traverse the tree
        Node tempRoot = root;

        while(true){

            if(tempRoot.key.compareTo(key) > 0 && tempRoot.left != null){

                //if the key value is less than one in a node, traverse to the left

                tempRoot = tempRoot.left;
            }else if(tempRoot.key.compareTo(key) < 0 && tempRoot.right != null){

                //if the key value is bigger than one in a node, traverse to the right

                tempRoot = tempRoot.right;
            }else if(tempRoot.key.compareTo(key) > 0 && tempRoot.left == null){

                //if end of the traversal (to the left) is reached, create a new node
                //containing the key and value pair

                tempRoot.left = new Node(key, val);
                break;
            }else if(tempRoot.key.compareTo(key) < 0 && tempRoot.right == null){

                //if end of the traversal (to the right) is reached, create a new node
                //containing the key and value pair

                tempRoot.right = new Node(key, val);
                break;
            }else if(tempRoot.key.compareTo(key) == 0){

                //if a key was found with the same key value, change the value contained in the target node

                tempRoot.value = val;
                break;
            }
        }
    }

    public V get(K key) {

        //traverse the tree
        Node tempRoot = root;
        while(true){

            if(tempRoot == null){

                //if the key wasn't found return  nothing (null)

                return null;
            }else if(tempRoot.key.compareTo(key) > 0){

                //if the key value is less than one in a node, traverse to the left

                tempRoot = tempRoot.left;
            }else if(tempRoot.key.compareTo(key) < 0){

                //if the key value is bigger than one in a node, traverse to the right

                tempRoot = tempRoot.right;
            }else if(tempRoot.key.compareTo(key) == 0){

                //if the key was found, return corresponding value stored in the target node

                return tempRoot.value;
            }
        }
    }

    public void delete(K key) {

        //traverse the tree
        //while null is reached
        //if there is a null, it means there is nothing to delete, so do nothing

        Node tempRoot = root, prevRoot = tempRoot;
        while(tempRoot != null){

            if(tempRoot.key.compareTo(key) == 0){

                //if target node containing the key was found, find a specific case

                if(tempRoot.left != null && tempRoot.right != null){
                    System.out.println("tempRoot.left != null && tempRoot.right != null case worked with key: " + key);
                    //if children of a node aren't nulls, find minimum element

                    Node minimum = tempRoot.right, prevMin = minimum;
                    while(true){
                        if(minimum.left == null){
                            break;
                        }else{
                            prevMin = minimum;
                            minimum = minimum.left;
                        }
                    }

                    //delete the node: move data stored in minimum in it

                    tempRoot.key = minimum.key;
                    tempRoot.value = minimum.value;

                    //delete minimum
                    if(prevMin.left == null){
                        tempRoot.right = null;
                    }else if(prevMin.left != null){
                        prevMin.left = null;
                    }
                    break;
                }else if(tempRoot.left == null && tempRoot.right != null){
                    System.out.println("tempRoot.left == null && tempRoot.right != null case worked with key: " + key);

                    //if only one of children is not null, move its data and its children to the node

                    if(prevRoot.left == tempRoot){
                        prevRoot.left = tempRoot.right;
                    }else if(prevRoot.right == tempRoot){
                        prevRoot.left = tempRoot.right;
                    }
                    break;
                }else if(tempRoot.left != null && tempRoot.right == null){
                    System.out.println("tempRoot.left != null && tempRoot.right == null case worked with key: " + key);

                    //if only one of children is not null, move its data and its children to the node

                    if(prevRoot.left == tempRoot){
                        prevRoot.left = tempRoot.left;
                    }else if(prevRoot.right == tempRoot){
                        prevRoot.left = tempRoot.left;
                    }
                    break;
                }else if(tempRoot.left == null && tempRoot.right == null){
                    System.out.println("tempRoot.left == null && tempRoot.right == null case worked with key: " + key);

                    //if both children are equal to null, just delete the node

                    if(prevRoot.left == tempRoot){
                        prevRoot.left = null;
                    }else if(prevRoot.right == tempRoot){
                        prevRoot.right = null;
                    }else if(prevRoot == tempRoot && prevRoot == root){
                        root = null;
                    }
                    break;
                }
            }else if(tempRoot.key.compareTo(key) > 0){

                //if the key value is less than one in a node, traverse to the left

                prevRoot = tempRoot;
                tempRoot = tempRoot.left;
            }else if(tempRoot.key.compareTo(key) < 0){

                //if the key value is bigger than one in a node, traverse to the right

                prevRoot = tempRoot;
                tempRoot = tempRoot.right;
            }
        }
    }

    public Iterable<K> iterator() {
        //need fixes
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
