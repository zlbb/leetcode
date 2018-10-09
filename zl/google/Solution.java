import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public static int minStep(int[][] matrix) {
    if (matrix.length == 0)
      return 0;
    int[] l = new int[matrix.length + 2];
    int[] r = new int[matrix.length + 2];
    int[] empty = new int[matrix.length + 2];
    l[0] = r[0] = 0;
    r[l.length - 1] = l[l.length - 1] = matrix[0].length - 1;

    for (int i = 1; i < l.length - 1; i++) {
      int m = 0;
      int n = matrix[0].length - 1;
      while (m <= n && (matrix[i - 1][m] != 1 || matrix[i - 1][n] != 1)) {
        if (matrix[i - 1][m] != 1)
          m++;
        if (matrix[i - 1][n] != 1)
          n--;
      }
      if (m > n) {
        l[i] = l[i - 1];
        r[i] = r[i - 1];
        empty[i] = 1;
      } else {
        l[i] = m;
        r[i] = n;
      }
    }
    int[] dpl = new int[l.length];
    int[] dpr = new int[r.length];
    dpl[0] = dpr[0] = 0;
    for (int i = 1; i < dpl.length; i++) {
      if (empty[i] == 1) {
        dpl[i] = dpl[i - 1];
        dpr[i] = dpr[i - 1];
      } else {
        dpl[i] = Math.min(dpl[i - 1] + dis(l[i - 1], r[i], l[i]), dpr[i - 1] + dis(r[i - 1], r[i], l[i]));
        dpr[i] = Math.min(dpl[i - 1] + dis(l[i - 1], l[i], r[i]), dpr[i - 1] + dis(r[i - 1], l[i], r[i]));
      }
    }
    return Math.min(dpl[dpl.length - 1], dpr[dpr.length - 1]) + matrix.length - 1;
  }

  public static int dis(int start, int pass, int end) {
    return Math.abs(start - pass) + Math.abs(pass - end);
  }

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(new FileInputStream("./test"));
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    int[][] matrix = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    System.out.print(minStep(matrix));
    scanner.close();
  }
}