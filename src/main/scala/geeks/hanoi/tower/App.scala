package geeks.hanoi.tower

/**
 * Created by senyuanwang on 15/5/23.
 */
object App extends App {

  type MOVE = (Char, Char)

  val A = 'A'
  val B = 'B'
  val C = 'C'

  def playHanoiTower(n: Int): List[MOVE] = {
    require(n > 0)
    def move(from: Char, tmp: Char, to: Char, n: Int): List[MOVE] =
      if (n == 1) List((from, to))
      else {
        move(from, to, tmp, n - 1) ++ List((from, to)) ++ move(tmp, from, to, n - 1)
      }

    move(A, B, C, n)
  }

  println(playHanoiTower(3).map(x => x._1 + "->" + x._2).mkString("\n"))
  println
  println(playHanoiTower(6).map(x => x._1 + "->" + x._2).mkString("\n"))
}
