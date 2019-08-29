package set0000.set800.set880.p884

object Solution {
  def uncommonFromSentences(A: String, B: String): Array[String] = {
    val as = A.split("\\s+")
    val bs = B.split("\\s+")
    val a = as.toSet
    val b = bs.toSet

    val c = a.diff(b).filter(w => as.count(_ == w) == 1)
    val d = b.diff(a).filter(w => bs.count(_ == w) == 1)

    (c ++ d).toArray
  }
}
