package com.company.dsa.stack;

import com.company.dsa.Node;

import java.util.NoSuchElementException;


public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node(element);
        newNode.next = this.top;
        this.top = newNode;
        size++;
    }

    @Override
    public E pop() {
        ensureNotEmpty();
        E element = this.top.data;
        this.top = this.top.next;
        return element;
    }

    @Override
    public E peek() {
        ensureNotEmpty();
        return this.top.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }
}
