package com.joruachan.newcoder;

import java.util.Stack;


/**
 * [文件说明]
 *
 * @author JoruaChan
 * @date 2021-04-19 下午11:50
 */
public class NC78ReverseList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack();

        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        head = node = stack.pop();
        while (!stack.empty()) {
            node = node.next = stack.pop();
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(11);
        ListNode node3 = new ListNode(14);
        ListNode node4 = new ListNode(20);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(new NC78ReverseList().reverseList(node1));
    }
}
