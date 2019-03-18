package set400.set440.p443

object Solution {
  def compress(chars: Array[Char]): Int = {
    val n = chars.length
    var i = 1
    var j = 0
    var u = 0

    while (i <= n) {
      if (i == n || chars(i) != chars(i - 1)) {
        val l = i - j
        chars(u) = chars(i - 1)
        u += 1
        if (l > 1) {
          val nums = s"$l"
          for {
            k <- 0 until nums.length
          } {
            chars(u + k) = nums(k)
          }
          u += nums.length
        }
        j = i
      }

      i += 1
    }
    u
  }
}
