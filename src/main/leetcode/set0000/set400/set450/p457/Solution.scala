package set0000.set400.set450.p457

object Solution {
  def circularArrayLoop(nums: Array[Int]): Boolean = {
    val n = nums.length
    val vis = Array.ofDim[Boolean](n)

    val xs = nums.map(num => normalize(num, n))

    def check(i: Int): Boolean = {
      val dir = xs(i) > 0
      var slow = i
      var fast = i
      do {
        vis(slow) = true
        if((xs(slow) > 0) != dir || xs(slow) == 0) {
          return false
        }
        slow = (xs(slow) + slow + n) % n

        if ((xs(fast) > 0) != dir || xs(fast) == 0) {
          return false
        }
        fast = (xs(fast) + fast + n) % n

        if ((xs(fast) > 0) != dir || xs(fast) == 0) {
          return false
        }

        fast = (xs(fast) + fast + n) % n
      } while(slow != fast && !vis(slow))

      return slow == fast
    }

    var found = false
    var i = 0
    while(i < n && !found) {
      if(!vis(i)) {
        found = check(i)
      }
      i += 1
    }

    found
  }

  private def normalize(num: Int, n: Int): Int = {
    if(num < n && num > -n) {
      num
    } else if(num > 0) {
      num % n
    } else {
      -(num.abs % n)
    }
  }
}
