package set100.set170.p174

/**
  * Created by senyuanwang on 15/3/14.
  */
object Solution extends App {

  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = {
    val m = dungeon.length
    val n = dungeon(0).length
    val dp = Array.ofDim[Int](m, n)

    for {
      i <- m - 1 to 0 by -1
      j <- n - 1 to 0 by -1
    } {
      if (i < m - 1 && j < n - 1) {
        dp(i)(j) = (dp(i + 1)(j) min dp(i)(j + 1)) - dungeon(i)(j)
      } else if (i < m - 1) {
        dp(i)(j) = dp(i + 1)(j) - dungeon(i)(j)
      } else if (j < n - 1) {
        dp(i)(j) = dp(i)(j + 1) - dungeon(i)(j)
      } else if (dungeon(i)(j) > 0) {
        dp(i)(j) = 1
      } else {
        dp(i)(j) = 1 - dungeon(i)(j)
      }

      if (dp(i)(j) <= 0) {
        dp(i)(j) = 1
      }
    }

    dp(0)(0)
  }

  def calculateMinimumHP1(dungeon: Array[Array[Int]]): Int = {
    val m = dungeon.length
    val n = dungeon(0).length

    val dp = Array.ofDim[Int](m, n)

    def check(hp: Int): Boolean = {
      if (hp + dungeon(0)(0) <= 0) {
        false
      } else {
        dp(m - 1)(n - 1) = 0

        for {
          i <- 0 until m
          j <- 0 until n
        } {
          if (i > 0 && j > 0) {
            dp(i)(j) = dp(i - 1)(j) max dp(i)(j - 1)
          } else if (i > 0) {
            dp(i)(j) = dp(i - 1)(j)
          } else if (j > 0) {
            dp(i)(j) = dp(i)(j - 1)
          } else {
            dp(i)(j) = hp
          }

          dp(i)(j) += dungeon(i)(j)

          if (dp(i)(j) <= 0) {
            //dead end
            dp(i)(j) = Int.MinValue >> 1
          }
        }

        dp(m - 1)(n - 1) > 0
      }
    }

    var left = 1
    var right = Int.MaxValue >> 1
    while (left < right) {
      val mid = left + (right - left) / 2
      if (check(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }

    left
  }

  val testDungeon = Array(Array(-2, -3, 3), Array(-5, -10, 1), Array(10, 30, -5))

  val testResult = calculateMinimumHP(testDungeon)

  println(testResult)
}
