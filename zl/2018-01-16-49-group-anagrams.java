import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      String[] tarr = str.split("");
      Arrays.sort(tarr);
      StringBuilder sb = new StringBuilder();
      for (String t : tarr) {
        sb.append(t);
      }
      String key = sb.toString();
      if (map.get(key) != null) {
        map.get(key).add(str);
      }else{
        List<String> list = new LinkedList<>();
        list.add(str);
        map.put(key,list);
      }
    }
    return new ArrayList<List<String>>(map.values());
  }
}