package set600.set680.p682

object Solution {
  def calPoints(ops: Array[String]): Int = {
    val n = ops.length
    val stack = Array.ofDim[String](n)
    var p = 0
    var res = 0
    var i = 0
    while(i < n) {
      if(ops(i) == "+") {
        val a = stack(p - 2).toInt
        val b = stack(p - 1).toInt
        val c = a + b
        res += c
        stack(p) = c.toString
        p += 1
      } else if(ops(i) == "C") {
        res -= stack(p-1).toInt
        p -= 1
      } else if(ops(i) == "D") {
        val a = stack(p - 1).toInt
        val b = a * 2
        res += b
        stack(p) = b.toString
        p += 1
      } else {
        res += ops(i).toInt
        stack(p) = ops(i)
        p += 1
      }

      i += 1
    }

    res
  }
}
