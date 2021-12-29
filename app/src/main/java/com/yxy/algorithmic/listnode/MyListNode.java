package com.yxy.algorithmic.listnode;

public class MyListNode {
    //剑指06
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        //  获得链表长度的一个通用的方法
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        //  获得链表长度的一个通用的方法
        int[] res = new int[len];
        ListNode cur2 = head;
        while (cur2 != null) {
            res[--len] = cur2.val;
            cur2 = cur2.next;
        }
        return res;
    }

    //剑指09
}
