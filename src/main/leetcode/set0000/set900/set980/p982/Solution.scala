package set0000.set900.set980.p982

object Solution {
  def countTriplets(A: Array[Int]): Int = {
    val N = 1 << 16
    val dp = Array.ofDim[Int](N)
    val fp = Array.ofDim[Int](N)
    A.foreach(num => dp(num) += 1)

    for {
      _ <- 1 until 3
    } {
      (0 until N).foreach(x => fp(x) = 0)
      for {
        a <- A
        b <- 0 until N
      } {
        fp(a & b) += dp(b)
      }

      (0 until N).foreach(x => dp(x) = fp(x))
    }

    dp(0)
  }

  def countTriplets1(A: Array[Int]): Int = {
    val N = 1 << 16
    val cnt = Array.ofDim[Int](N)

    for {
      state <- 0 until N
      num <- A
      if (state & num) == num
    } {
      cnt(state) += 1
    }
    var res = 0
    val n = A.length

    for {
      i <- 0 until n
      j <- 0 until n
    } {
      val num = A(i) & A(j)
      res += cnt(~num & (N - 1))
    }

    res
  }

}
