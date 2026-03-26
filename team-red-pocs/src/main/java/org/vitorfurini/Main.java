static class SegmentTreeNode {
    int start, end;
    int sum;

    SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
        this.left = null;
        this.right = null;
    }
}

public static class SegmentTree {
    private SegmentTreeNode root;

    public SegmentTree(int[] nums) {
        this.root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
        if (start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildSegmentTree(nums, start, mid);
            node.right = buildSegmentTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    public int rangeSum(int start, int end) {
        return rangeSum(root, start, end);
    }

    private int rangeSum(SegmentTreeNode node, int start, int end) {
        if (node == null || start > node.end || end < node.start) {
            return 0;
        }
        if (start <= node.start && end >= node.end) {
            return node.sum;
        }
        return rangeSum(node.left, start, end) + rangeSum(node.right, start, end);
    }


    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int index, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (index <= mid) {
                update(root.left, index, val);
            } else {
                update(root.right, index, val);
            }

            root.sum = root.left.sum + root.right.sum;
        }
    }
}

void main(String[] args) {
    int[] nums = {1, 3, 5, 7, 9, 11};
    SegmentTree segmentTree = new SegmentTree(nums);

    System.out.println("Range Sum (0, 2): " + segmentTree.rangeSum(0, 2));
    // Output: 9

    // Update index 1 to value 10
    segmentTree.update(1, 10);
    System.out.println("Range Sum (0, 2): " + segmentTree.rangeSum(0, 2));
    // Output: 16

    // Additional tests
    System.out.println("Range Sum (1, 3): " + segmentTree.rangeSum(1, 3));
    // Output: 22

    System.out.println("Range Sum (2, 5): " + segmentTree.rangeSum(2, 5));
    // Output: 32

    // Update index 4 to value 6
    segmentTree.update(4, 6);
    System.out.println("Range Sum (3, 5): " + segmentTree.rangeSum(3, 5));
    // Output: 24
}

