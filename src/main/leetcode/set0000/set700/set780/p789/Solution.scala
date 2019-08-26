package set0000.set700.set780.p789

object Solution {
  def escapeGhosts(ghosts: Array[Array[Int]], target: Array[Int]): Boolean = {
    val a = target(0)
    val b = target(1)

    def calcDist(ghost: Array[Int]): Int = {
      val c = ghost(0)
      val d = ghost(1)
      (a - c).abs + (b - d).abs
    }

    val dd = a.abs + b.abs
    ghosts.forall(calcDist(_) > dd)
  }
}
