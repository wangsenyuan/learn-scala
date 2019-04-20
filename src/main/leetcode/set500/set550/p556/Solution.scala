package set500.set550.p556

object Solution {
  def nextGreaterElement(n: Int): Int = {
    val digits = Array.ofDim[Int](12)

    def swap(i: Int, j: Int): Unit = {
      digits(i) = digits(i) ^ digits(j)
      digits(j) = digits(i) ^ digits(j)
      digits(i) = digits(i) ^ digits(j)
    }

    var i = 0
    var num = n
    while (num > 0) {
      digits(i) = num % 10
      i += 1
      num /= 10
    }

    var j = 1
    while (j < i && digits(j - 1) <= digits(j)) {
      j += 1
    }
    if (j == i) {
      -1
    } else {
      //digits(j - 1) > digits(j)
      var k = 0
      while (digits(k) <= digits(j)) {
        k += 1
      }

      // digits(k) > digits(j)
      swap(k, j)
      // swap [0...j-1]
      j -= 1
      k = 0
      while (k < j) {
        swap(k, j)
        k += 1
        j -= 1
      }
      var res = 0L
      i -= 1
      while (i >= 0) {
        res = res * 10 + digits(i)
        i -= 1
      }
      if (res > Int.MaxValue) {
        -1
      } else {
        res.toInt
      }
    }
  }
}
