class Solution {

  int minStep(int[][] matrix) {
    int[] l = new int[matrix.length + 2];
    int[] r = new int[matrix.length + 2];
    int[] empty = new int[matrix.length + 2];
    l[0] = r[0] = 0;
    l[l.length - 1] = r[r.length - 1] = matrix[0].length - 1;

    for (int i = 0; i < matrix.length; i++) {
      int j = 0;
      for (; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1)
          l[i + 1] = j;
        break;
      }
    }
    if (j == mat[0].length) {
      l[i] = l[i - 1];
      empty[i] = 1;
    }
    j = mat[0].length - 1;
    for (; j >= 0; j--) {
      if (mat[i][j] == 1)
        r[i + 1] = j;
      break;
    }
    if (j < 0) {
      r[i] = r[i - 1];
      empty[i] = 1;
    }
    int[] dpl = new int[l.length];
    int[] dpr = new int[r.length];

    dpl[0] = 0;
    dpr[0] = 0;

    for (int i = 1; i < l.length; i++) {
      if (empty[i] == 1) {
        dpl[i] = dpl[i - 1];
        dpr[i] = dpr[i - 1];
      } else {
        dpl[i] = Math.min(dpl[i - 1] + dis(l[i - 1], r[i], l[i]), dpr[i - 1] + dis(r[i - 1], l[i], r[i]));
        dpr[i] = Math.min(dpr[i - 1] + dis(r[i - 1], l[i], r[i]), dpl[i - 1] + dis(l[i - 1], l[i], r[i]));
      }
    }
    return Math.min(dpl[l.length - 1], dpr[r.length - 1]) + matrix.length;
  }

  int dis(int begin, int pass, int end) {
    return Math.abs(begin - pass) + Math.abs(pass - end);
  }
}