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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midPrev = middleNode(head);
        ListNode mid = midPrev.next;
        midPrev.next = null; // Break the list

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }

// q21 merge two sorted lists 
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                tail.next = temp1;
                temp1 = temp1.next;
            }else{
                tail.next = temp2;
                temp2 = temp2.next;
            }
            tail = tail.next;
            
        }

        tail.next = (temp1 != null) ? temp1 : temp2;
        return dummy.next;
    }

    // q876 middleof ll;

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev; // Node before midpoint
    }

}