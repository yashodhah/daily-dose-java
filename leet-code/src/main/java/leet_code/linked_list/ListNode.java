package leet_code.linked_list;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    private ListNode head;

    public LinkedList() {
        head = null;
    }

    public LinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }

        this.head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
    }


    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int val) {
        head = new ListNode(val, head);
    }

    public void addLast(int val) {
        if (head == null) {
            addFirst(val);
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(val);
        }
    }

    public int size() {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void reverse() {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void add(int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void add(int[] values) {
        for (int val : values) {
            add(val);
        }
    }

    public ListNode getHead() {
        return head;
    }
}

