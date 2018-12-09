package com.personal.jiuZhangALG.class3_binaryTree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary
 * tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}
 * A)  3            B)    3
 *    / \                  \
 *   9  20                 20
 *     /  \                / \
 *    15   7              15  7
 *
 * The binary tree A is a height-balanced binary tree, but B is not.
 */
public class BinaryTree_balanced_binary_tree {
    public boolean isBalanced(TreeNode2 root) {
        return helper(root).isBalanced;
    }

    // Version 1: with ResultType
    private ResultType helper(TreeNode2 root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        //subtree not balance
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }
        if (Math.abs(left.maxDepth - right.maxDepth) > 1 ){
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }

    //Version 2: without ResultType
    private boolean isBalanced_without_ResultType(TreeNode2 root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode2 root) {
        if (null == root) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.abs(left - right) + 1;
    }

}
