package set0000.set200.set220.p229

object Solution {
  def majorityElement(nums: Array[Int]): List[Int] = {
    if (nums.isEmpty) {
      Nil
    } else {
      //find the most two frequent numbers
      var a = nums(0)
      var b = nums(0)
      var ac = 0
      var bc = 0
      var i = 0
      while (i < nums.length) {
        if (nums(i) == a) {
          ac += 1
        } else if (nums(i) == b) {
          bc += 1
        } else if (ac == 0) {
          a = nums(i)
          ac += 1
        } else if (bc == 0) {
          b = nums(i)
          bc += 1
        } else {
          ac -= 1
          bc -= 1
        }

        i += 1
      }
      ac = nums.count(_ == a)
      bc = nums.count(_ == b)
      var res = List.empty[Int]
      if (ac > nums.length / 3) {
        res = a :: res
      }
      if (a != b && bc > nums.length / 3) {
        res = b :: res
      }
      res
    }
  }
}
