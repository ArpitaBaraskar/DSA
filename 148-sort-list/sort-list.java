class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = getMiddle(head);
        ListNode right = mid.next;
        mid.next = null;   // break into two halves

        ListNode leftSort = sortList(head);
        ListNode rightSort = sortList(right);

        return merge(leftSort, rightSort);
    }

    public ListNode getMiddle(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){   // ascending
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null) curr.next = l1;
        if(l2 != null) curr.next = l2;

        return dummy.next;
    }
}
