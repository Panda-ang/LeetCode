package leetcode.module.eightlinklist;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode largerHead = new ListNode();

        ListNode smailTail = smallHead;
        ListNode largerTail = largerHead;

        while (head != null){
            if(head.val < x){
                smailTail.next = head;
                smailTail = smailTail.next;
            }else {
                largerTail.next = head;
                largerTail = largerTail.next;
            }
            head = head.next;
        }

        smailTail.next = largerHead.next;
        largerTail.next = null;
        return smallHead.next;
    }
}
