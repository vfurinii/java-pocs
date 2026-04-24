package org.vitorfurini;

public class SalesSegmentTreePOC {

    private int[] tree;
    private int[] sales;
    private int n;

    public SalesSegmentTreePOC(int[] sales) {
        this.sales = sales;
        this.n = sales.length;
        this.tree = new int[4 * n];
        build(1, 0, n - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = sales[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public int query(int left, int right) {
        return query(1, 0, n - 1, left, right);
    }

    private int query(int node, int start, int end, int left, int right) {

        //out
        if (right < start || end < left) {
            return 0;
        }

        //inside
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        int sumLeft = query(node * 2, start, mid, left, right);
        int sumRight = query(node * 2 + 1, mid + 1, end, left, right);

        return sumLeft + sumRight;
    }

    public void update(int index, int newValue) {
        update(1, 0, n - 1, index, newValue);
    }

    private void update(int node, int start, int end, int index, int newValue) {
        if (start == end) {
            sales[index] = newValue;
            tree[node] = newValue;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, newValue);
        } else {
            update(node * 2 + 1, mid + 1, end, index, newValue);
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static void main(String[] args) {

        //sales
        int[] sales = {10, 15, 7, 20, 13, 9, 18};

        SalesSegmentTreePOC segmentTree = new SalesSegmentTreePOC(sales);

        System.out.println("=== Sales sYstem ===");

        System.out.println("Sales Amount day 2 tO 5: " + segmentTree.query(1, 4));

        System.out.println("aMOUNT: " + segmentTree.query(0, 6));

        //segmentTree.update(3, 25);

        //System.out.println("" + segmentTree.query(0, 6));
    }
}