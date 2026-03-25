package org.vitorfurini.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    private TreeNode<String> root;
    private TreeNode<String> child1;
    private TreeNode<String> child2;

    @BeforeEach
    void setUp() {
        root = new TreeNode<>("Root");
        child1 = new TreeNode<>("Child1");
        child2 = new TreeNode<>("Child2");
    }

    @Test
    void shouldCreateNodeWithValue() {
        TreeNode<String> node = new TreeNode<>("Test");
        assertEquals("Test", node.getValue());
        assertTrue(node.getChildren().isEmpty());
    }

    @Test
    void shouldAddChild() {
        root.addChild(child1);
        
        assertEquals(1, root.getChildren().size());
        assertEquals(child1, root.getChildren().get(0));
        assertEquals(root, child1.getParent());
    }

    @Test
    void shouldAddMultipleChildren() {
        root.addChild(child1);
        root.addChild(child2);
        
        assertEquals(2, root.getChildren().size());
        assertEquals(root, child1.getParent());
        assertEquals(root, child2.getParent());
    }

    @Test
    void shouldRemoveChild() {
        root.addChild(child1);
        root.addChild(child2);
        
        root.removeChild(child1);
        
        assertEquals(1, root.getChildren().size());
        assertNull(child1.getParent());
    }

    @Test
    void shouldIdentifyLeafNode() {
        assertTrue(child1.isLeaf());
        
        root.addChild(child1);
        
        assertFalse(root.isLeaf());
        assertTrue(child1.isLeaf());
    }

    @Test
    void shouldIdentifyRootNode() {
        assertTrue(root.isRoot());
        
        root.addChild(child1);
        
        assertTrue(root.isRoot());
        assertFalse(child1.isRoot());
    }

    @Test
    void shouldCalculateHeight() {
        assertEquals(0, root.getHeight());
        
        root.addChild(child1);
        assertEquals(1, root.getHeight());
        
        TreeNode<String> grandChild = new TreeNode<>("GrandChild");
        child1.addChild(grandChild);
        assertEquals(2, root.getHeight());
    }

    @Test
    void shouldCalculateDepth() {
        assertEquals(0, root.getDepth());
        
        root.addChild(child1);
        assertEquals(1, child1.getDepth());
        
        TreeNode<String> grandChild = new TreeNode<>("GrandChild");
        child1.addChild(grandChild);
        assertEquals(2, grandChild.getDepth());
    }

    @Test
    void shouldSetValue() {
        root.setValue("NewValue");
        assertEquals("NewValue", root.getValue());
    }

    @Test
    void shouldReturnImmutableChildrenList() {
        root.addChild(child1);
        List<TreeNode<String>> children = root.getChildren();
        
        assertThrows(UnsupportedOperationException.class, () -> 
            children.add(new TreeNode<>("Invalid"))
        );
    }
}

