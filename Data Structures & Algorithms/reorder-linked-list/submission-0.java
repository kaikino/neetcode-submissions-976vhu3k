/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return; // 0, 1, or 2 nodes already reordered
        }

        // STEP 1: Find the middle of the list
        // 'slow' will be the end of the first half.
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 'mid' is the head of the second half
        ListNode mid = slow.next;
        // Terminate the first half of the list
        slow.next = null;

        // STEP 2: Reverse the second half
        ListNode prev = null;
        ListNode current = mid;
        while (current != null) {
            ListNode next_node = current.next;
            current.next = prev;
            prev = current;
            current = next_node;
        }
        // 'reversed_second_half' is the new head of the reversed second half (L_n)
        ListNode reversed_second_half = prev;

        // STEP 3: Merge the two halves
        ListNode p1 = head; // Start of the first half (L_0)
        ListNode p2 = reversed_second_half; // Start of the reversed second half (L_n)

        while (p2 != null) {
            // Store next nodes for both pointers
            ListNode p1_next = p1.next;
            ListNode p2_next = p2.next;

            // Interleave: p1 -> p2
            p1.next = p2;
            
            // Connect p2 to the rest of p1's original list
            p2.next = p1_next;

            // Move pointers forward
            p1 = p1_next;
            p2 = p2_next;
        }
    }
}