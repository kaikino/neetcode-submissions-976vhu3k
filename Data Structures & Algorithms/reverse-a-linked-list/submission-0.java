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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode out = new ListNode(head.val);
        ListNode nexthead;
        head = head.next;
        while (head != null) {
            nexthead = head.next;
            head.next = out;
            out = head;
            head = nexthead;
        }
        return out;
    }
}
