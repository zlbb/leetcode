class Solution {
  public String convert(String s, int numRows) {
    if(numRows == 1) return s;
    StringBuilder sb = new StringBuilder();
    int round = 2 * (numRows - 1);
    for (int i = 0; i < numRows; i++) {
      if (i == 0) {
        for (int j = 0; j < s.length(); j += round) {
          sb.append(s.charAt(j));
        }
      } else if (i == numRows - 1) {
        for (int j = i; j < s.length(); j += round) {
          sb.append(s.charAt(j));
        }
      } else {
        boolean flag = true;
        for (int j = i; j < s.length(); j += flag ? (numRows - i - 1) * 2 : i * 2, flag = !flag) {
          sb.append(s.charAt(j)); 
        }
      }
    }
    return sb.toString();
  }
}

System.out.println(new Solution().convert("PAYPALISHIRING",3))