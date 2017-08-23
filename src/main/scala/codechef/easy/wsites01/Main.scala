package codechef.easy.wsites01

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {

  class Trie {
    val children = Array.fill[Trie](26)(null)
    var blocked: Option[Boolean] = None

    def addSite(site: String, i: Int, blocked: Boolean): Unit = {
      if (i < site.length) {
        this.blocked match {
          case None => this.blocked = Some(blocked)
          case Some(old) => this.blocked = Some(old && blocked)
        }
        val c = site(i)
        if (children(c - 'a') == null) {
          children(c - 'a') = new Trie
        }
        children(c - 'a').addSite(site, i + 1, blocked)
      }
    }

    def findBlockedFilters(path: String, res: ListBuffer[String]): Unit = {
      this.blocked match {
        case Some(v) =>
          if (!v) {
            var i = 0
            while (i < children.length) {

              if (children(i) != null) {
                children(i).findBlockedFilters(path + (i + 'a').toChar, res)
              }

              i += 1
            }
          } else {
            res += path
          }
        case _ =>
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val trie = new Trie

    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+")

      val blocked = line(0) == "-"
      trie.addSite(line(1), 0, blocked)

      i += 1
    }

    val res = ListBuffer.empty[String]
    trie.findBlockedFilters("", res)

    if (res.size == 0) {
      println(-1)
    } else {
      println(res.size)
      res.foreach(println)
    }
  }
}
