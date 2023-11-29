package com.company.dsa.stack;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class ArrayStack<E> implements Stack<E> {
    private E[] items;
    private int top;

    @Override
    public void push(E element) {
        items[++top] = element;

    }

    @Override
    public E pop() {
        E element = items[top];
        items[--top] = null;
        return element;
    }

    @Override
    public E peek() {
        return items[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == items.length - 1;
    }

}
