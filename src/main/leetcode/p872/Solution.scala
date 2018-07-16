package p872

import scala.util.Random

object Solution extends SolBase {

  def rand10(): Int = {
    var res = 40
    while (res >= 40) {
      res = 7 * (rand7() - 1) + (rand7() - 1)
    }
    res % 10 + 1
  }
}

class SolBase {
  val random = new Random

  def rand7(): Int = random.nextInt(7) + 1
}
