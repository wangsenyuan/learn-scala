package set1000.set1200.set1260.p1268

import scala.collection.mutable.ListBuffer
import scala.util.Sorting

object Solution {
  def suggestedProducts(products: Array[String], searchWord: String): List[List[String]] = {
    val res = ListBuffer.empty[List[String]]

    Sorting.quickSort(products)
    var n = products.length
    var i = 0
    var j = 0

    while (j < searchWord.length) {
      while (n > i && (j >= products(n - 1).length || products(n - 1)(j) > searchWord(j))) {
        n -= 1
      }
      while (i < n && (j >= products(i).length || products(i)(j) < searchWord(j))) {
        i += 1
      }

      if (i < n) {
        res += products.slice(i, n min (i + 3)).toList
      } else {
        res += List()
      }
      j += 1
    }

    res.toList
  }
}
