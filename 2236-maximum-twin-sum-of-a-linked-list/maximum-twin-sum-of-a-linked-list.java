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
    public int pairSum(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while(head != null){
            values.add(head.val);
            head = head.next;
        }
        int MaxSum = 0;
        int left = 0, right = values.size()-1;

        while(left < right){
           MaxSum = Math.max(MaxSum, values.get(left) + values.get(right));
            left++;
            right--;
        }
        return MaxSum;
    }
}