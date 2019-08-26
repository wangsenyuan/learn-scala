package set0000.set800.set840.p842

object Solution {
  def splitIntoFibonacci(S: String): List[Int] = {

    def dfs(a: Long, b: Long, left: String): List[Long] = {
      val c = a + b
      if (c > Int.MaxValue) {
        Nil
      } else {
        val s = c.toString
        if (!left.startsWith(s)) {
          Nil
        } else if (left == s) {
          c :: Nil
        } else {
          val sub = dfs(b, c, left.substring(s.length))
          if (sub.isEmpty) {
            Nil
          } else {
            c :: sub
          }
        }
      }
    }

    if (S.length < 3) {
      return Nil
    }
    if (S(0) == '0') {

      if (S(1) == '0') {
        val res = dfs(0, 0, S.substring(2))
        if (res.isEmpty) {
          return Nil
        } else {
          return (0L :: 0L :: res).map(_.toInt)
        }
      }

      var i = 2

      while (i < S.length) {
        val b = S.substring(1, i).toLong
        if (b > Int.MaxValue) {
          return Nil
        }
        val res = dfs(0, b, S.substring(i))

        if (!res.isEmpty) {
          return (0L :: b :: res).map(_.toInt)
        }

        i += 1
      }
      return Nil
    }

    var i = 1
    while (i < S.length) {
      val a = S.substring(0, i).toLong
      if (a > Int.MaxValue) {
        return Nil
      }

      var j = i + 1
      while (j < S.length && S.substring(i, j).toLong < Int.MaxValue) {
        val b = S.substring(i, j).toLong
        val res = dfs(a, b, S.substring(j))
        if (!res.isEmpty) {
          return (a :: b :: res).map(_.toInt)
        }

        j += 1
      }

      i += 1
    }

    Nil
  }
}
