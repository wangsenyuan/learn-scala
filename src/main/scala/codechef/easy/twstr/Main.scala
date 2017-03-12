package codechef.easy.twstr

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/12.
  */
object Main {

  def main(args: Array[String]): Unit = {

    val n = StdIn.readInt()

    val trie = new Trie

    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+")
      val recipe = line(0)
      val priority = line(1).toLong
      trie.addRecipe(recipe, 0, priority)
      i += 1
    }

    val q = StdIn.readInt()
    i = 0
    while (i < q) {
      val q = StdIn.readLine()
      trie.query(q, 0) match {
        case None => println("NO")
        case Some(x) => println(x)
      }
      i += 1
    }
  }

  class Trie {
    val children = Array.fill[Trie](27)(null)

    var topPriority = Long.MinValue
    var topRecipe = ""

    private def index(x: Char) =
      if (x == '-') {
        26
      } else {
        x - 'a'
      }

    def addRecipe(r: String, i: Int, v: Long): Unit = {
      if (v > topPriority) {
        topPriority = v
        topRecipe = r
      }

      if (i < r.length) {
        val x = r(i)
        val y = index(x)
        if (children(y) == null) {
          children(y) = new Trie
        }
        children(y).addRecipe(r, i + 1, v)
      }
    }

    def query(r: String, i: Int): Option[String] = {
      if (i == r.length) {
        Some(topRecipe)
      } else {
        val x = r(i)
        val y = index(x)
        if (children(y) == null) {
          None
        } else {
          children(y).query(r, i + 1)
        }
      }
    }
  }

}
