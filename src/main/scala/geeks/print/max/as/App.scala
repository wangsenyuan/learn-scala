package geeks.print.max.as

/**
 * Created by senyuanwang on 15/4/18.
 */
object App extends App {

  def findOptimal(n: Int): Int =
    if (n < 7) {
      n
    } else {
      var max = 0
      for {
        i <- n - 3 until 0 by -1
      } {
        val curr = (n - i - 1) * findOptimal(i)
        if (curr > max) {
          max = curr
        }
      }
      max
    }

  println(findOptimal(11))

  def findOptimal1(n: Int): Int =
    if (n < 7) n
    else {
      (n - 3 until 0 by -1).foldLeft(0) {
        (result, index) =>
          val curr = (n - index - 1) * findOptimal1(index)
          result max curr
      }
    }

  println(findOptimal1(11))

  def findOptimal2(n: Int): Int =
    if (n < 7) n
    else {
      val screen = Array.fill(n)(0)
      for (i <- 0 until 6) {
        screen(i) = i + 1
      }

      for {
        i <- 7 to n
        _ = screen(i - 1) = 0
        j <- i - 3 to 1 by -1
        curr = (i - j - 1) * screen(j - 1)
      } {
        if (curr > screen(i - 1)) {
          screen(i - 1) = curr
        }
      }
      screen(n - 1)
    }

  println(findOptimal2(11))
}
