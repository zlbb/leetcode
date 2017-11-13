object Solution {
  def main(args:Array[String]): Unit = {
    println(fullJustify(Array("What","must","be","shall","be."),12))
  }
  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    var sum = 0
    var list:List[String] = Nil
    var lists:List[(List[String],Int)] = Nil
    for(i <- 0 until words.length){
      sum += words(i).length
      if(sum + Math.max(list.size - 1, 0) > maxWidth){
        println(sum + Math.max(list.size - 1, 0))
        lists = lists :+ (list,list.map(_.length).sum)
        list = List(words(i))
        sum = words(i).length 
      } else {
        list = list :+ words(i)
        sum += words(i).length 
      }
    }
    if(list.size != 0){
      lists = lists :+ (list,list.map(_.length).sum)
    }
    lists.map{
      case (list,sum) => addSpace(list,sum,maxWidth)
    }
  }

  def addSpace(words: List[String], length: Int, maxWidth: Int): String = {
    if(words.size > 1){
      val base = (maxWidth - length) / (words.size - 1)
      val add = (maxWidth - length) % (words.size - 1)
      words.zipWithIndex.map{
        case (item,idx) => {item + (if(idx != words.size - 1) " " * base + (if(idx < add) " " else "") else "") }
      }.mkString("")
    } else {
      words(0) + " " * (maxWidth - length)
    }
  }
}