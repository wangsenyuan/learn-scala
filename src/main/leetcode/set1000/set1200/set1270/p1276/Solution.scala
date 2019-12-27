package set1000.set1200.set1270.p1276

object Solution {
  def numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): List[Int] = {
    // x & y => 4 * x + 2 * y = t, x + y = c
    // 2 * x = t - 2c
    if (tomatoSlices < 2 * cheeseSlices) {
      Nil
    } else {
      val d = tomatoSlices - 2 * cheeseSlices
      if ((d & 1) == 1) {
        Nil
      } else {
        val x = d >> 1
        val y = cheeseSlices - x
        if (y < 0) {
          Nil
        } else {
          List(x, y)
        }
      }
    }
  }
}
