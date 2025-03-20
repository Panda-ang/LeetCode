package leetcode.module.eightlinklist;

public class RotateRight {
    public static void main(String[] args) {

    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }
        int n = 0;
        ListNode tail = head;
        for(; tail != null; tail = tail.next){
            n++;
        }

        k = n % k;
        if (k == 0) return head;

        tail.next = head;

        ListNode newTail = head;
        for (int i = 1; i < n - k; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
