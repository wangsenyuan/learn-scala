package codechef.easy.astring

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/30.
  */
object Main {

  /*def solve() = {
    val str = StdIn.readLine()
    val k = StdIn.readInt()

    val res = Array.fill(k)(' ')
    var tmp = str
    var i = 0
    while (i < k) {
      if (tmp.length == k - i) {
        var j = 0
        while (j < tmp.length) {
          res(i) = tmp(j)
          i += 1
          j += 1
        }
      } else {
        var x = -1
        var j = 0
        while (j + k - i <= tmp.length) {
          if (x < 0 || tmp(j) < tmp(x)) {
            x = j
          }
          j += 1
        }

        res(i) = tmp(x)
        tmp = tmp.substring(x + 1)
        i += 1
      }
    }


    println(new String(res))
  }*/

  case class Item(ch: Char, index: Int)

  implicit val itemOrding = new Ordering[Item] {
    override def compare(x: Item, y: Item): Int = {
      if (x.ch < y.ch || (x.ch == y.ch && x.index < y.index)) {
        -1
      } else if (x.ch == y.ch && x.index == y.index) {
        0
      } else {
        1
      }
    }
  }

  def solve(): Unit = {
    val str = StdIn.readLine()
    val k = StdIn.readInt()
    val n = str.length

    val set = new mutable.TreeSet[Item]
    var i = 0
    while (i < n - k + 1) {
      set += Item(str(i), i)
      i += 1
    }

    val res = new StringBuilder()
    var b = set.head.index
    res.append(set.head.ch)

    var a = 0
    i = n - k + 1
    while (i < n) {
      while (a <= b) {
        set -= Item(str(a), a)
        a += 1
      }

      set += Item(str(i), i)

      b = set.head.index
      res.append(set.head.ch)

      i += 1
    }

    println(res.toString())
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt

    (0 until t) foreach {
      _ => solve()
    }
  }
}
