package set0000.set300.set390.p398

import scala.util.Random

class Solution(_nums: Array[Int]) {

  val rand = new Random()

  def pick(target: Int): Int = {
    var up = 1
    var i = 0
    var ans = -1
    while(i < _nums.length) {
      if(_nums(i) == target) {
        val j = rand.nextInt(up)
        if(j == 0) {
          ans = i
        }
        up += 1
      }

      i += 1
    }
    ans
  }

}
