import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Add the root node to the queue

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Get the node from the queue
                level.add(node.val); // Add its value to the current level list

                if (node.left != null) queue.offer(node.left);   // Add left child
                if (node.right != null) queue.offer(node.right); // Add right child
            }

            result.add(level); // Add the current level list to the result
        }

        return result;
    }
}
