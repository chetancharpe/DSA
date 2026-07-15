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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;

        
        int position = 1;

        while (position < left) {
            previous = current;
            current = current.next;
            position++;
        }

        
        ListNode connection = previous;
        ListNode tail = current;

        for (int i = 0; i < right - left + 1; i++) {

            ListNode next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }
        if (connection != null) {
            connection.next = previous;
        } else {
            head = previous;
        }
        tail.next = current;

        return head;
    }
}