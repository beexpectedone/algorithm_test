package personal.jiuZhangALG.class3_binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree_inorder_traversal {

    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curt = root;
        while (curt != null && !stack.empty()) {
            while (curt != null) {  // 这部分的程序是将一个分支上所有的节点全部压入栈中（类似于后序遍历）
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }

    public ArrayList<Integer> inorderTraversal_no_recursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        while (root != null) {
            stack.add(root);
            root = root.left;  //将一个分支上的左边节点全部压栈
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            result.add(node.val);

            if (node.right == null) {
                node = stack.pop(); // 如果该节点没有右侧节点就将该节点弹栈
                while (!stack.isEmpty() && stack.peek().right == node) { // 做一次弹栈操作后，此时stack.peek() 获取到的是父节点
                    node = stack.pop(); // 如果发现弹出栈的节点为当前节点的右边节点则将当前节点弹栈，并赋值给node
                }
            } else {
                node = node.right;
                while (node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return result;
    }
}
