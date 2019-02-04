package set300.set310.p316

object Solution {
  def removeDuplicateLetters(s: String): String = {
    val count = Array.fill(26)(0)

    s.foreach(x => count(x - 'a') += 1)

    //    var que = Vector.empty[Int]
    val vis = Array.fill(26)(false)
    val n = s.length
    val que = Array.fill(n)(0)
    var end = 0
    s.foreach(c => {
      val j = c - 'a'

      if (vis(j)) {
        count(j) -= 1
      } else {
        while (end > 0 && que(end - 1) > j && count(que(end - 1)) > 1) {
          vis(que(end - 1)) = false
          count(que(end - 1)) -= 1
          end -= 1
        }
        que(end) = j
        end += 1
        vis(j) = true
      }
    })

    //    val res = ListBuffer.empty[Char]
    val added = Array.fill(26)(false)
    var i = 0
    var j = 0
    while (i < end) {
      val cur = que(i)
      if (!added(cur)) {
        que(j) = cur
        j += 1
      }
      added(cur) = true
      i += 1
    }

    que.take(j).map(x => (x + 'a').toChar).mkString("")
  }

}
