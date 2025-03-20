package leetcode.module.eightlinklist;

public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode right = dummy;
        ListNode left = dummy;

        for(int i = 0; i < n; i++){
            right = right.next;
        }

        while (right.next != null){
            left = left.next;
            right = right.next;
        }

        left.next =left.next.next;
        return dummy.next;

    }
}
