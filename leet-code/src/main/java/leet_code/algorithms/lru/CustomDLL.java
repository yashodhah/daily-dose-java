package leet_code.algorithms.lru;

import data_structures.linked_list.DoubleLinkedList;
import data_structures.linked_list.Node;

public class CustomDLL<T> extends DoubleLinkedList<T> {
    public void addToHead(Node<T> node) {
        if (head == null) {
            head = tail = node;
        }

        node.next = head;
        head.prev = node;
        head = node;

        this.size++;
    }

    public void moveToHead(Node<T> node) {
        if (node != head) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            if (node == tail) {
                tail = node.prev;
            }

            node.next = head;
            head.prev = node;

            head = node;
        }
    }
}
