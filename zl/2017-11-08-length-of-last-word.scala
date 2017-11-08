object Solution {
    def main(args:Array[String]):Unit = {
      println(lengthOfLastWord(" "))
    }
    def lengthOfLastWord(s: String): Int = {
      val arr = s.split(" ")
      if(arr.length == 0) 0 else arr.last.length
    }
}