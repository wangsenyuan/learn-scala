package codejam.year2016.roundwomen.d

import scala.annotation.tailrec
import scala.io.StdIn
import scala.util.Random

/**
  * Created by wangsenyuan on 21/10/2016.
  */
object App {

  def main(args: Array[String]): Unit = {
    val T = StdIn.readInt
    var t = 1
    while (t <= T) {
      StdIn.readLine()
      val line = StdIn.readLine().split("\\s+")
      val ans = find(line.toSet)
      println(f"Case #$t: $ans")
      t += 1
    }
  }

  private def invalid(s: String): Boolean = {
    s.toSet.size < s.length
  }

  def find(secrets: Set[String]): String = {
    if (secrets.exists(_.size == 1)) {
      "IMPOSSIBLE"
    } else {
      doFind(secrets.filterNot(invalid))
    }
  }

  private def doFind(secrets: Set[String]): String = {
    val rand = new Random(41)
    val letters = ('A' to 'Z').toVector
    def sample(letters: Vector[Char], res: String): String = {
      if (letters.size == 0) {
        res
      } else {
        val i = rand.nextInt(letters.size)
        sample(letters.take(i) ++ letters.drop(i + 1), res + letters(i))
      }
    }

    def checkAnswer(ans: String): Boolean = {
      !secrets.exists(s => ans.contains(s))
    }

    val MAX_TRY = 10000

    @tailrec
    def go(i: Int): String = {
      if (i == MAX_TRY) {
        "IMPOSSIBLE"
      } else {
        val s = sample(letters, "")
        if (checkAnswer(s)) {
          s
        } else {
          go(i + 1)
        }
      }
    }
    go(0)
  }

}
