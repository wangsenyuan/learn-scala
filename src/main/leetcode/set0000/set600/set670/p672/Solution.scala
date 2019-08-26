package set0000.set600.set670.p672

object Solution {
  def flipLights(N: Int, m: Int): Int = {
    val n = N min 6

    val shift = 0 max (6 - N)
    val seen = Array.ofDim[Int](64)

    var cand = 0
    while (cand < 16) {
      val bitCount = Integer.bitCount(cand)

      if (bitCount % 2 == m % 2 && bitCount <= m) {
        var lights = 0

        if (((cand >> 0) & 1) > 0) {
          lights ^= (63 >> shift)
        }

        if (((cand >> 1) & 1) > 0) {
          lights ^= (21 >> shift)
        }

        if (((cand >> 2) & 1) > 0) {
          lights ^= (42 >> shift)
        }

        if (((cand >> 3) & 1) > 0) {
          lights ^= (36 >> shift)
        }
        seen(lights) = 1
      }

      cand += 1
    }

    seen.sum
  }


  def flipLights1(N: Int, m: Int): Int = {
    val n = N min 3
    if (m == 0) {
      1
    } else if (m == 1) {
      if (n == 1) {
        2
      } else if (n == 2) {
        3
      } else {
        4
      }
    } else if (m == 2) {
      if (n == 1) {
        2
      } else if (n == 2) {
        4
      } else {
        7
      }
    } else {
      if (n == 1) {
        2
      } else if (n == 2) {
        4
      } else {
        8
      }
    }
  }
}
