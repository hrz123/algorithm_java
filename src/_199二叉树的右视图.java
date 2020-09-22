import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class _199二叉树的右视图 {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) return res;
    ArrayList<TreeNode> q = new ArrayList<TreeNode>();
    ArrayList<TreeNode> nq = new ArrayList<>();
    q.add(root);
    while (!q.isEmpty()) {
      for (int i = 0; i < q.size(); i++) {
        if (q.get(i).left != null) {
          nq.add(q.get(i).left);
        }
        if (q.get(i).right != null) {
          nq.add(q.get(i).right);
        }
        if (i == q.size() - 1) {
          res.add(q.get(i).val);
        }
      }
      q = nq;
      nq = new ArrayList<>();
    }
    return res;
  }
}