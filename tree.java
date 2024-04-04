package tree;

class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public String toString(){
        return 'data'+ this.data;
    }

}

class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // recursive approach
    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value <= root.data) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }

        return root;
    }

    public void insert(int value) {
        // TreeNode node = new TreeNode(value);

        // if (root == null) {
        // root = node;
        // return;
        // }
        // TreeNode current = root;
        // while (true) {
        // if (value <= root.data) {
        // if (current.leftChild == null) {
        // current.leftChild = new TreeNode(value);
        // break;
        // }
        // current = current.leftChild;
        // } else {
        // if (current.rightChild == null) {
        // current.rightChild = new TreeNode(value);
        // break;
        // }
        // current = current.rightChild;
        // }

        // }
        insert(root, value);

    }

    private TreeNode find(TreeNode root, int value) {
        if (root == null)
            return null;
        if (root.data == value)
            return root;
        if (value < root.data) {
            return find(root.leftChild, value);
        }
        return find(root.rightChild, value);
    }

    public TreeNode find(int value) {
        return find(root, value);
    }

    private void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);

    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void inOrderTreaversal(TreeNode root) {
        if (root == null)
            return;

        inOrderTreaversal(root.leftChild, value);
        inOrderTreaversal(root.rightChild, value);
    }

    public void inOrderTreaversal() {
        inOrderTreaversal(root);
    }

    private int depth(TreeNode root, int value, int depth) {
        if (root == null)
            return -1;

        if (root.data == value)
            return depth;

        if (value <= root.data) {
            return depth(root.leftChild, value, depth + 1);
        }
        return depth(root.rightChild, value, depth + 1);
    }

    public int getHeightForNode(TreeNode root, int value) {
        if (root == null)
            return -1;
        if (root.data == value)
            return heightOfTree(root);

        if (value <= root.data)
            return getHeightForNode(root.leftChild, value);
    }

    public int heightOfTree(TreeNode root) {
        if (root == null)
            return -1;
        if (root.leftChild == null && root.rightChild == null)
            return 0;

        int myHeight = 1 + Math.max(height(root.leftChild), height(root.rightChild));
        return myHeight;
    }

    public int getHeight() {
        return heightOfTree(root, 1);
    }

    private boolean isEqual(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;

        if (r1 == null)
            return false;
        if (r2 == null)
            return false;

        return r1.data == r2.data && isEqual(r1.leftChild, r2.leftChild) && isEqual(r1.rightChild, r2.rightChild);
    }
}
