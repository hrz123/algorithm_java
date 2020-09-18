import java.util.Deque;
import java.util.LinkedList;

public class _862和至少为K的最短子数组 {
  public int shortestSubarray(int[] A, int K) {
    int N = A.length;
    long[] P = new long[N + 1];
    for (int i = 0; i < N; i++) P[i + 1] = P[i] + A[i];
    // want smallest y-x with P[y] - P[x] >= K
    int ans = N + 1;
    Deque<Integer> deque = new LinkedList<>(); // opt(y) candidates, as indices of P
    for (int y = 0; y < P.length; y++) {
      while (!deque.isEmpty() && P[y] <= P[deque.getLast()])
        deque.removeLast();
      while (!deque.isEmpty() && P[y] >= P[deque.getFirst()] + K)
        ans = Math.min(ans, y - deque.removeFirst());
      deque.addLast(y);
    }
    return ans < N + 1 ? ans : -1;
  }
}
