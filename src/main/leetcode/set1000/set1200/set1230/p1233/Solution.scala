package set1000.set1200.set1230.p1233

import scala.collection.mutable.ListBuffer
import scala.util.Sorting

object Solution {
  def removeSubfolders(folder: Array[String]): List[String] = {
    Sorting.quickSort(folder)(Ordering.fromLessThan(compareFolder))
    val n = folder.length
    val buf = ListBuffer.empty[String]
    // now folder is sorted by names
    var j = 0
    var i = 1
    while (i <= n) {
      if (i == n || !subFolder(folder(j), folder(i))) {
        buf += folder(j)
        j = i
      }
      i += 1
    }
    buf.toList
  }

  private def subFolder(a: String, b: String): Boolean = {
    var i = 0
    while (i < a.length && i < b.length && a(i) == b(i)) {
      i += 1
    }
    if (i < a.length) {
      false
    } else {
      // i == a.length
      if (i == b.length) {
        // same
        true
      } else {
        b(i) == '/'
      }
    }
  }

  private def compareFolder(a: String, b: String): Boolean = {
    var i = 0
    while (i < a.length && i < b.length && a(i) == b(i)) {
      i += 1
    }
    if (i == a.length) {
      true
    } else if (i < b.length) {
      a(i) < b(i)
    } else {
      false
    }
  }
}
