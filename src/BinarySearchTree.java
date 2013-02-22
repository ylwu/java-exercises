import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;


public class BinarySearchTree {
    Node root;
    static List<Node> inOrderList = new ArrayList<Node> ();

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public static List<Node> inOrderTraversal(Node node){
        inOrderTraversal(node.left);
        inOrderList.add(node);
        inOrderTraversal(node.left);
        return inOrderList;
    }
    
    public static Node successor (Node x){
        if (x.right != null){
            return Tree-minimum(x.right);
        }
        Node y = x.parent;
        while (y != null && x == y.right){
            x = y;
            y = y.parent;
        }
        return y;
    }
    
    static class Node<T> {
        Node<T> right;
        Node<T> left;
        Node<T> parent;
        T key;    
    }

}
