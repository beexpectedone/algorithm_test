package personal.jiuZhangALG.class3_binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *    1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * return [1,2,4,5,3].
 */
public class BinaryTree_preorder_traversal {

    /**
     * Stack : last-in-first-out
     * push the right node in and then left,
     * pop the left node first then right
     * 利用Stack后进先出的特点，所以在添加node到Stack中时，先将right节点添加进去再添加left节点
     *
     * @param root root tree
     * @return result list
     */
    public List<Integer> preorderTraversal_noRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preorder = new ArrayList<>();

        if (null == root){
            return preorder;
        }
        stack.push(root); //push the node tree into stack
        while (!stack.empty()){
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preorder;
    }


    /**
     *
     * @param root treeNode 对象
     * @return 结果集合
     */
    //version 1:Traverse
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    //把root为根的preorder加入result里面
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null){
            return;
        }
        result.add(root.val);
        traverse(root.left,result);
        traverse(root.right,result);
    }

    /**
     *
     * @param root root node
     * @return result list
     */
    //Version 2: Divide & Conquer
    public ArrayList<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        //null or leaf
        if (root == null) {
            return result;
        }
        //Divide
        ArrayList<Integer> left = preorderTraversal2(root.left);
        ArrayList<Integer> right = preorderTraversal2(root.right);

        //Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
