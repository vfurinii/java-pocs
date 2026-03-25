package org.vitorfurini.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode<T> {
    private T value;
    private TreeNode<T> parent;
    private List<TreeNode<T>> children;

    public TreeNode(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {
        child.parent = this;
        this.children.add(child);
    }

    public void removeChild(TreeNode<T> child) {
        if (this.children.remove(child)) {
            child.parent = null;
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public List<TreeNode<T>> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isRoot() {
        return parent == null;
    }

    public int getHeight() {
        if (isLeaf()) {
            return 0;
        }
        int maxChildHeight = 0;
        for (TreeNode<T> child : children) {
            maxChildHeight = Math.max(maxChildHeight, child.getHeight());
        }
        return maxChildHeight + 1;
    }

    public int getDepth() {
        if (isRoot()) {
            return 0;
        }
        return parent.getDepth() + 1;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

