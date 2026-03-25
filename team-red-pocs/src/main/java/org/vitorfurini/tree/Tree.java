package org.vitorfurini.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree<T> {
    private TreeNode<T> root;

    public Tree(T rootValue) {
        this.root = new TreeNode<>(rootValue);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public List<T> breadthFirstTraversal() {
        List<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            result.add(current.getValue());
            queue.addAll(current.getChildren());
        }

        return result;
    }

    public List<T> depthFirstTraversal() {
        List<T> result = new ArrayList<>();
        depthFirstRecursive(root, result);
        return result;
    }

    private void depthFirstRecursive(TreeNode<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        result.add(node.getValue());
        for (TreeNode<T> child : node.getChildren()) {
            depthFirstRecursive(child, result);
        }
    }

    public TreeNode<T> find(T value) {
        return findRecursive(root, value);
    }

    private TreeNode<T> findRecursive(TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        if (node.getValue().equals(value)) {
            return node;
        }
        for (TreeNode<T> child : node.getChildren()) {
            TreeNode<T> found = findRecursive(child, value);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public int getHeight() {
        return root == null ? -1 : root.getHeight();
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        int size = 1;
        for (TreeNode<T> child : node.getChildren()) {
            size += getSizeRecursive(child);
        }
        return size;
    }
}

