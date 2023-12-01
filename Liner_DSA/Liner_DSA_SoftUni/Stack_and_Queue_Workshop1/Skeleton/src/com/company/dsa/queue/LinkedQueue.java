package com.company.dsa.queue;

import com.company.dsa.Node;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head, tail;
    private int size;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueue(E element) {
        Node<E> toInsertElement = new Node<>(element);
        if (this.head == null) {
            this.head = toInsertElement;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = toInsertElement;
        }
        this.size++;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = this.head.data;
        this.head.data = element;

        if (this.head == null) {
            this.tail = null;
        }
        this.size--;
        return element;
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
