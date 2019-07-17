package set700.set790.p791

import scala.util.Sorting

object Solution {
  def customSortString(S: String, T: String): String = {
    val ii = (S.zipWithIndex.toMap).withDefaultValue(-1)
    val tt = T.toCharArray
    Sorting.quickSort(tt)(Ordering.fromLessThan((a, b) => ii(a) < ii(b)))
    tt.mkString("")
  }
}
