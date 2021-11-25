package com.hbo.linkedlist;

public class Code_13_LinkedListBases {

    public static ListNode removeElement(ListNode head, int val){
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null){
            if((Integer)cur.value == val){
                pre.next = cur.next;
            }else {
              pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }



}
