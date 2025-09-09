class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Handle k larger than length
        k = k % length;
        if (k == 0) return head;

        // Step 3: Make circular
        tail.next = head;

        // Step 4: Find new tail = (length - k - 1) steps from head
        int stepsToNewTail = length - k - 1;
        ListNode newTail = head;
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // Step 5: Break circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
