package set0000.set600.set650.p657

object Solution {
  def judgeCircle(moves: String): Boolean = {

    val pos = Array(0, 0)

    moves.foreach(x => move(x, pos))

    pos(0) == 0 && pos(1) == 0
  }

  private def move(x: Char, pos: Array[Int]): Unit = {
    if(x == 'U') {
      pos(1) += 1
    } else if(x == 'R') {
      pos(0) += 1
    } else if(x == 'D') {
      pos(1) -= 1
    } else if(x == 'L') {
      pos(0) -= 1
    }
  }
}
