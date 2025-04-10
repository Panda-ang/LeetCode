package leetcode.module.divideconque;

public class ListNode {
    int val;
    ListNode next;

    // 无参构造方法
    ListNode() {
    }

    // 只初始化 val 的构造方法
    ListNode(int val) {
        this.val = val;
        this.next = null;  // 默认为 null
    }

    // 初始化 val 和 next 的构造方法
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
