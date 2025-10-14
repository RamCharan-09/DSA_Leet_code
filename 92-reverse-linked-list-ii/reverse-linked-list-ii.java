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
        if(left == right){
            return head;
        }
        // skipping first left-1 nodes
        ListNode curr = head;
        ListNode rear = null;

        for(int i = 0;curr != null && i < left -1; i++){
            rear = curr;
            curr = curr.next;
        }

        ListNode last = rear;
        ListNode newEnd = curr;

        ListNode front = curr.next;
        for(int i = 0; curr != null && i < right-left+1; i++){
            curr.next = rear;
            rear = curr;
            curr = front;
            if(front != null){
                front = front.next;
            }
        }
        
        if(last != null){
            last.next = rear;
        }else{
            head = rear;
        }
        newEnd.next = curr;
        return head;
    }
}