package com.personal.jiuZhangALG.class3_binaryTree;

public class BinaryTree_maxPathSum {

    public static int maxPathSum(TreeNode root) {
        ResultType2 result = helper(root);
        return result.any2Any;
    }

    private static ResultType2 helper(TreeNode root) {
        //illegal
        if (root == null){
            return new ResultType2(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        //Divide
        ResultType2 left = helper(root.left);
        ResultType2 right = helper(root.right);

        //Conquer
        /* 得到从根节点分别到左右任意一个子树的最大路径值 */
        int root2Any = Math.max(0, Math.max(left.root2Any, right.root2Any)) + root.val;

        /* 先比较两者（根到左 和 根到右 ）里面哪一个获取的路径更大 */
        int any2Any = Math.max(left.any2Any, right.any2Any);

        /* 再比较两者（根到单支 和 包含左右两支）里面哪一个获取的路径更大 */
        any2Any = Math.max(any2Any,
                           Math.max(0, left.root2Any)
                            + Math.max(0, right.root2Any)
                            + root.val);
        return new ResultType2(root2Any, any2Any);
    }

    private ResultType2 helperTest(TreeNode2 root) {
        //illegal
        if (null == root) {
            return new ResultType2(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        //Divider
        /* 这里递归调用，一直递进到二叉树最深的节点 */
        ResultType2 left = helperTest(root.left);
        ResultType2 right = helperTest(root.right);

        //Conquer
        /* 获取从根路径出发是的最大路径值（maxPathSum） */
        int root2Any = Math.max(0, Math.max(left.root2Any, right.root2Any)) + root.val;
        /* 如果最大路径分别在左右两个分支上，比较这两种情况的大小 */
        int any2Any = Math.max(left.any2Any, right.any2Any);

        any2Any = Math.max(any2Any,
                            Math.max(0, left.root2Any)
                                    + Math.max(0, right.root2Any)
                                    + root.val);
        return  new ResultType2(root2Any, any2Any);
    }
}
