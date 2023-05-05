package leet_code.linked_list;

import java.util.List;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsIteration(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode newHead = new ListNode(0);
        ListNode current = newHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }

        return newHead.next;

    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(new int[]{1, 2, 4});
        LinkedList l2 = new LinkedList(new int[]{1, 3, 4});

        MergeTwoSortedLists sol = new MergeTwoSortedLists();
        sol.mergeTwoLists(l1.getHead(), l2.getHead());
    }
}
