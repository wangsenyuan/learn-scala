package set0000.set900.set910.p914

object Solution {
  def hasGroupsSizeX(deck: Array[Int]): Boolean = {
    val cnt = Array.ofDim[Int](10000)
    deck.foreach(x => cnt(x) += 1)

    var g = -1

    (0 until 10000).foreach(num => {
      if (cnt(num) > 0) {
        if (g < 0) {
          g = cnt(num)
        } else {
          g = gcd(g, cnt(num))
        }
      }
    })
    g >= 2
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }
}
