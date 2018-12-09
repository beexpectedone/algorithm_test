package com.personal.jiuZhangALG.class3_binaryTree;

/***
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *   1
 *  / \
 * 2   3
 *    / \
 *   4   5
 *  The maximum depth is 3.
 */
public class BinaryTree_maxDepth {

    //定义全局变量，作为记录最大深度的值
    private int max; /** 程序中最好不要出现全局变量 */

    /**
     *使用普通的递归的方式：
     * 存在的问题： 定义了全局变量同时程序也不够简洁
     *
     * @param root 根节点
     * @return max depth
     */
    public int maxDepth(TreeNode2 root) {
        max = 0; //初始值为0
        helper(root,1);
        return max;
    }

    private void helper(TreeNode2 root, int depth) {
        if (root == null) {
            return;
        }

        max = Math.max(max, depth);
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }

    /**
     * use divede and conquer
     * 使用分治方法
     *
     * @param root  root node
     * @return max depth
     */
    public int maxDepth_by_divide(TreeNode2 root) {
        if (null == root) {
            return  0;
        }

        int leftDepth = maxDepth_by_divide(root.left);
        int rightDepth = maxDepth_by_divide(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
