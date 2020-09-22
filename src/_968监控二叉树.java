public class _968监控二叉树 {
  int res = 0;

  public int minCameraCover(TreeNode root) {
    if (lrd(root) == 0) {
      res++;
    }
    return res;
  }

  int lrd(TreeNode node) {

    if (node == null) {
      return 1;
    }
    int left = lrd(node.left);
    int right = lrd(node.right);
    if (left == 0 || right == 0) {
      res++;
      return 2;
    }
    if (left == 1 && right == 1) {
      return 0;
    }
    if (left + right >= 3) {
      return 1;
    }
    return -1;
  }
}
