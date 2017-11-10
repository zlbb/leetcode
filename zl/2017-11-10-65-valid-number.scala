object Solution {
  def main(args:Array[String]): Unit = {
    println(isNumber("959440.94f"))
  } 
  def isNumber(s: String): Boolean = {
    val str = s.trim
    try{
      str.toDouble 
      str.last != 'f' && str.last != 'F' && str.last != 'd' && str.last != 'D'
    } catch {
      case _ => false
    }
  }
}