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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        ListNode f = list1;
        ListNode s = list2;

        while (f != null && s != null) {
            if (f.val < s.val) {
                tail.next = new ListNode(f.val);
                f = f.next;
            } else {
                tail.next = new ListNode(s.val);
                s = s.next;
            }
            tail = tail.next;
        }

        while (f != null) {
            tail.next = new ListNode(f.val);
            tail = tail.next;
            f = f.next;
        }

        while (s != null) {
            tail.next = new ListNode(s.val);
            tail = tail.next;
            s = s.next;
        }

        return dummy.next;
    }
}