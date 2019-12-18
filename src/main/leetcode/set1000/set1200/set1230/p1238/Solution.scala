package set1000.set1200.set1230.p1238

object Solution {
  def circularPermutation(n: Int, start: Int): List[Int] = {

    def loop(i: Int): Vector[Int] = {
      if (i == n) {
        Vector(0)
      } else {
        val a = loop(i + 1)
        val b = a.reverse
        a ++ (b.map(x => (1 << (n - 1 - i)) | x))
      }
    }

    val arr = loop(0).toArray

    val arr2 = arr ++ arr

    var i = 0
    while (arr(i) != start) {
      i += 1
    }

    arr2.slice(i, i + arr.length).toList
  }
}
