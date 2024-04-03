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
}
