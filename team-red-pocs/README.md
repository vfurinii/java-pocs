# Tree Data Structure POC

Complete implementation of tree data structures in Java with comprehensive unit tests.

## Implementations

### 1. TreeNode (General Tree)
Generic n-ary tree node that can have any number of children.

**Features:**
- Add/remove children
- Parent-child relationships
- Height and depth calculation
- Leaf and root identification
- Generic type support

### 2. BinaryTreeNode
Binary tree node with left and right children only.

**Features:**
- Left and right child management
- Height calculation
- Leaf node identification
- Generic type support

### 3. Binary Search Tree (BST)
Self-balancing tree structure maintaining sorted order.

**Features:**
- Insert values in sorted order
- Search with O(log n) average complexity
- Delete nodes (leaf, one child, two children)
- Three traversal methods: in-order, pre-order, post-order
- Height calculation
- Generic comparable type support

### 4. Tree (General Tree Wrapper)
Wrapper class for managing general tree operations.

**Features:**
- Breadth-first traversal (BFS)
- Depth-first traversal (DFS)
- Find node by value
- Size and height calculation

## Running the POC

```bash
mvn exec:java -Dexec.mainClass="org.vitorfurini.tree.TreePOC"
```

## Running Tests

```bash
mvn test
```

## Test Coverage

- **42 unit tests** covering all functionality
- TreeNodeTest: 10 tests
- BinaryTreeNodeTest: 9 tests  
- BinarySearchTreeTest: 14 tests
- TreeTest: 9 tests

## Example Usage

### General Tree
```java
Tree<String> tree = new Tree<>("Root");
TreeNode<String> root = tree.getRoot();
TreeNode<String> child = new TreeNode<>("Child");
root.addChild(child);
List<String> bfs = tree.breadthFirstTraversal();
```

### Binary Search Tree
```java
BinarySearchTree<Integer> bst = new BinarySearchTree<>();
bst.insert(50);
bst.insert(30);
bst.insert(70);
boolean found = bst.contains(30);
List<Integer> sorted = bst.inOrderTraversal();
bst.delete(30);
```

## Complexity

| Operation | BST Average | BST Worst | General Tree |
|-----------|-------------|-----------|--------------|
| Insert    | O(log n)    | O(n)      | O(1)         |
| Search    | O(log n)    | O(n)      | O(n)         |
| Delete    | O(log n)    | O(n)      | O(1)         |
| Traversal | O(n)        | O(n)      | O(n)         |

