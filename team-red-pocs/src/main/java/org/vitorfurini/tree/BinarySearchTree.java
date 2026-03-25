package org.vitorfurini.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private BinaryTreeNode<T> insertRecursive(BinaryTreeNode<T> node, T value) {
        if (node == null) {
            return new BinaryTreeNode<>(value);
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insertRecursive(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(insertRecursive(node.getRight(), value));
        }

        return node;
    }

    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(BinaryTreeNode<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (value.equals(node.getValue())) {
            return true;
        }

        return value.compareTo(node.getValue()) < 0
                ? containsRecursive(node.getLeft(), value)
                : containsRecursive(node.getRight(), value);
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private BinaryTreeNode<T> deleteRecursive(BinaryTreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(deleteRecursive(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(deleteRecursive(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setValue(findMin(node.getRight()));
            node.setRight(deleteRecursive(node.getRight(), node.getValue()));
        }

        return node;
    }

    private T findMin(BinaryTreeNode<T> node) {
        return node.getLeft() == null ? node.getValue() : findMin(node.getLeft());
    }

    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderRecursive(root, result);
        return result;
    }

    private void inOrderRecursive(BinaryTreeNode<T> node, List<T> result) {
        if (node != null) {
            inOrderRecursive(node.getLeft(), result);
            result.add(node.getValue());
            inOrderRecursive(node.getRight(), result);
        }
    }

    public List<T> preOrderTraversal() {
        List<T> result = new ArrayList<>();
        preOrderRecursive(root, result);
        return result;
    }

    private void preOrderRecursive(BinaryTreeNode<T> node, List<T> result) {
        if (node != null) {
            result.add(node.getValue());
            preOrderRecursive(node.getLeft(), result);
            preOrderRecursive(node.getRight(), result);
        }
    }

    public List<T> postOrderTraversal() {
        List<T> result = new ArrayList<>();
        postOrderRecursive(root, result);
        return result;
    }

    private void postOrderRecursive(BinaryTreeNode<T> node, List<T> result) {
        if (node != null) {
            postOrderRecursive(node.getLeft(), result);
            postOrderRecursive(node.getRight(), result);
            result.add(node.getValue());
        }
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public int getHeight() {
        return root == null ? -1 : root.getHeight();
    }

    public boolean isEmpty() {
        return root == null;
    }
}

