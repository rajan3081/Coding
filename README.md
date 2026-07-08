# Coding

## Tree/searchInTree.java

```java
class Solution {
    public boolean search(Node root, int key) {
        // code here
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
```

