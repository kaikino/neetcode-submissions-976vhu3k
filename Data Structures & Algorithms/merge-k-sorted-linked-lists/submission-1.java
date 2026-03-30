/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge2(Arrays.copyOfRange(lists, 0, lists.length/2), Arrays.copyOfRange(lists, lists.length/2, lists.length))[0];
    }

    ListNode[] merge2(ListNode[] l1, ListNode[] l2) {
        System.out.println(1);
        if (l1.length == 0) {
            return l2;
        }
        if (l2.length == 0) {
            return l1;
        }
        if (l1.length == 1 && l2.length == 1) {
            
            System.out.println(1);
            ListNode n1 = l1[0];
            ListNode n2 = l2[0];
            ListNode head = new ListNode();
            ListNode cur = head;
            while (n1 != null) {
                if (n2 == null) {
                    cur.next = n1;
                    ListNode[] out = {head.next};
                    return out;
                }
                if (n1.val < n2.val) {
                    cur.next = n1;
                    n1 = n1.next;
                } else {
                    cur.next = n2;
                    n2 = n2.next;
                }
                cur = cur.next;
            }
            if (n1 == null) {
                cur.next = n2;
            }
            ListNode[] out = {head.next};
            return out;
        }
        return merge2(merge2(Arrays.copyOfRange(l1, 0, l1.length/2), Arrays.copyOfRange(l1, l1.length/2, l1.length)),
                      merge2(Arrays.copyOfRange(l2, 0, l2.length/2), Arrays.copyOfRange(l2, l2.length/2, l2.length)));
    }
}
