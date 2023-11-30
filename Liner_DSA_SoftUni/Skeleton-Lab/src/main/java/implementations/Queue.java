package implementations;

import com.company.dsa.Node;
import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {

    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E value){
            this.element = value;
        }
    }

    @Override
    public void offer(E element) {

    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
