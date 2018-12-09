package personal.jiuZhangALG.class3_binaryTree;

import sun.reflect.generics.tree.ReturnType;

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


}
