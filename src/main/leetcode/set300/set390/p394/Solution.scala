package set300.set390.p394

object Solution {
  def decodeString(s: String): String = {
    val n = s.length
    val nums = Array.ofDim[Int](n + 1)
    val pos = Array.ofDim[Int](n + 1)
    var p = 0
    val buf = new StringBuilder()

    var i = 0
    while(i < n) {
      if(s(i) == '[') {
        pos(p) = buf.length
        p += 1
      } else if(s(i).isDigit) {
        var num = 0
        while(s(i).isDigit) {
          num = num * 10 + (s(i) - '0')
          i += 1
        }
        nums(p) = num
        i -= 1
      } else if(s(i) == ']') {
        val x = pos(p-1)
        val y = nums(p-1)
        val z = buf.substring(x)
        buf.setLength(x)
        buf.append(z * y)
        p -= 1
      } else {
        buf.append(s(i))
      }

      i += 1
    }

    buf.toString()
  }
}
