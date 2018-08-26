import java.util.Arrays;

public class Solution {
  public void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

  public int parent(int curr) {
    return (curr + 1) / 2 - 1;
  }

  public int leftChild(int root) {
    return (root + 1) * 2 - 1;
  }

  public void hsort(int[] arr) {
    int tail = arr.length - 1;
    for (int i = tail; i >= 0; i--) {
      up(arr, i);
    }

    while (tail >= 0) {
      swap(arr, 0, tail);
      tail--;
      int root = 0;
      while (true) {
        int lc = leftChild(root);

        if (lc + 1 <= tail) {
          if (arr[lc] >= arr[lc + 1]) {
            swap(arr, root, lc);
            root = lc;
          } else {
            swap(arr, root, lc + 1);
            root = lc + 1;
          }
        } else if (lc > tail) {
          break;
        } else {
          if (arr[lc] > arr[root]) {
            swap(arr, lc, root);
            root = lc;
          } else {
            break;
          }
        }
      }
    }
  }

  public void up(int[] arr, int i) {
    while (i != 0) {
      int p = parent(i);
      if (arr[p] < arr[i]) {
        swap(arr, i, p);
      }
      i = p;
    }
  }
}
int[] arr = new int[] { 1, 5, 3, 2, 0, 2, 2, 2, 2, 4 };
new Solution().hsort(arr);
System.out.println(Arrays.toString(arr));