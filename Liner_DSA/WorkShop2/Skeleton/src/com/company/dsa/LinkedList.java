package com.company.dsa;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    public LinkedList() {
    }

    public LinkedList(Iterable<T> iterable) {
        iterable.forEach(this::addLast);
    }

    @Override
    public void addFirst(T value) {
        Node newNode = new Node(value);

        if (this.head == null) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(T value) {
        Node newNode = new Node(value);
        if (this.size == 0) {
            addFirst(value);
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
            this.size++;
        }

    }

    @Override
    public void add(int index, T value) {
        ensureIndex(index);

        if (index == 0){
            addFirst(value);
        } else if (index == this.size) {
            addLast(value);
        }else {
            Node newNode = new Node(value);
            Node current = this.head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;

            this.size++;
        }


    }

    @Override
    public T getFirst() {
        ensureNotEmpty();

        return this.head.value;
    }

    @Override
    public T getLast() {
        ensureNotEmpty();

        return this.tail.value;
    }

    @Override
    public T get(int index) {
        ensureIndex(index);
        Node current = this.head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int indexOf(T value) {
        int index = 0;

        Node current = this.head;

        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public T removeFirst() {
        ensureNotEmpty();

        T elementRemove = this.head.value;

        if (this.head == this.tail){
            this.head = this.tail = null;
        }else{
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return elementRemove;

    }

    @Override
    public T removeLast() {
        ensureNotEmpty();
        if (this.tail == this.head) {
            return removeFirst();
        }

        T elementRemove = this.tail.value;

        this.tail = this.tail.prev;
        this.tail.next = null;

        this.size--;
        return elementRemove;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T element = current.value;
                current = current.next;
                return element;
            }
        };
    }

    public void ensureNotEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
    }

    public void ensureIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new NoSuchElementException();
        }
    }

    private class Node {
        T value;
        Node prev;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }
}
