package codechef.easy.dishown

import scala.io.StdIn

/**
  * Created by wangsenyuan on 12/01/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val n = StdIn.readLine().trim.toInt

      val uf = new UF(n)

      val dishs = StdIn.readLine().split("\\s+").map(_.toInt)

      var q = StdIn.readLine().trim.toInt

      while (q > 0) {
        val ques = StdIn.readLine().split("\\s+").map(_.toInt)
        ques(0) match {
          case 0 =>
            val x = ques(1) - 1
            val y = ques(2) - 1

            if (uf.sameSet(x, y)) {
              println("Invalid query!")
            } else {
              val a = uf.find(x)
              val b = uf.find(y)
              if (dishs(a) > dishs(b)) {
                uf.union(a, b)
              } else if (dishs(a) < dishs(b)) {
                uf.union(b, a)
              }
            }
          case 1 =>
            val x = ques(1)
            println(uf.find(x - 1) + 1)
        }


        q -= 1
      }

      t -= 1
    }
  }

  class UF(val n: Int) {
    private val elems = (0 until n).toArray

    def find(a: Int): Int = {
      if (a != elems(a)) {
        elems(a) = find(elems(a))
      }
      elems(a)
    }

    def sameSet(a: Int, b: Int): Boolean = find(a) == find(b)

    def union(a: Int, b: Int): Unit = {
      elems(b) = a
    }
  }

}
