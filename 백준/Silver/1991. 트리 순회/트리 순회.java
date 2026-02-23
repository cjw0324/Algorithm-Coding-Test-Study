import java.io.*;
import java.util.*;


public class Main {
    static Node root;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }

    public static void init(char data, char left, char right) {
        if (data == 'A') {
            root = new Node(data);
            if (left != '.') {
                root.left = new Node(left);
            }
            if (right != '.') {
                root.right = new Node(right);
            }
        } else {
            search(root, data, left, right);
        }
    }

    public static void search(Node node, char data, char left, char right) {
        if (node == null) return;
        if (node.data == data) {
            if (left != '.') {
                node.left = new Node(left);
            }
            if (right != '.') {
                node.right = new Node(right);
            }
        } else {
            search(node.left, data, left, right);
            search(node.right, data, left, right);
        }
    }

    static void preOrder(Node node) {
        if (node == null) return;

        sb.append(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        sb.append(node.data);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.data);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            init(line[0], line[2], line[4]);
        }

        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);

        System.out.println(sb.toString().trim());
    }
}