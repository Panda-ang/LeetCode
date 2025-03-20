package leetcode.module.eightlinklist;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;//统计链表的长度
        for (ListNode cur = head; cur != null; cur = cur.next){
            n++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;

        for (; n >= k; n -= k){
            for (int i = 0; i < k; i++){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }
}
