class Solution {
  public boolean helper(String s1, int s1s, String s2, int s2s, String s3) {
    if (s1.length() == s1s && s2.length() == s2s) {
      return true;
    }
    if (s1.length() == s1s) {
      if (s2.charAt(s2s) == s3.charAt(s1s + s2s))
        return helper(s1, s1s, s2, s2s + 1, s3);
      else
        return false;
    }
    if (s2.length() == s2s) {
      if (s1.charAt(s1s) == s3.charAt(s1s + s2s))
        return helper(s1, s1s + 1, s2, s2s, s3);
      else
        return false;
    }
    boolean res = false;
    if (s1.charAt(s1s) == s3.charAt(s1s + s2s)) {
      res = res || helper(s1, s1s + 1, s2, s2s, s3);
    }
    if (s2.charAt(s2s) == s3.charAt(s1s + s2s)) {
      res = res || helper(s1, s1s, s2, s2s + 1, s3);
    }
    return res;
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length())
      return false;
    else
      return helper(s1, 0, s2, 0, s3);
  }
}