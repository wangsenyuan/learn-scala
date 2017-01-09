package codechef.easy.name1

import scala.io.StdIn

/**
  * Created by wangsenyuan on 27/12/2016.
  */
object Main {

  def countLetter(str: String): Array[Int] = {
    val array = Array.fill(26)(0)
    for {
      s <- str
      if s >= 'a' && s <= 'z'
    } {
      array(s - 'a') += 1
    }
    array
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val parents = StdIn.readLine()
      val set1 = countLetter(parents)
      var n = StdIn.readInt()
      var children = ""
      while (n > 0) {
        children += StdIn.readLine()
        n -= 1
      }
      val set2 = countLetter(children)
      val res = set1.zip(set2).forall {
        case (x, y) => x >= y
      }
      if (res) {
        println("YES")
      } else {
        println("NO")
      }
    }
  }
}
