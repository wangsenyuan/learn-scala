package set800.set810.p819

import scala.collection.mutable

object Solution {
  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    val set = banned.toSet

    val n = paragraph.length
    var j = 0
    while(j < n && !paragraph(j).isLetterOrDigit) {
      j += 1
    }

    val cnt = mutable.Map.empty[String, Int].withDefaultValue(0)
    var i = j
    while(i <= n) {
      if(i == n || !paragraph(i).isLetterOrDigit) {
        val s = paragraph.substring(j, i).toLowerCase()
        if(!set.contains(s)) {
          cnt(s) += 1
        }
        j = i + 1
        while(j < n && !paragraph(j).isLetterOrDigit) {
          j += 1
        }
        i = j
      }
      i += 1
    }

    val arr = cnt.toArray

    var ans = 0
    i = 1
    while(i < arr.length) {
      if(arr(ans)._2 < arr(i)._2) {
        ans = i
      }
      i += 1
    }

    arr(ans)._1
  }
}
