import java.util.List;

class Solution {
  public int trap(int[] height) {
    if (height.length <= 1)
      return 0;
    List<Integer> maxs = new ArrayList<>();
    for (int i = 0; i < height.length; i++) {
      if (i == 0) {
        if (height[i] > height[i + 1])
          maxs.add(i);
        continue;
      }
      if (i == height.length - 1) {
        if (height[i - 1] < height[i])
          maxs.add(i);
        continue;
      }
      if (height[i] >= height[i + 1] && height[i - 1] <= height[i])
        maxs.add(i);
    }
    System.out.println(maxs);
    int size = maxs.size();
    while (true) {
      pure(maxs,height);
      if (maxs.size() == size)
        break;
      else
        size = maxs.size();
    }
    System.out.println(maxs);
    int sum = 0;
    for (int i = 1; i < maxs.size(); i++) {
      if (height[maxs.get(i - 1)] > height[maxs.get(i)]) {
        for (int j = maxs.get(i - 1) + 1; j < maxs.get(i); j++) {
          sum += (height[maxs.get(i)] - height[j] > 0) ? height[maxs.get(i)] - height[j] : 0;
        }
      } else {
        for (int j = maxs.get(i - 1) + 1; j < maxs.get(i); j++) {
          sum += (height[maxs.get(i - 1)] - height[j] > 0) ? height[maxs.get(i - 1)] - height[j] : 0;
        }
      }
    }
    return sum;
  }

  void pure(List<Integer> maxs,int[] height) {
    for (int i = 1; i < maxs.size() - 1; i++) {
      if (height[maxs.get(i)] < height[maxs.get(i + 1)] && height[maxs.get(i)] < height[maxs.get(i - 1)]) {
        maxs.remove(i);
        i--;
      }
    }
  }
}

//System.out.println(new Solution().trap(new int[]{5,5,1,7,1,1,5,2,7,6}));
