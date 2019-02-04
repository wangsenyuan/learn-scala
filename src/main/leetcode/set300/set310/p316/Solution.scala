package set300.set310.p316

import scala.collection.mutable.ListBuffer

object Solution {
  def removeDuplicateLetters(s: String): String = {
    val count = Array.fill(26)(0)

    s.foreach(x => count(x - 'a') += 1)

    var que = Vector.empty[Int]
    val vis = Array.fill(26)(false)

    s.foreach(c => {
      val j = c - 'a'

      if (vis(j)) {
        count(j) -= 1
      } else {
        while (que.length > 0 && que.last > j && count(que.last) > 1) {
          vis(que.last) = false
          count(que.last) -= 1
          que = que.init
        }
        que :+= j
        vis(j) = true
      }
    })

    val res = ListBuffer.empty[Char]
    val added = Array.fill(26)(false)
    while (!que.isEmpty) {
      val cur = que.head
      if (!added(cur)) {
        val c = (cur + 'a').toChar
        res += c
      }
      added(cur) = true
      que = que.tail
    }

    res.mkString("")
  }

}
