package data_structures.linked_list;

public class Node<T> {
    public T data;
    public Node prev;
    public Node next;

    public Node(T data) {
        this.data = data;
    }
}
