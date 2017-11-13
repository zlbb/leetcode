object Solution {
  def main(args:Array[String]): Unit = {
    println(simplifyPath("/a/./b/../../c/"))
    println(simplifyPath("/"))
  }
  def simplifyPath(path: String): String = {
    val paths = path.split("/").filter(_!="").filter(_!=".")
    var stack = List[String]()
    paths.foreach(i => {
      if(i!=".."){
        stack = i +: stack 
      }else{
        if(stack.size!=0)
          stack = stack.tail
      }
    })
    "/" + stack.reverse.mkString("/")
  }
}