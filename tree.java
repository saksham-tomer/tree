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
}