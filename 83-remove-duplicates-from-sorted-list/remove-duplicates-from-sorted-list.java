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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null) return null;
        ListNode temp = head;
        ListNode temp1 = head.next;

        while(temp1 != null){
            if(temp.val == temp1.val){
                temp1 = temp1.next;
            }else{
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            }
            
        }
        temp.next = null;
        return head;
    }
}