package codechef.easy.directi

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 22/12/2016.
  */
object Main {

  case class Pos(dir: String, road: String)

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      var n = StdIn.readInt()

      //var dir = ""

      var ps = List.empty[Pos]

      while (n > 0) {
        n -= 1
        val line = StdIn.readLine()

        if (line.startsWith("Begin")) {
          ps = Pos("", line.substring("Begin on ".length)) :: ps
        } else if (line.startsWith("Left")) {
          ps = Pos("Left", line.substring("Left on ".length)) :: ps
        } else {
          ps = Pos("Right", line.substring("Right on ".length)) :: ps
        }
      }

      val bk = back(ps)

      println(bk.mkString("\n"))

      println()
    }
  }

  def oppositeDir(dir: String) = dir match {
    case "Left" => "Right"
    case "Right" => "Left"
    case _ => ""
  }

  def back(ps: List[Pos]): List[String] = {
    @tailrec
    def go(dir: String, ps: List[Pos], path: List[String]): List[String] = {
      ps match {
        case p :: tail =>
          if (dir.isEmpty) {
            go(oppositeDir(p.dir), tail, s"Begin on ${p.road}" :: path)
          } else {
            go(oppositeDir(p.dir), tail, s"${dir} on ${p.road}" :: path)
          }
        case Nil => path.reverse
      }
    }

    go("", ps, Nil)
  }
}
