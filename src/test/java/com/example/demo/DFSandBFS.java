package com.example.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSandBFS {
    private static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public static void depth(Node root){
            if(root == null) return;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                Node node = stack.pop();
                System.out.println(node.value);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }

        public static void breadth(Node root) {
            if(root == null) return;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

        public static void main(String[] args) {

        }
}
