package set1000.set1200.set1290.p1291

import scala.collection.mutable.ArrayBuffer

object Solution {
  def sequentialDigits(low: Int, high: Int): List[Int] = {
    val buf = ArrayBuffer.empty[Int]

    def gen(i: Int, num: Int, prev: Int): Unit = {
      if (num <= high) {
        if (i == 10) {
          if (num >= low && num <= high) {
            buf += num
          }
        } else {
          if (prev < 9 && prev > 0) {
            gen(i + 1, num * 10 + prev + 1, prev + 1)
          }

          if (prev == 0) {
            gen(i + 1, num, 0)
            var x = 1
            while (x < 10) {
              gen(i + 1, x, x)
              x += 1
            }
          }
        }
      }
    }

    gen(0, 0, 0)

    buf.toList
  }
}
