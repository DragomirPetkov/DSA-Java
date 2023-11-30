package com.company.dsa.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    private static final int INITIAL_SIZE = 5;
    private E[] items;
    private int top;

    public ArrayStack(){
        this.items =  (E[]) new Object[INITIAL_SIZE];
        this.top = -1;
    }

    @Override
    public void push(E element) {
        top++;
        if (top == items.length){
            resizeItems();
        }
        items[top] = element;

    }

    @Override
    public E pop() {
       if (!isEmpty()){
           return items[top--];
       }
       throw new NoSuchElementException();
    }

    @Override
    public E peek() {
       if (!isEmpty()){
           return items[top];
       }
       throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == - 1;
    }

    private void resizeItems(){
        items = Arrays.copyOf(items,items.length * 2);
    }

}
