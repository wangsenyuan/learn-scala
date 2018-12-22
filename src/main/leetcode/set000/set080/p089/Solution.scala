package set000.set080.p089

object Solution {
  def grayCode(n: Int): List[Int] = {
    var res = List.empty[Int]

    var i = 0
    while (i < (1 << n)) {
      res = (i ^ (i >> 1)) :: res
      i += 1
    }

    res.reverse
  }
}
