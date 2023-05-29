package leet_code.linked_list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        return reverseRecursively(null, head);
    }

    /**
     * Idea is split the linked list in half and on the fly and update the connection
     * @param prev
     * @param current
     * @return
     */
    public ListNode reverseRecursively(ListNode prev, ListNode current) {
        if (current.next == null) {
            current.next = prev;
            return current;
        }

        ListNode newHead = current.next;
        current.next = prev;

        return reverseRecursively(current, newHead);
    }

    public ListNode reverseUsingIteration(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
