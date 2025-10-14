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
        if(head == null)return head;
        ListNode curr = head;
        ListNode rear = null;
        ListNode front = curr.next;

        while(curr != null){
            curr.next = rear;
            rear = curr;
            curr = front;
            if(front != null){
                front = front.next;
            }
            
        }
        return rear;
    }
}