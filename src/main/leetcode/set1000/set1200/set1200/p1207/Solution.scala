package set1000.set1200.set1200.p1207

object Solution {
  def uniqueOccurrences(arr: Array[Int]): Boolean = {
    val cnt = Array.ofDim[Int](2002)
    arr.foreach(x => {
      cnt(x + 1000) += 1
    })

    val cnt2 = Array.ofDim[Int](1001)
    (0 until 2002).foreach(x => cnt2(cnt(x)) += 1)

    cnt2.tail.forall(_ <= 1)
  }
}
