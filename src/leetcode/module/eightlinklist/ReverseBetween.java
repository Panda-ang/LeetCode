package leetcode.module.eightlinklist;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;

        for (int i = 0; i < left - 1; i++){
            p0 = p0.next;
        }

        ListNode pre = null;
        ListNode cur = p0.next;

        for (int i = 0; i < right - left + 1; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        p0.next.next = cur;
        p0.next = pre;

        return dummy.next;
    }
}
