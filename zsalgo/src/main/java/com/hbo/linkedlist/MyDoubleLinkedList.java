package com.hbo.linkedlist;

import org.w3c.dom.ls.LSException;

/**
 * @Author: Haibo
 * @Date: 2021/12/7 22:34
 */
public class MyDoubleLinkedList {
    class ListNode{
        int val;
        ListNode next,prev;
        ListNode(int x){
            val = x;
        }
    }

    int size;
    ListNode head,tail; //Sentinel node

    // Initialize the double linked list
    public MyDoubleLinkedList(){
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index){
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;

        // check if index < (size - 1) / 2, traverse from head, else traverse from tail
        if (index < (size - 1) / 2){
            for(int i = 0; i <= index; i++){
                cur = cur.next;
            }
        }else {
            cur = tail;
            for(int i = 0; i <= size - index - 1; i++){
                cur = cur.prev;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val){
        ListNode cur = head;
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
        newNode.prev = cur;
        size++;
    }

    public void addTail(int val){
        ListNode cur = tail;
        ListNode newNode = new ListNode(val);
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;
        size++;
    }

}
