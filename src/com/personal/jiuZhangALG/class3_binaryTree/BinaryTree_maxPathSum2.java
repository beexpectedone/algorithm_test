package com.personal.jiuZhangALG.class3_binaryTree;

/**
 * Given a binary tree, find the maximum path sum from root
 * The path may end at any node in the tree and contain at least one node in
 * it.
 *
 * Given the below binary tree:
 *      1
 *    /  \
 *  2     4
 *  return 4. {1->3}
 */
public class BinaryTree_maxPathSum2 {
    public int maxPathSum2(TreeNode2 root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        //root -> leaf
//        return Math.max(left, right) + root.val;

        //root -> anynode
        /* 如果遍历到某个分支下下了，发现该分支下两个节点的
         * 最大值小于零，那么就取零代替 */
        /** 这里的root.val 理解为 作为每一个有子节点你的几点
         * 它都是一个“父节点”，父节点的值当然这一级的结果
         * 中要包含这个 */
        return Math.max(0, Math.max(left, right)) + root.val;
    }
}
