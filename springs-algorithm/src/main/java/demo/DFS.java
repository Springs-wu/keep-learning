package demo;

import java.util.Stack;

/**
 * 深度优先遍历 利用栈
 * 非递归
 */
public class DFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        dfs(root);
    }

    private static void dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 1.根节点入栈
        stack.add(root);
        while (!stack.isEmpty()) {
            // 2.节点出栈 6.左子树出栈 10.依次类推
            // 3.打印节点值 7.打印左子树节点的值
            TreeNode node = stack.pop();
            System.out.println(node.value);
            // 4.如果右子树不为空，则把右子树入栈 8.如果左子树的右节点不为空，则入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            // 5.如果左子树不为空，则把左子树入栈 9.如果左子树的左节点不为空，则入栈
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

}
