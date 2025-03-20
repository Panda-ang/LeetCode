package leetcode.module.eightlinklist;

public class PrintList {
    // 辅助方法，用于打印链表
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
