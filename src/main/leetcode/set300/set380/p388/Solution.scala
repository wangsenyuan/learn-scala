package set300.set380.p388

object Solution {
  def lengthLongestPath(input: String): Int = {
    val n = input.length
    var i = 0
    val buf = new StringBuffer
    val stack = Array.ofDim[Int](n)
    var p = 0

    var best = 0

    while (i < n) {
      if (input(i) == '\n') {
        //go from first one
        p = 0
        i += 1
      } else if (input(i) == '\t') {
        p += 1
        i += 1
      } else {
        if (p > 0) {
          buf.setLength(stack(p - 1))
        } else {
          buf.setLength(0)
        }
        var j = i
        var isFile = false
        while (j < n && (input(j) != '\n' && input(j) != '\t')) {
          buf.append(input(j))
          isFile = isFile || input(j) == '.'
          j += 1
        }

        if (isFile) {
          best = best max buf.length()
        } else {
          buf.append("/")
        }
        stack(p) = buf.length()
        p += 1
        i = j
      }
    }

    best
  }
}
