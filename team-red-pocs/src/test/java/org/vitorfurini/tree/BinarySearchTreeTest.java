package org.vitorfurini.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    void shouldInsertSingleValue() {
        bst.insert(10);
        
        assertTrue(bst.contains(10));
        assertFalse(bst.isEmpty());
    }

    @Test
    void shouldInsertMultipleValues() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
    }

    @Test
    void shouldNotContainNonExistentValue() {
        bst.insert(10);
        bst.insert(5);
        
        assertFalse(bst.contains(15));
        assertFalse(bst.contains(100));
    }

    @Test
    void shouldPerformInOrderTraversal() {
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            bst.insert(value);
        }
        
        List<Integer> result = bst.inOrderTraversal();
        
        assertEquals(List.of(20, 30, 40, 50, 60, 70, 80), result);
    }

    @Test
    void shouldPerformPreOrderTraversal() {
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            bst.insert(value);
        }
        
        List<Integer> result = bst.preOrderTraversal();
        
        assertEquals(List.of(50, 30, 20, 40, 70, 60, 80), result);
    }

    @Test
    void shouldPerformPostOrderTraversal() {
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            bst.insert(value);
        }
        
        List<Integer> result = bst.postOrderTraversal();
        
        assertEquals(List.of(20, 40, 30, 60, 80, 70, 50), result);
    }

    @Test
    void shouldDeleteLeafNode() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        
        bst.delete(5);
        
        assertFalse(bst.contains(5));
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(15));
    }

    @Test
    void shouldDeleteNodeWithOneChild() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(3);
        
        bst.delete(5);
        
        assertFalse(bst.contains(5));
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(3));
    }

    @Test
    void shouldDeleteNodeWithTwoChildren() {
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            bst.insert(value);
        }
        
        bst.delete(30);
        
        assertFalse(bst.contains(30));
        assertTrue(bst.contains(20));
        assertTrue(bst.contains(40));
        assertEquals(List.of(20, 40, 50, 60, 70, 80), bst.inOrderTraversal());
    }

    @Test
    void shouldDeleteRootNode() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        
        bst.delete(10);
        
        assertFalse(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
    }

    @Test
    void shouldCalculateHeight() {
        assertEquals(-1, bst.getHeight());
        
        bst.insert(10);
        assertEquals(0, bst.getHeight());
        
        bst.insert(5);
        bst.insert(15);
        assertEquals(1, bst.getHeight());
        
        bst.insert(3);
        bst.insert(7);
        assertEquals(2, bst.getHeight());
    }

    @Test
    void shouldHandleEmptyTree() {
        assertTrue(bst.isEmpty());
        assertEquals(-1, bst.getHeight());
        assertFalse(bst.contains(10));
        assertEquals(List.of(), bst.inOrderTraversal());
    }

    @Test
    void shouldNotInsertDuplicates() {
        bst.insert(10);
        bst.insert(10);
        
        List<Integer> result = bst.inOrderTraversal();
        assertEquals(1, result.size());
    }

    @Test
    void shouldHandleStringValues() {
        BinarySearchTree<String> stringBst = new BinarySearchTree<>();
        stringBst.insert("dog");
        stringBst.insert("cat");
        stringBst.insert("elephant");
        
        assertEquals(List.of("cat", "dog", "elephant"), stringBst.inOrderTraversal());
    }
}

