package org.vitorfurini.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    private BinaryTreeNode<Integer> node;

    @BeforeEach
    void setUp() {
        node = new BinaryTreeNode<>(10);
    }

    @Test
    void shouldCreateNodeWithValue() {
        BinaryTreeNode<Integer> testNode = new BinaryTreeNode<>(5);
        assertEquals(5, testNode.getValue());
        assertNull(testNode.getLeft());
        assertNull(testNode.getRight());
    }

    @Test
    void shouldSetLeftChild() {
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(5);
        node.setLeft(left);
        
        assertEquals(left, node.getLeft());
    }

    @Test
    void shouldSetRightChild() {
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(15);
        node.setRight(right);
        
        assertEquals(right, node.getRight());
    }

    @Test
    void shouldIdentifyLeafNode() {
        assertTrue(node.isLeaf());
        
        node.setLeft(new BinaryTreeNode<>(5));
        assertFalse(node.isLeaf());
    }

    @Test
    void shouldCalculateHeightForLeafNode() {
        assertEquals(0, node.getHeight());
    }

    @Test
    void shouldCalculateHeightForNodeWithChildren() {
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(15);
        node.setLeft(left);
        node.setRight(right);
        
        assertEquals(1, node.getHeight());
    }

    @Test
    void shouldCalculateHeightForUnbalancedTree() {
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(5);
        node.setLeft(left);
        
        BinaryTreeNode<Integer> leftLeft = new BinaryTreeNode<>(3);
        left.setLeft(leftLeft);
        
        assertEquals(2, node.getHeight());
    }

    @Test
    void shouldSetValue() {
        node.setValue(20);
        assertEquals(20, node.getValue());
    }

    @Test
    void shouldHandleStringValues() {
        BinaryTreeNode<String> stringNode = new BinaryTreeNode<>("Hello");
        assertEquals("Hello", stringNode.getValue());
        assertEquals("Hello", stringNode.toString());
    }
}

