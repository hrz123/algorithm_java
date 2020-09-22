import java.util.ArrayList;
import java.util.Arrays;

public class Three {
  public static void main(String[] args) {
    Three three = new Three();
    int[] nums = {1, 1, 1, 2, 3, 4};
    int[] res = three.numsGame(nums);
    System.out.println(Arrays.toString(res));
  }

  public int[] numsGame(int[] nums) {
    int mod = 1000000007;
    ArrayList<Integer> ans = new ArrayList<>();
    ArrayList<Long> dp = new ArrayList<>();
    for (int i = 0; i < 200001; i++) {
      dp.add(0L);
    }
    for (int num : nums) {
      long res = Long.MAX_VALUE;
      for (int k = 1; k < 200001; k++) {
        int tmp = k - 100000;
        dp.set(k, dp.get(k - 1) + Math.abs(num - tmp));
        if (dp.get(k) < res) {
          res = dp.get(k);
        }
      }
      ans.add((int) (res % mod));
    }
    System.out.println(ans);
    return ans.stream().mapToInt(Integer::valueOf).toArray();
  }
}
