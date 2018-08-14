import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean isScramble(String s1, String s2) {
    if (s1.equals(s2)) {
      return true;
    }

    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s1.length(); i++) {
      Integer s1c = map.get(s1.charAt(i));
      s1c = s1c == null ? 0 : s1c;
      map.put(s1.charAt(i), s1c + 1);

      Integer s2c = map.get(s2.charAt(i));
      s2c = s2c == null ? 0 : s2c;
      map.put(s2.charAt(i), s2c - 1);

    }

    for (Integer i : map.values()) {
      if (i != 0)
        return false;
    }

    for (int i = 1; i < s1.length(); i++) {
      if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
        return true;
      if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
          && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
        return true;
    }
    return false;
  }
}
