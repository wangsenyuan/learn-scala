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

    def addUnBlockSite(site: String, i: Int): Unit = {
      state = updateState(false)

      if (i < site.length) {
        val c = site(i)
        if (children(c - 'a') == null) {
          children(c - 'a') = new Trie
        }
        children(c - 'a').addUnBlockSite(site, i + 1)
      }
    }

    def addBlockSite(site: String, i: Int): Boolean = {
      val originState = state
      state = updateState(true)

      if (i == site.length) {
        if (originState == AllUnBlocked || originState == PartBlocked) {
          false
        } else {
          true
        }
      } else {
        val c = site(i)
        if (children(c - 'a') == null) {
          children(c - 'a') = new Trie
        }
        children(c - 'a').addBlockSite(site, i + 1)
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

    val sites = ListBuffer.empty[String]

    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+")

      val blocked = line(0) == "-"
      if (blocked) {
        sites += line(1)
      } else {
        trie.addUnBlockSite(line(1), 0)
      }

      i += 1
    }

    var hasSolution = true
    i = 0
    while (i < sites.size && hasSolution) {

      hasSolution = trie.addBlockSite(sites(i), 0)

      i += 1
    }

    if (hasSolution) {
      val res = ListBuffer.empty[String]
      trie.findBlockedFilters("", res)

      println(res.size)
      res.foreach(println)
    } else {
      println(-1)
    }


  }
}
