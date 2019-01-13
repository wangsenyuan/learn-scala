package set200.set210.p216

object Solution {

  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    def go(k: Int, num: Int, start: Int): Seq[List[Int]] = {
      if (k == 1) {
        if (num > start && num <= 9) {
          Seq(List(num))
        } else {
          Seq()
        }
      } else {
        (for {
          y <- (start + 1) to 9
          res <- go(k - 1, num - y, y)
        } yield {
          y :: res
        })
      }
    }

    go(k, n, 0).toList
  }
}
