package set0000.set200.set220.p223

object Solution {

  case class Rect(a: Int, b: Int, c: Int, d: Int)

  private def area(a: Int, b: Int, c: Int, d: Int) = {
    (c - a) * (d - b)
  }

  def computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int = {
    val one = Rect(A, B, C, D)
    val two = Rect(E, F, G, H)

    def intersect(x: Rect, y: Rect): Int = {
      if (x.c <= y.a) {
        0
      } else if (y.c <= x.a) {
        0
      } else if (x.d <= y.b) {
        0
      } else if (y.d <= x.b) {
        0
      } else {
        val a = x.a max y.a
        val b = x.b max y.b
        val c = x.c min y.c
        val d = x.d min y.d
        area(a, b, c, d)
      }
    }

    area(A, B, C, D) + area(E, F, G, H) - intersect(one, two)
  }
}
