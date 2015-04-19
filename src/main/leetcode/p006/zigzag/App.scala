package p006.zigzag

/**
 * Created by senyuanwang on 15/4/12.
 */
object App extends App {

  def zigZag(s: String, nRows: Int): String = {
    def go(i: Int, sbs: Array[StringBuilder], j: Int, delta: Int): String = {
      if (i >= s.length) {
        sbs.map(_.toString).mkString("")
      } else {
        val c = s.charAt(i)
        sbs(j).append(c)

        val nj = j + delta
        if (nj == nRows) {
          go(i + 1, sbs, 0 max nRows - 2, -1)
        } else if (nj < 0) {
          go(i + 1, sbs, 1 min nRows - 1, 1)
        } else {
          go(i + 1, sbs, nj, delta)
        }
      }
    }

    go(0, Array.fill(nRows)(new StringBuilder), 0, 1)
  }


  println(zigZag("AB", 1))

}
