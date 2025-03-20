package leetcode.module.eightlinklist;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null){
            int val = cur.next.val;
            if(val == cur.next.next.val){
                while (cur.next != null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
