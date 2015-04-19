package poj.p3276

/**
 * Created by senyuanwang on 15/4/19.
 */
object A extends App {

  def solve(dirs: Array[Int], k: Int): Int = {
    val n = dirs.length
    val fs = Array.fill(n)(0)

    def flip(idx: Int, res: Int, sum: Int): Int =
      if (idx >= n) {
        res
      } else if (idx + k <= n) {
        val dir = dirs(idx)
        fs(idx) = if (sum + dir % 2 == 1) 1 else 0
        flip(idx + 1, res + fs(idx), sum + fs(idx) - (if (idx - k + 1 >= 0) fs(idx - k + 1) else 0))
      } else if (dirs(idx) + sum % 2 == 1) {
        flip(n, -1, 0)
      } else {
        flip(idx + 1, res, sum - (if (idx - k + 1 >= 0) fs(idx - k + 1) else 0))
      }

    flip(0, 0, 0)
  }

  def solve(dirs: Array[String]): (Int, Int) = {
    val converted = dirs.map(dir => if (dir == "F") 0 else 1)
    val n = dirs.length

    (1 to n).foldLeft((1, n)) {
      case ((k, m), i) =>
        val nm = solve(converted, i)
        if (nm >= 0 && nm < m) {
          (i, nm)
        } else {
          (k, m)
        }
    }
  }

  println(solve(Array("B", "B", "F", "B", "F", "B", "B")))

}
