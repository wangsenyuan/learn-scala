package set0000.set700.set730.p739

object Solution {

  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
    val n = temperatures.length
    val res = Array.fill(n)(0)
    val stack = Array.fill(n)(0)
    var p = 0
    var i = 0
    while (i < n) {
      while (p > 0 && temperatures(stack(p - 1)) < temperatures(i)) {
        res(stack(p - 1)) = i - stack(p - 1)
        p -= 1
      }
      stack(p) = i
      p += 1
      i += 1
    }
    res
  }
}
