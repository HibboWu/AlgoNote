package com.hbo.linkedlist;

public class ListNode<V> {
    V value;
    ListNode next;

    public ListNode(V value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
