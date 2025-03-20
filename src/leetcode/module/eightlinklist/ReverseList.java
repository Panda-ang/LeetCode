package leetcode.module.eightlinklist;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null; //反转后的链表要指向null
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = pre;

        }
        return pre;
    }
}
