import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class _404左叶子之和 {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    Deque<TreeNode> deque_left = new LinkedList<>();
    Deque<TreeNode> deque_right = new LinkedList<>();
    deque_right.add(root);
    int sum = 0;
    while (!deque_left.isEmpty() || !deque_right.isEmpty()) {
      int size_left = deque_left.size(), size_right = deque_right.size();
      for (int i = 0; i < size_left; i++) {
        TreeNode node = deque_left.pollFirst();
        if (node.left == null && node.right == null) {
          sum += node.val;
        }
        if (node.left != null) deque_left.add(node.left);
        if (node.right != null) deque_right.add(node.right);
      }
      for (int i = 0; i < size_right; i++) {
        TreeNode node = deque_right.pollFirst();
        if (node.left != null) deque_left.add(node.left);
        if (node.right != null) deque_right.add(node.right);
      }
    }
    return sum;
  }
}
