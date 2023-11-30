package com.company.dsa.queue;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private E[] items;
    private int head, tail, size;

    public ArrayQueue(){
        size = 10;
        head = -1;
        tail = -1;
        items = (E[]) new Object[size];
    }

    @Override
    public void enqueue(E element) {
        tail++;
        tail %=size;
        if (head == tail){
            resizeItems();
        }
        items[tail] = element;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        head++;
        head  %= size;
        E result = items[head];
        return result;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return items[(head + 1) % size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    private void resizeItems(){
        E[] newData = (E[]) new  Object[size * 2];
        for (int i = 0; i < size; i++){
            head++;
            head %= size;

            newData[i] = items[head];
        }
        items = newData;
        head = -1;
        tail = size - 1;
        size*= 2;
    }

}
