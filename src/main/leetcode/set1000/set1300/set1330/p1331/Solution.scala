package set1000.set1300.set1330.p1331

object Solution {
  def arrayRankTransform(arr: Array[Int]): Array[Int] = {
    val sorted = arr.zipWithIndex.sortBy(_._1)
    var rank = 1

    var i = 1
    val res = Array.ofDim[Int](arr.length)
    while (i <= arr.length) {
      val item = sorted(i - 1)
      res(item._2) = rank
      if (i < arr.length && sorted(i)._1 > item._1) {
        rank += 1
      }
      i += 1
    }

    //    res(sorted.last._2) = rank

    res
  }
}
