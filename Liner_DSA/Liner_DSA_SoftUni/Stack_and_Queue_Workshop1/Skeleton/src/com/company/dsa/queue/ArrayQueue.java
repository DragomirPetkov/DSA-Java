package com.company.dsa.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

    private static final int INITIAL_SIZE = 5;
    private E[] items;
    private int head, tail, size;
    private int capacity;

    public ArrayQueue(){
        size = 0;
        head = -1;
        tail = -1;
        items = (E[]) new Object[INITIAL_SIZE];
        this.capacity = INITIAL_SIZE;
    }

    @Override
    public void enqueue(E element) {
        tail++;
        if (this.tail == this.capacity){
            resizeItems();
        }
        this.size++;
        items[this.tail] = element;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        head++;
        this.size--;
        E element = this.items[this.head];
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.items[this.head + 1];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    private void resizeItems(){
        this.capacity *= 2;
        Object[] tmp = new Object[this.capacity];

        for (int i = 0; i < this.items.length; i++){
            tmp[i] = this.items[i];
        }
        this.items = (E[]) tmp;
    }

}
