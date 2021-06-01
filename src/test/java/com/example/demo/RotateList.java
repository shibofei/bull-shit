package com.example.demo;

import java.util.concurrent.ThreadPoolExecutor;

public class RotateList {
    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node head = new Node(1, node2);

        Node rHead = Rotate(head);
    }

    public static Node Rotate(Node head) {
        Node dummy = null;
        while (head != null) {
            Node next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
}
