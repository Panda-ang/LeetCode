package leetcode.module.divideconque;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a , b) -> a.val - b.val);

        for (ListNode head : lists){
            if (head != null){
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            if (node.next != null){
                pq.add(node.next);
            }

            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }
}
