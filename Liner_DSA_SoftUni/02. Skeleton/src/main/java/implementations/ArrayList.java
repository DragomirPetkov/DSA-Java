package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final int INITIAL_VALUE = 4;
    private Object[] elements;
    private int size;

    public ArrayList(){
        this.elements = new Object[INITIAL_VALUE];
        this.size = 0;
    }

    @Override
    public boolean add(E element) {
        if (notEnoughtCapacity){
            resize();
        }

        this.elements[this.size++] = element;

        return true;
    }

    @Override
    public boolean add(int index, E element) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
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
