package set1000.set1200.set1220.p1223

object Solution {

  val MOD = 1000000007

  def modAdd(a: Int, b: Int): Int = {
    val c = a + b
    if (c >= MOD) {
      c - MOD
    } else {
      c
    }
  }

  def dieSimulator(n: Int, rollMax: Array[Int]): Int = {
    val dp = Array.ofDim[Int](17, 6)

    (0 until 6).foreach(j => dp(1)(j) = 1)

    var i = 2
    while (i <= n) {
      var j = 0
      while (j < 6) {
        var k = 1
        var sum = 0

        while (k <= rollMax(j) && i > k) {
          val ii = (i - k) % 17
          var u = 0
          while (u < 6) {
            if (u != j) {
              sum = modAdd(dp(ii)(u), sum)
            }
            u += 1
          }
          k += 1
        }

        if (k <= rollMax(j) && i == k) {
          sum = modAdd(sum, 1)
        }

        dp(i % 17)(j) = sum

        j += 1
      }


      i += 1
    }

    dp(n % 17).reduce(modAdd)
  }
}
