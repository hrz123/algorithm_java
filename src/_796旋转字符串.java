public class _796旋转字符串 {
  public boolean rotateString(String A, String B) {
    return A.length() == B.length() && (A + A).contains(B);
  }
}
