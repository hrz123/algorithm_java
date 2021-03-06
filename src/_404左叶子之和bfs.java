import java.util.LinkedList;
import java.util.Queue;

public class _404左叶子之和bfs {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.left != null) {
        if (isLeafNode(node.left)) {
          ans += node.left.val;
        } else {
          queue.offer(node.left);
        }
      }

      if (node.right != null) {
        if (!isLeafNode(node.right)) {
          queue.offer(node.right);
        }
      }
    }
    return ans;
  }

  private boolean isLeafNode(TreeNode node) {
    return node.left == null && node.right == null;
  }
}

