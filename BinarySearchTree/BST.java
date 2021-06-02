package BinarySearchTree;
/*
Only for constructing BSTs where each node has a unique value
*/
public class BST {
    private static class Node {
        private int data;
        private Node left, right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // private static class wrapper {
    //     int val;
    //     wrapper() {
    //         this.val = 0;
    //     }
    // }

    private Node root;

    public BST() {
        root = null;
    }

    public void insert(int data) {
        if (root == null) {
            root = insertNode(root, data);
            return;
        }
        insertNode(root, data);
    }

    public Node getRoot() {
        return this.root;
    }

    private Node insertNode(Node node, int data) {
        if (node == null)
            return new Node(data);
        if (data < node.data)
            node.left = insertNode(node.left, data);
        else node.right = insertNode(node.right, data);
        return node;
    }
}
