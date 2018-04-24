import java.util.Arrays;

class Solution {
  public String longestPalindrome(String s) {
    if (s.length() <= 1)
      return s;
    String res = s.charAt(0) + "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j + i < s.length() && i - j >= 0; j++) {
        if (s.charAt(i + j) == s.charAt(i - j)) {
          if (2 * j + 1 > res.length())
            res = s.substring(i - j, i + j + 1);
        } else {
          break;
        }
      }
    }
    for (int i = 1; i < s.length(); i++) {
      for (int j = 0; j + i < s.length() && i - j - 1 >= 0; j++) {
        if (s.charAt(i + j) == s.charAt(i - j - 1)) {
          if (2 * (j+1) > res.length())
            res = s.substring(i - j - 1, i + j + 1);
        } else {
          break;
        }
      }
    }
    return res;
  }

}

// System.out.println(new Solution().longestPalindrome("cbbd"));