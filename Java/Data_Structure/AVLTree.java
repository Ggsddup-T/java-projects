/**
 * AVL Tree — a self-balancing Binary Search Tree (BST).
 *
 * Rule: for every node, |height(left) - height(right)| <= 1
 * If an insert makes a node unbalanced (balance = -2 or +2), we rotate to fix it.
 *
 * Four rotation cases after insert:
 *   LL (left-left)   → right rotate
 *   RR (right-right) → left rotate
 *   LR (left-right)  → left rotate on left child, then right rotate
 *   RL (right-left)  → right rotate on right child, then left rotate
 *
 * Example inserts in main: 10, 20, 30, 40, 50, 25
 * Final preorder output: 30 20 10 25 40 50
 */
class Node {
    int key;        // value stored in this node
    int height;     // height of this subtree (1 for a leaf)
    Node left;      // pointer to left child (smaller keys)
    Node right;     // pointer to right child (larger keys)

    // Create a new leaf node with the given key
    Node(int d) {
        key = d;       // store the value
        height = 1;    // a new leaf has height 1 (no children)
    }
}

public class AVLTree {
    Node root; // top of the tree; null means empty tree

    // Return the height of node N; null nodes have height 0
    // Example: height(null) = 0, height(leaf) = 1
    int height(Node N) {
        if (N == null)
            return 0;      // empty subtree
        return N.height;   // use stored height (updated after insert/rotate)
    }

    // Return the larger of two integers
    // Example: max(2, 3) = 3
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Right rotation — fixes Left-Left (LL) imbalance.
     *
     * Before (unbalanced at y):        After:
     *       y                                x
     *      / \                              /   \
     *     x   T3                           T1    y
     *    / \                                   / \
     *   T1 T2                                 T2  T3
     *
     * Example: y = node 30, x = node 20 (left child taller by 2)
     *   rightRotate(30) makes 20 the new root of this subtree.
     */
    Node rightRotate(Node y) {
        Node x = y.left;     // x is the left child that will become the new root
        Node T2 = x.right;   // save x's right subtree (middle part between x and y)

        x.right = y;         // y becomes right child of x
        y.left = T2;         // T2 becomes left child of y

        // Update heights bottom-up after links change
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x; // x is the new root of this rotated subtree
    }

    /**
     * Left rotation — fixes Right-Right (RR) imbalance.
     *
     * Before (unbalanced at x):        After:
     *       x                                y
     *      / \                              /   \
     *     T1  y                            x    T3
     *        / \                          / \
     *       T2 T3                        T1 T2
     *
     * Example: insert 30 into tree with root 10 → right child 20 → right child 30
     *   leftRotate(10) fixes the RR case (see insert of 30 in main).
     */
    Node leftRotate(Node x) {
        Node y = x.right;    // y is the right child that will become the new root
        Node T2 = y.left;    // save y's left subtree

        y.left = x;          // x becomes left child of y
        x.right = T2;        // T2 becomes right child of x

        // Update heights after rotation
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y; // y is the new root of this rotated subtree
    }

    // Balance factor = height(left) - height(right)
    //   0  → balanced
    //  +1  → left slightly taller (OK)
    //  -1  → right slightly taller (OK)
    //  +2  → left too tall → need right rotation (or LR double rotation)
    //  -2  → right too tall → need left rotation (or RL double rotation)
  //
    // Example: node with left height 2 and right height 0 → balance = +2 (unbalanced)
    int getBalance(Node N) {
        if (N == null)
            return 0; // empty node is treated as balanced
        return height(N.left) - height(N.right);
    }

    /**
     * Insert key into the subtree rooted at node; return the (possibly new) root.
     *
     * Steps:
     *   1. Standard BST insert (go left if smaller, right if larger)
     *   2. Update node height
     *   3. Check balance; rotate if needed
     */
    Node insert(Node node, int key) {
        // ----- Step 1: BST insert -----
        if (node == null)
            return (new Node(key)); // reached empty spot — create new leaf

        if (key < node.key)
            node.left = insert(node.left, key);   // go left for smaller key
        else if (key > node.key)
            node.right = insert(node.right, key); // go right for larger key
        else
            return node; // duplicate key — do not insert again

        // ----- Step 2: Update height of current node -----
        // Height = 1 + max height of children
        // Example: left height 2, right height 1 → node height = 3
        node.height = 1 + max(height(node.left), height(node.right));

        // ----- Step 3: Check balance and rotate if unbalanced -----
        int balance = getBalance(node);

        // Case LL: balance +2 and key went into left child's LEFT subtree
        // Example: insert 30 into 10 → 20 → 30 (all right chain from 10's left... actually RR)
        // LL example: insert 5 into tree 20 → 10 → 5
        //   balance at 20 is +2, key < node.left.key (5 < 10) → rightRotate(20)
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Case RR: balance -2 and key went into right child's RIGHT subtree
        // Example from main: insert 10, then 20, then 30
        //   Tree: 10 → 20 → 30 (right chain), balance at 10 is -2, key > node.right.key
        //   → leftRotate(10) → tree becomes root 20 with children 10 and 30
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Case LR: balance +2 but key went into left child's RIGHT subtree
        // Example: insert 25 after 10, 20, 30 — 25 goes right of 20
        //   First leftRotate on left child, then rightRotate on node
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left); // fix left child first
            return rightRotate(node);          // then fix current node
        }

        // Case RL: balance -2 but key went into right child's LEFT subtree
        // Example: insert 15 into tree 20 → 30 → 15 (15 is left of 30)
        //   First rightRotate on right child, then leftRotate on node
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right); // fix right child first
            return leftRotate(node);              // then fix current node
        }

        return node; // already balanced — no rotation needed
    }

    // Preorder traversal: visit root, then left subtree, then right subtree
    // Example tree:    30
    //                /  \
    //              20    40
    //             /  \     \
    //           10   25    50
    // Output: 30 20 10 25 40 50
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " "); // print current node first
            preOrder(node.left);              // then entire left subtree
            preOrder(node.right);             // then entire right subtree
        }
    }

  // Demo: build an AVL tree by inserting values; rotations keep it balanced
    public static void main(String[] args) {
        AVLTree tree = new AVLTree(); // create empty AVL tree

        // Insert 10 → tree: 10
        tree.root = tree.insert(tree.root, 10);

        // Insert 20 → tree: 10 → 20 (balanced, no rotation)
        tree.root = tree.insert(tree.root, 20);

        // Insert 30 → RR imbalance at 10 → leftRotate → tree: 20 (root), left 10, right 30
        tree.root = tree.insert(tree.root, 30);

        // Insert 40 → tree grows on right; may rotate when 50 is added
        tree.root = tree.insert(tree.root, 40);

        // Insert 50 → RR at 30 → leftRotate → right side rebalanced
        tree.root = tree.insert(tree.root, 50);

        // Insert 25 → goes right of 20 (LR case) → double rotation
        // Final tree root becomes 30 with balanced left/right subtrees
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Preorder traversal" + " of the constructed tree: ");
        tree.preOrder(tree.root); // prints: 30 20 10 25 40 50
    }
}
