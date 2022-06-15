package data_structures.linked_list;

public class DoubleLinkedList<T> {
    protected Node<T> head;
    protected Node<T> tail;
    protected int size;

    /**
     * Add item at the end of the list
     *
     * @param data
     */
    public void addNode(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;

            tail = newNode;
        }

        this.size++;
    }

    public void addNode(T data, int index) {
        Node newNode = new Node(data);
        Node start = head;
        int counter = 0;

        while (start.next != null) {

            if (index == counter) {

            }
        }
    }

    public void removeNode(Node<T> node) {
        node.prev.next = node.next;
    }

    public void printList() {
        Node node = head;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        System.out.println();
    }

    public int length() {
        return this.size;
    }
}
