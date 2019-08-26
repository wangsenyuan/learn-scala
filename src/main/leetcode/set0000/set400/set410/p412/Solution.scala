package set0000.set400.set410.p412

import scala.collection.mutable.ListBuffer

object Solution {
  def fizzBuzz(n: Int): List[String] = {
    val res = ListBuffer.empty[String]

    for {
      i <- 1 to n
    } {
      if(i % 3 == 0 && i % 5 == 0) {
        res += "FizzBuzz"
      } else if(i % 3 == 0) {
        res += "Fizz"
      } else if(i % 5 == 0) {
        res += "Buzz"
      } else {
        res += s"$i"
      }
    }

    res.toList
  }
}
