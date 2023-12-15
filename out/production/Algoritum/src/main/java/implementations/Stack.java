package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements AbstractStack<E> {

    private Node<E> top;
    private int size;

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E element) {
            this.value = element;
        }
    }

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> pushElement = new Node<>(element);

        pushElement.next = this.top;
        this.top = pushElement;
        this.size++;
    }

    @Override
    public E pop() {
        ensureNotEmpty();
        Node<E> tmp = this.top;
        this.size--;
        this.top = tmp.next;
        return tmp.value;
    }

    @Override
    public E peek() {
        ensureNotEmpty();
        return this.top.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

//    @Override
//    public Iterator<E> iterator() {
//        return new Iterator<E>() {
//            private Node<E> current = top;
//
//            @Override
//            public boolean hasNext() {
//                return this.current != null;
//            }
//
//            @Override
//            public E next() {
//                E value = this.current.value;
//                return this.current = this.current.next;
//                return value;
//            }
//        };
//    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }
}
