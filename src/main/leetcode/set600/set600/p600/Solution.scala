package set600.set600.p600

object Solution {
  def findIntegers(num: Int): Int = {

    val f = Array.fill(30)(0)
    f(0) = 1
    f(1) = 2
    f(2) = 3
    for {
      i <- 3 until 30
    } {
      f(i) = f(i-1) + f(i-2)
    }

    def loop(prev: Int, i: Int): Int = {
      if(i < 0) {
        1
      } else {
        if(((num >> i) & 1) == 0) {
          loop(0, i - 1)
        } else if(prev == 0) {
          loop(1, i - 1) + f(i)
        } else {
          f(i)
        }
      }
    }

    loop(0, 29)
  }
}
