package p198

/**
 * Created by senyuanwang on 15/4/6.
 */
object App extends App {

  def solve(num: Array[Int]): Int = {
    if (num == null || num.length == 0) {
      0
    } else if (num.length == 1) {
      num(0)
    } else {
      def go(i: Int, a: Int, b: Int): Int =
        if (i == num.length) b
        else {
          val c = a + num(i)
          go(i + 1, b, b max c)
        }

      go(2, num(0), num(0) max num(1))
    }
  }

}
