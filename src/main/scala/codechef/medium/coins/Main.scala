package codechef.medium.coins

object Main {

  def main(args: Array[String]): Unit = {
    val cache = Array.fill(1000000)(-1L)

    def go(n: Int): Long = {
      if (n < 12) {
        n
      } else if (n == 12) {
        13
      } else if (n < 1000000 && cache(n) > 0) {
        cache(n)
      } else {
        val a = go(n / 2)
        val b = go(n / 3)
        val c = go(n / 4)
        if (n < 1000000) {
          cache(n) = a + b + c
        }

        a + b + c
      }
    }

    for (ln <- io.Source.stdin.getLines) {
      val n = ln.toInt
      println(go(n))
    }
  }
}
