package org.vitorfurini.tree;

import java.util.List;

public class TreePOC {

    public static void main(String[] args) {
        demonstrateGeneralTree();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateBinarySearchTree();
    }

    private static void demonstrateGeneralTree() {
        System.out.println("GENERAL TREE POC");
        System.out.println("=".repeat(50));

        Tree<String> companyTree = new Tree<>("CEO");
        TreeNode<String> root = companyTree.getRoot();

        TreeNode<String> cto = new TreeNode<>("CTO");
        TreeNode<String> cfo = new TreeNode<>("CFO");
        TreeNode<String> coo = new TreeNode<>("COO");

        root.addChild(cto);
        root.addChild(cfo);
        root.addChild(coo);

        TreeNode<String> devManager = new TreeNode<>("Dev Manager");
        TreeNode<String> qaManager = new TreeNode<>("QA Manager");
        cto.addChild(devManager);
        cto.addChild(qaManager);

        TreeNode<String> seniorDev = new TreeNode<>("Senior Dev");
        TreeNode<String> juniorDev = new TreeNode<>("Junior Dev");
        devManager.addChild(seniorDev);
        devManager.addChild(juniorDev);

        System.out.println("Tree Height: " + companyTree.getHeight());
        System.out.println("Tree Size: " + companyTree.getSize());
        System.out.println("Dev Manager Depth: " + devManager.getDepth());
        System.out.println("Dev Manager Height: " + devManager.getHeight());
        System.out.println("Senior Dev is Leaf: " + seniorDev.isLeaf());
        System.out.println("CEO is Root: " + root.isRoot());

        System.out.println("\nBreadth-First Traversal:");
        List<String> bfs = companyTree.breadthFirstTraversal();
        System.out.println(bfs);

        System.out.println("\nDepth-First Traversal:");
        List<String> dfs = companyTree.depthFirstTraversal();
        System.out.println(dfs);

        System.out.println("\nFinding 'Dev Manager': " + companyTree.find("Dev Manager").getValue());
    }

    private static void demonstrateBinarySearchTree() {
        System.out.println("BINARY SEARCH TREE POC");
        System.out.println("=".repeat(50));

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 65};

        System.out.println("Inserting values:");
        for (int value : values) {
            System.out.print(value + " ");
            bst.insert(value);
        }
        System.out.println();

        System.out.println("\nTree Height: " + bst.getHeight());

        System.out.println("\nIn-Order Traversal (sorted):");
        System.out.println(bst.inOrderTraversal());

        System.out.println("\nPre-Order Traversal:");
        System.out.println(bst.preOrderTraversal());

        System.out.println("\nPost-Order Traversal:");
        System.out.println(bst.postOrderTraversal());

        System.out.println("\nSearching for values:");
        System.out.println("Contains 40: " + bst.contains(40));
        System.out.println("Contains 35: " + bst.contains(35));
        System.out.println("Contains 100: " + bst.contains(100));

        System.out.println("\nDeleting 20:");
        bst.delete(20);
        System.out.println("In-Order after deletion: " + bst.inOrderTraversal());
        System.out.println("Contains 20: " + bst.contains(20));

        System.out.println("\nDeleting 30 (node with two children):");
        bst.delete(30);
        System.out.println("In-Order after deletion: " + bst.inOrderTraversal());
        System.out.println("Contains 30: " + bst.contains(30));
    }
}

