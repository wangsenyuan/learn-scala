package set0000.set400.set420.p423

object Solution {
  def originalDigits(s: String): String = {
    val cnt = Array.ofDim[Int](26)
    s.foreach(c => cnt(c - 'a') += 1)

    val cnt2 = Array.ofDim[Int](10)
    if(cnt('g' - 'a') > 0) {
      cnt2(8) = cnt('g' - 'a')
      "eight".foreach(c => cnt(c - 'a') -= cnt2(8))
    }

    if(cnt('h' - 'a') > 0) {
      cnt2(3) = cnt('h' - 'a')
      "three".foreach(c => cnt(c - 'a') -= cnt2(3))
    }

    if(cnt('t' - 'a') > 0) {
      cnt2(2) = cnt('t' - 'a')
      "two".foreach(c => cnt(c - 'a') -= cnt2(2))
    }

    if(cnt('z' - 'a') > 0) {
      cnt2(0) = cnt('z' - 'a')
      "zero".foreach(c => cnt(c - 'a') -= cnt2(0))
    }

    if(cnt('r' - 'a') > 0) {
      cnt2(4) = cnt('r' - 'a')
      "four".foreach(c => cnt(c - 'a') -= cnt2(4))
    }

    if(cnt('f' - 'a') > 0) {
      cnt2(5) = cnt('f' - 'a')
      "five".foreach(c => cnt(c - 'a') -= cnt2(5))
    }

    if(cnt('x' - 'a') > 0) {
      cnt2(6) = cnt('x' - 'a')
      "six".foreach(c => cnt(c - 'a') -= cnt2(6))
    }

    if(cnt('s' - 'a') > 0) {
      cnt2(7) = cnt('s' - 'a')
      "seven".foreach(c => cnt(c - 'a') -= cnt2(7))
    }

    if(cnt('o' - 'a') > 0) {
      cnt2(1) = cnt('o' - 'a')
      "one".foreach(c => cnt(c - 'a') -= cnt2(1))
    }

    if(cnt('e' - 'a') > 0) {
      cnt2(9) = cnt('e' - 'a')
      "nine".foreach(c => cnt(c - 'a') -= cnt2(9))
    }

    val res = StringBuilder.newBuilder

    for {
      i <- 0 until 10
      if(cnt2(i) > 0)
    } {
      res.append(s"$i" * cnt2(i))
    }

    res.toString()
  }
}
