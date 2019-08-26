package set0000.set700.set720.p721

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Solution {
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    val arr = accounts.toArray
    val emails = mutable.Map.empty[String, Int]
    val set = new UF(arr.length)
    var i = 0
    while (i < arr.length) {
      arr(i).tail.foreach(email => {
        if (!emails.contains(email)) {
          emails += email -> i
        } else {
          set.union(i, emails(email))
        }
      })

      i += 1
    }

    val res = mutable.Map.empty[Int, ArrayBuffer[String]]

    emails.foreach {
      case ((k, v)) =>
        val pv = set.find(v)
        if(!res.contains(pv)) {
          res(pv) = ArrayBuffer.empty[String]
        }
        res(pv) += k
    }

    val list = ListBuffer.empty[List[String]]
    res.foreach {
      case ((k, v)) =>
        val name = arr(k).head
        val buf = ListBuffer.empty[String]
        buf.append(name)
        buf.appendAll(v.sorted)

        list += buf.toList
    }

    list.toList
  }

  class UF(size: Int) {
    val arr = Array.ofDim[Int](size)
    val cnt = Array.ofDim[Int](size)

    (0 until size) foreach (i => {
      arr(i) = i
      cnt(i) = 1
    })

    def find(x: Int): Int = {
      if (arr(x) != x) {
        arr(x) = find(arr(x))
      }
      arr(x)
    }

    def union(a: Int, b: Int): Boolean = {
      val pa = find(a)
      val pb = find(b)
      if (pa == pb) {
        false
      } else if (cnt(pa) > cnt(pb)) {
        arr(pb) = pa
        cnt(pa) += cnt(pb)
        true
      } else {
        arr(pa) = pb
        cnt(pb) += cnt(pa)
        true
      }
    }
  }

}
