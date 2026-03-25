package org.vitorfurini.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    private Tree<String> tree;
    private TreeNode<String> root;

    @BeforeEach
    void setUp() {
        tree = new Tree<>("Root");
        root = tree.getRoot();
    }

    @Test
    void shouldCreateTreeWithRootValue() {
        Tree<String> newTree = new Tree<>("TestRoot");
        
        assertNotNull(newTree.getRoot());
        assertEquals("TestRoot", newTree.getRoot().getValue());
    }

    @Test
    void shouldPerformBreadthFirstTraversal() {
        TreeNode<String> child1 = new TreeNode<>("Child1");
        TreeNode<String> child2 = new TreeNode<>("Child2");
        TreeNode<String> grandChild1 = new TreeNode<>("GrandChild1");
        
        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(grandChild1);
        
        List<String> result = tree.breadthFirstTraversal();
        
        assertEquals(List.of("Root", "Child1", "Child2", "GrandChild1"), result);
    }

    @Test
    void shouldPerformDepthFirstTraversal() {
        TreeNode<String> child1 = new TreeNode<>("Child1");
        TreeNode<String> child2 = new TreeNode<>("Child2");
        TreeNode<String> grandChild1 = new TreeNode<>("GrandChild1");
        
        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(grandChild1);
        
        List<String> result = tree.depthFirstTraversal();
        
        assertEquals(List.of("Root", "Child1", "GrandChild1", "Child2"), result);
    }

    @Test
    void shouldFindNodeByValue() {
        TreeNode<String> child1 = new TreeNode<>("Child1");
        TreeNode<String> child2 = new TreeNode<>("Child2");
        
        root.addChild(child1);
        root.addChild(child2);
        
        TreeNode<String> found = tree.find("Child1");
        
        assertNotNull(found);
        assertEquals("Child1", found.getValue());
    }

    @Test
    void shouldReturnNullWhenNodeNotFound() {
        TreeNode<String> found = tree.find("NonExistent");
        
        assertNull(found);
    }

    @Test
    void shouldCalculateTreeHeight() {
        assertEquals(0, tree.getHeight());
        
        TreeNode<String> child1 = new TreeNode<>("Child1");
        root.addChild(child1);
        assertEquals(1, tree.getHeight());
        
        TreeNode<String> grandChild1 = new TreeNode<>("GrandChild1");
        child1.addChild(grandChild1);
        assertEquals(2, tree.getHeight());
    }

    @Test
    void shouldCalculateTreeSize() {
        assertEquals(1, tree.getSize());
        
        TreeNode<String> child1 = new TreeNode<>("Child1");
        TreeNode<String> child2 = new TreeNode<>("Child2");
        root.addChild(child1);
        root.addChild(child2);
        
        assertEquals(3, tree.getSize());
        
        TreeNode<String> grandChild1 = new TreeNode<>("GrandChild1");
        child1.addChild(grandChild1);
        
        assertEquals(4, tree.getSize());
    }

    @Test
    void shouldHandleComplexTreeStructure() {
        TreeNode<String> child1 = new TreeNode<>("Child1");
        TreeNode<String> child2 = new TreeNode<>("Child2");
        TreeNode<String> child3 = new TreeNode<>("Child3");
        
        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);
        
        TreeNode<String> grandChild1 = new TreeNode<>("GrandChild1");
        TreeNode<String> grandChild2 = new TreeNode<>("GrandChild2");
        child1.addChild(grandChild1);
        child1.addChild(grandChild2);
        
        TreeNode<String> greatGrandChild = new TreeNode<>("GreatGrandChild");
        grandChild1.addChild(greatGrandChild);
        
        assertEquals(7, tree.getSize());
        assertEquals(3, tree.getHeight());
    }

    @Test
    void shouldWorkWithIntegerValues() {
        Tree<Integer> intTree = new Tree<>(1);
        TreeNode<Integer> intRoot = intTree.getRoot();
        
        intRoot.addChild(new TreeNode<>(2));
        intRoot.addChild(new TreeNode<>(3));
        
        assertEquals(List.of(1, 2, 3), intTree.breadthFirstTraversal());
    }
}

