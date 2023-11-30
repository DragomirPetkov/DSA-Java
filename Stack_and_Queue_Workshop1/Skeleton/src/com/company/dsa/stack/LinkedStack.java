package com.company.dsa.stack;

import com.company.dsa.Node;
import java.util.NoSuchElementException;


public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    @Override
    public void push(E element) {
        Node<E> newNode = new Node();
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            throw  new NoSuchElementException();
        }
        E element = top.data;
        top = top.next;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return top.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
