class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];   // safe size
        build(nums, 0, n - 1, 1);
    }

    // build tree
    private void build(int[] nums, int start, int end, int node) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        build(nums, start, mid, 2 * node);
        build(nums, mid + 1, end, 2 * node + 1);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // query sum in range [l, r]
    public int query(int l, int r) {
        return queryUtil(0, n - 1, l, r, 1);
    }

    private int queryUtil(int start, int end, int l, int r, int node) {
        if (r < start || end < l) return 0; // no overlap
        if (l <= start && end <= r) return tree[node]; // total overlap
        int mid = (start + end) / 2;
        return queryUtil(start, mid, l, r, 2 * node) +
               queryUtil(mid + 1, end, l, r, 2 * node + 1);
    }

    // update index with new value
    public void update(int idx, int val) {
        updateUtil(0, n - 1, idx, val, 1);
    }

    private void updateUtil(int start, int end, int idx, int val, int node) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) updateUtil(start, mid, idx, val, 2 * node);
        else updateUtil(mid + 1, end, idx, val, 2 * node + 1);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
}
