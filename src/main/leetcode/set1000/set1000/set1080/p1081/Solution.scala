package set1000.set1000.set1080.p1081

object Solution {
  def smallestSubsequence(text: String): String = {
    val pos = Array.ofDim[Int](26)

    val n = text.length
    for {
      i <- 0 until n
    } {
      pos(text(i) - 'a') = i
    }

    val occ = Array.ofDim[Boolean](26)
    val stack = Array.ofDim[Char](26)
    var p = 0
    for {
      i <- 0 until n
      if !occ(text(i) - 'a')
    } {
      while (p > 0 && stack(p - 1) > text(i) && pos(stack(p - 1) - 'a') > i) {
        occ(stack(p - 1) - 'a') = false
        p -= 1
      }
      occ(text(i) - 'a') = true
      stack(p) = text(i)
      p += 1
    }

    stack.take(p).mkString("")
  }
}
