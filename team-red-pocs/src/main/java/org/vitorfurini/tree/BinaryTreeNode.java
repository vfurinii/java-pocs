package org.vitorfurini.tree;

public class BinaryTreeNode<T> {
    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public int getHeight() {
        if (isLeaf()) {
            return 0;
        }
        int leftHeight = left != null ? left.getHeight() : -1;
        int rightHeight = right != null ? right.getHeight() : -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

