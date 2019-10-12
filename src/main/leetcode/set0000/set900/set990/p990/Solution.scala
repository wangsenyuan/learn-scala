package set0000.set900.set990.p990

object Solution {
  def equationsPossible(equations: Array[String]): Boolean = {
    val conn = Array.ofDim[Boolean](26, 26)

    for {
      equ <- equations
      if equ.contains("==")
    } {
      val a = equ(0) - 'a'
      val b = equ(3) - 'a'
      conn(a)(b) = true
      conn(b)(a) = true
    }


    val colors = Array.ofDim[Int](26)

    def dfs(x: Int, col: Int): Unit = {
      colors(x) = col
      for {
        i <- 0 until 26
        if colors(i) == 0 && conn(x)(i)
      } {
        dfs(i, col)
      }
    }

    var c = 0
    for {
      i <- 0 until 26
      if colors(i) == 0
    } {
      c += 1
      dfs(i, c)
    }

    for {
      equ <- equations
      if equ.contains("!=")
    } {
      val a = equ(0) - 'a'
      val b = equ(3) - 'a'
      if (colors(a) == colors(b)) {
        return false
      }
    }

    true
  }
}
