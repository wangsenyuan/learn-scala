package set0000.set900.set950.p953

object Solution {
  def isAlienSorted(words: Array[String], order: String): Boolean = {
    val ii = order.zipWithIndex.toMap

    var i = 1
    while (i < words.length && compare(words(i - 1), words(i), ii)) {
      i += 1
    }

    i == words.length
  }

  private def compare(a: String, b: String, ii: Map[Char, Int]): Boolean = {
    var i = 0
    while (i < a.length && i < b.length && ii(a(i)) == ii(b(i))) {
      i += 1
    }

    if (i == a.length) {
      true
    } else if (i == b.length) {
      false
    } else {
      ii(a(i)) < ii(b(i))
    }
  }
}
