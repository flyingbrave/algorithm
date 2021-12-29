package com.yxy.algorithmic.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public MinStack() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()||stack2.peek()>=x) {//注意这里这个等号。当这里有等号的时候，值也是要加进去
            stack2.push(x);
        }
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek()) ) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
