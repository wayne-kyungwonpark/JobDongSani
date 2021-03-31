package algorithm.leetcode.hard;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _23_MergedKSortedLists {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode empty = new ListNode();

        if(lists == null || lists.length == 0 || (lists.length == 1 && lists[0] == null)){
            return null;
        }

        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val){
                    return -1;
                }else if(o1.val > o2.val){
                    return 1;
                }
                return 0;
            }
        };

        PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                queue.offer(lists[i]);
            }
        }

        if(queue.size() == 0){
            return null;
        }

        ListNode tmp = empty;

        while(!queue.isEmpty()){
            tmp.next = queue.poll();
            tmp = tmp.next;

            if(tmp.next != null){
                queue.offer(tmp.next);
            }
        }
        return empty.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
