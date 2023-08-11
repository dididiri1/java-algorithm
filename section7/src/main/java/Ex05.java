import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node (int val) {
        data = val;
        lt = rt = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", lt=" + lt +
                ", rt=" + rt +
                '}';
    }
}

public class Ex05 {

    Node root;

    public void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.println("x= "+root.data); // 전위
            DFS(root.lt);
            //System.out.println(root.data); // 중위
            DFS(root.rt);
            //System.out.println(root.data); // 후위
        }
    }

    public static void main(String[] args) {
        Ex05 tree = new Ex05();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);

        System.out.println(tree.root.toString());
    }
}