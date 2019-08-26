package set0000.set400.set480.p483

object Solution {
  def smallestGoodBase(n: String): String = {
    val num = BigInt(n)

    var base = -1L
    var d = 63
    while(d > 0 && base < 0) {
      val res = find(num, d)

      val tmp = f(d, res)

      if(tmp == num) {
        base = res
      }

      d -= 1
    }

    base.toString
  }

  private def find(num: BigInt, d: Int): Long = {
    var left = BigInt(2)
    var right = num
    while(left < right) {
      val mid = left + (right - left) / 2
      val r = f(d, mid)
      if(r >= num) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right.toLong
  }

  private def f(d: Int, k: BigInt): BigInt = {
    val p = pow(k, d)
    (p - 1) / (k - 1)
  }

  private def pow(a: BigInt, b: Int): BigInt = {
    a.pow(b)
  }
}
