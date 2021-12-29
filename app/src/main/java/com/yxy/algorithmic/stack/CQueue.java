package com.yxy.algorithmic.stack;

import java.util.Deque;
import java.util.LinkedList;

//剑指09 用两个栈实现队列
public class CQueue {
    Deque<Integer> stack1;//只负责入栈
    Deque<Integer> stack2;//只负责出栈

    public CQueue() {
        stack1 = new LinkedList<>();//注意一下栈的实现和常用的API
        stack2 = new LinkedList<>();//通过LinkedList去实现栈，效率比stack高，官方推荐
    }

    public void appendTail(int val) {
        stack1.push(val);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {//注意之类得等stack2的空了，才能从stack1中取值，毕竟按照
            //先进先出原则，stack2中已经存在的元素是先进来的
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}
