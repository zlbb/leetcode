class Solution {
  public String countAndSay(int n) {
    String res = "1";
    for(int i=1;i<n;i++){
      res = next(res);
    } 
    return res;
  }
  public String next(String str){
    StringBuilder sb = new StringBuilder();
    char prev = str.charAt(0);
    int count = 0;
    for(int i = 0;i<str.length();i++){
      if(prev == str.charAt(i)){
        count++;
      }else{
        sb.append(count);
        sb.append(prev);
        prev=str.charAt(i);
        count=1;
      }
    }
    sb.append(count);
    sb.append(prev);
    return sb.toString();
  }
  
}