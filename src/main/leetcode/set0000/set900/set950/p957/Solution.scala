package set0000.set900.set950.p957

object Solution {
  def prisonAfterNDays(cells: Array[Int], N: Int): Array[Int] = {
    val back = Array.ofDim[Int](8)
    val M = 1 << 8
    val seen = Array.fill(M)(-1)
    var index = 0
    while (seen(toBit(cells)) < 0 && index < N) {
      seen(toBit(cells)) = index
      index += 1
      simulate(cells, back)
    }

    if (index == N) {
      // just small enough to simulate
      cells
    } else {
      // index < N
      val j = seen(toBit(cells))
      val d = index - j
      // j -> ... -> index -> j
      var r = (N - j) % d
      while (r > 0) {
        simulate(cells, back)
        r -= 1
      }
      cells
    }
  }

  private def toBit(cells: Array[Int]): Int = {
    (0 until cells.length).foldLeft(0)((r, i) => {
      if (cells(i) == 0) {
        r
      } else {
        r | (1 << i)
      }
    })
  }

  private def simulate(cells: Array[Int], back: Array[Int]): Unit = {
    var i = 0
    while (i < cells.length) {
      if (i == 0 || i == cells.length - 1) {
        // two ends
        back(i) = 0
      } else if (cells(i - 1) == cells(i + 1)) {
        back(i) = 1
      } else {
        back(i) = 0
      }
      i += 1
    }

    (0 until 8).foreach(i => cells(i) = back(i))
  }
}
