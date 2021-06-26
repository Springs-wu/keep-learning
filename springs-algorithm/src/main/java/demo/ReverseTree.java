package Impl.algorithm;

/**
 * 逆序输出排序二叉树
 * 输入
 *   4
 * 2   6
 *1 3 5 7
 * 输出
 * 7 6 5 4 3 2 1
 */
public class ReverseTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        reverseTree(root);
    }

    private static void reverseTree(TreeNode root) {
        if (root.right != null) reverseTree(root.right);
        System.out.println(root.value);
        if (root.left!=null) reverseTree(root.left);
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
