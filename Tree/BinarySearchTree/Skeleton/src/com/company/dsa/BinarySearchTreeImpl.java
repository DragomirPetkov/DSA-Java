package com.company.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeImpl<E extends Comparable<E>> implements BinarySearchTree<E> {
    private E value;
    private BinarySearchTreeImpl<E> left;
    private BinarySearchTreeImpl<E> right;

    public BinarySearchTreeImpl(E value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public E getRootValue() {
        return value;
    }

    @Override
    public BinarySearchTree<E> getLeftTree() {
        return left;
    }

    @Override
    public BinarySearchTree<E> getRightTree() {
        return right;
    }

    @Override
    public void insert(E value) {
        if (value.compareTo(this.value) < 0) {
            if (left == null) {
                left = new BinarySearchTreeImpl<>(value);
            } else {
                left.insert(value);
            }
        } else if (value.compareTo(this.value) > 0) {
            if (right == null) {
                right = new BinarySearchTreeImpl<>(value);
            } else {
                right.insert(value);
            }
        }
    }

    @Override
    public boolean search(E value) {
        BinarySearchTreeImpl<E> root = this;

        while (root != null){
            if (value.compareTo(root.value) == 0){
                return true;
            }
            if (value.compareTo(root.value) < 0){
                root = root.left;
                if (root != null){
                    continue;
                }
            }else {
                root = root.right;
                if (root != null){
                    continue;
                }
            }
        }

        return false;
    }

    @Override
    public List<E> inOrder() {
        List<E> expected = new ArrayList<>();
        if (left != null) {
            expected.addAll(left.inOrder());
        }
        expected.add(value);
        if (right != null) {
            expected.addAll(right.inOrder());
        }
        return expected;
    }

    @Override
    public List<E> postOrder() {
        List<E> expected = new ArrayList<>();
        if (left != null) {
            expected.addAll(left.postOrder());
        }
        if (right != null) {
            expected.addAll(right.postOrder());
        }
        expected.add(value);
        return expected;
    }

    @Override
    public List<E> preOrder() {
        List<E> result = new ArrayList<>();
        result.add(value);
        if (left != null) {
            result.addAll(left.preOrder());
        }
        if (right != null) {
            result.addAll(right.preOrder());
        }
        return result;
    }

    @Override
    public List<E> bfs() {
        List<E> result = new ArrayList<>();
        Queue<BinarySearchTreeImpl<E>> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()){
            BinarySearchTreeImpl<E> node = queue.poll();
            result.add(node.value);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return result;
    }

    @Override
    public int height() {
       return heightDif(this);
    }

    private int heightDif(BinarySearchTreeImpl<E> root){

        if (root == null){
            return -1;
        }

        int leftH = heightDif(root.left);
        int rightH = heightDif(root.right);

        if (leftH > rightH){
            return leftH + 1;
        }else {
            return rightH + 1;
        }

    }

    // Advanced task: implement remove method. To test, uncomment the commented tests in BinaryTreeImplTests
//    @Override
//    public boolean remove(E value) {
//        throw new UnsupportedOperationException();
//    }
}
