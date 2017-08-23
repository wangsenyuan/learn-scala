package codechef.easy.wsites01

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {

  sealed trait State

  case object NoSite extends State

  case object AllBlocked extends State

  case object AllUnBlocked extends State

  case object PartBlocked extends State

  class Trie {
    val children = Array.fill[Trie](26)(null)
    var state: State = NoSite

    private def updateState(blocked: Boolean): State = {
      state match {
        case NoSite =>
          if (blocked) {
            AllBlocked
          } else {
            AllUnBlocked
          }
        case AllBlocked =>
          if (blocked) {
            AllBlocked
          } else {
            PartBlocked
          }
        case AllUnBlocked =>
          if (blocked) {
            PartBlocked
          } else {
            AllUnBlocked
          }
        case PartBlocked =>
          PartBlocked
      }
    }

    def addSite(site: String, i: Int, blocked: Boolean): Unit = {
      state = updateState(blocked)

      if (i < site.length) {
        val c = site(i)
        if (children(c - 'a') == null) {
          children(c - 'a') = new Trie
        }
        children(c - 'a').addSite(site, i + 1, blocked)
      }
    }

    def hasSolution: Boolean = {
      if (state == PartBlocked) {
        val blockPrefixUnblock = children.filter(_ != null).foldLeft(true)((res, child) => res && (child.state == NoSite || child.state == AllUnBlocked))
        if (blockPrefixUnblock) {
          false
        } else {
          children.filter(_ != null).foldLeft(true)((res, child) => res && child.hasSolution)
        }
      } else {
        children.filter(_ != null).foldLeft(true)((res, child) => res && child.hasSolution)
      }
    }

    def findBlockedFilters(path: String, res: ListBuffer[String]): Unit = {
      state match {
        case NoSite =>
        case AllUnBlocked =>
        case AllBlocked =>
          res += path
        case PartBlocked =>
          var i = 0
          while (i < children.length) {

            if (children(i) != null) {
              children(i).findBlockedFilters(path + (i + 'a').toChar, res)
            }

            i += 1
          }
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

    if (trie.hasSolution) {
      val res = ListBuffer.empty[String]
      trie.findBlockedFilters("", res)

      println(res.size)
      res.foreach(println)
    } else {
      println(-1)
    }


  }
}
