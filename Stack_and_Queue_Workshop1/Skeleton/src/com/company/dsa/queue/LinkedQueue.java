package com.company.dsa.queue;

import com.company.dsa.Node;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head, tail;
    private int size;

    @Override
    public void enqueue(E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E dequeue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E peek() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }
}
