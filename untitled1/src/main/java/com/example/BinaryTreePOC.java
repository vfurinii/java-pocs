package com.example;


public class BinaryTreePOC {

    // no da arvore
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // Inserção em uma Binary Search Tree
    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Busca de valor
    static boolean contains(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.value) {
            return true;
        }

        return value < root.value
                ? contains(root.left, value)
                : contains(root.right, value);
    }

    // Percurso In-order (esquerda, raiz, direita)
    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    // Percurso Pre-order (raiz, esquerda, direita)
    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Percurso Post-order (esquerda, direita, raiz)
    static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Ponto de entrada
    public static void main(String[] args) {
        Node root = null;

        int[] values = {10, 5, 15, 3, 7, 12, 18};

        for (int value : values) {
            root = insert(root, value);
        }

        System.out.print("In-order: ");
        inOrder(root);

        System.out.print("\nPre-order: ");
        preOrder(root);

        System.out.print("\nPost-order: ");
        postOrder(root);

        System.out.println("\n\nContem 7? " + contains(root, 7));
        System.out.println("Contem 20? " + contains(root, 20));
    }
}
