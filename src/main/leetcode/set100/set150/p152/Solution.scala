package set100.set150.p152

object Solution {
  def maxProduct(nums: Array[Int]): Int = {

    def go(left: Int, right: Int): R = {
      if (left == right) {
        R(nums(left), nums(left), nums(left), nums(right), nums(right))
      } else {
        val mid = (left + right) / 2
        val a = go(left, mid)
        val b = go(mid + 1, right)
        merge(a, b, left, right)
      }
    }


    def merge(a: R, b: R, left: Int, right: Int): R = {
      val x = a.max max b.max max (a.rightMax * b.leftMax) max (a.rightMin * b.leftMin)
      var c = nums(left)
      var d = nums(left)
      var p = nums(left)
      var i = left + 1
      while (i <= right) {
        p *= nums(i)
        c = c max p
        d = d min p
        i += 1
      }
      var e = nums(right)
      var f = nums(right)
      p = nums(right)
      i = right - 1
      while (i >= left) {
        p *= nums(i)
        e = e max p
        f = f min p
        i -= 1
      }

      R(x, c, d, e, f)
    }


    go(0, nums.length - 1).max
  }

  case class R(max: Int, leftMax: Int, leftMin: Int, rightMax: Int, rightMin: Int)

}
