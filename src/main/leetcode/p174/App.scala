package p174

/**
 * Created by senyuanwang on 15/3/14.
 */
object App extends App {

  def calculateMinimumHP(dungeon: Array[Array[Int]]) = {
    var minSoFar = Int.MaxValue
    val n = dungeon.length
    def search(i: Int, j: Int, hpSoFar: Int, hp: Int, path: List[String]): Option[(Int, List[String])] =
      if (hp > minSoFar) None //this path will not work
      else {
        val x = dungeon(i)(j)
        val inc = if (x + hpSoFar > 0) 0 else -(x + hpSoFar) + 1
        val nHp = hp + inc
        val nHpSoFar = x + hpSoFar + inc

        val down = if (i == n - 1) None else search(i + 1, j, nHpSoFar, nHp, "DOWN" :: path)
        val right = if (j == n - 1) None else search(i, j + 1, nHpSoFar, nHp, "RIGHT" :: path)

        val result = (right, down) match {
          case (None, None) => Some(nHp, path)
          case (None, d) => d
          case (r, None) => r
          case (ro@Some(r), Some(d)) if (r._1 <= d._1) => ro
          case (Some(r), dOp@Some(d)) => dOp
        }
        minSoFar = result.get._1
        result
      }

    val result = search(0, 0, 0, 0, Nil)

    result
  }

  val testDungeon = Array(Array(-2, -3, 3), Array(-5, -10, 1), Array(10, 30, -5))

  val testResult = calculateMinimumHP(testDungeon)

  println(testResult)
}
