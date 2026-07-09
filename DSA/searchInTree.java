class Solution {
    public boolean search(Node root, int key) {
        // Search the key in a binary search tree
        if (root == null) {
            return false;
        }

        while (root != null) {
            if (root.data == key) {
                return true;
            } else if (key < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return false;
    }
}

