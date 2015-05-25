package p216.combination.sum

/**
 * Created by senyuanwang on 15/5/24.
 */
object App extends App {

  def combinationSumK(k: Int, n: Int): List[List[Int]] = {

    def go(k: Int, n: Int, x: Int): List[List[Int]] =
      if (k == 1 && n < 10) List(List(n))
      else if (k == 1) Nil
      else {
        for {
          i <- (x + 1 until 10).toList
          if (n - i > i)
          list <- go(k - 1, n - i, i)
        } yield i :: list
      }

    go(k, n, 0)
  }

  println(combinationSumK(3, 9))
  println(combinationSumK(4, 24))
}
