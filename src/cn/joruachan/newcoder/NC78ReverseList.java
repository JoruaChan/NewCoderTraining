package cn.joruachan.newcoder;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * <p>
 * 示例1
 * 输入: {1,2,3}
 * 返回值: {3,2,1}
 *
 * @author JoruaChan
 * @date 2021-04-19 下午11:50
 * @grade 简单
 */
public class NC78ReverseList {
    // 我的思路：第一反应，就是栈啊？写完发现过不了，时间过长？？？
    // 查看题解，很多人都是直接用个指针；
    // 所以：先看问题能不能简单解决，不能再考虑使用数据结构。

    /*
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
     */

    /**
     * 通过几个指针解决，其实就是把一个元素的前后都先获取到，再移动指针循环到结束
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

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
