package codejam.year2016.round2.a

import scala.io.StdIn

/**
  * Created by wangsenyuan on 6/7/16.
  */
object Large extends App {

  def lose(win: Char): Char = {
    if (win == 'P') {
      'R'
    } else if (win == 'R') {
      'S'
    } else {
      'P'
    }
  }

  def construct(n: Int, win: Char): Vector[Char] = {
    if (n == 1) {
      Vector(win)
    } else {
      construct(n / 2, win) ++ construct(n / 2, lose(win))
    }
  }

  def before(a: Vector[Char], b: Vector[Char]): Boolean = {
    var i = 0
    var eq = true
    while (i < a.length && eq) {
      eq = a(i) == b(i)
      i += 1
    }

    eq || a(i - 1) < b(i - 1)
  }

  def sortLine(line: Vector[Char]): Vector[Char] = {
    if (line.length == 1) {
      line
    } else {
      val mid = line.length / 2
      val (a, b) = line.splitAt(mid)
      val c = sortLine(a)
      val d = sortLine(b)
      if (before(c, d)) {
        c ++ d
      } else {
        d ++ c
      }
    }
  }

  case class ValidCase(n: Int, p: Int, r: Int, s: Int) {
    var line: Vector[Char] = _

    def setLine(line: Vector[Char]) = this.line = line
  }

  object ValidCase {

    private def getSize(map: Map[Char, Vector[Char]], c: Char) = {
      map.get(c) match {
        case Some(l) => l.size
        case None => 0
      }
    }

    def apply(line: Vector[Char]): ValidCase = {
      val map = line.groupBy(identity)
      val p = getSize(map, 'P')
      val r = getSize(map, 'R')
      val s = getSize(map, 'S')
      val validCase = new ValidCase(line.length, p, r, s)
      validCase.setLine(sortLine(line))
      validCase
    }
  }

  val answers = (1 to Math.pow(2, 12).toInt).flatMap(n => List(construct(n, 'P'), construct(n, 'R'), construct(n, 'S'))).map(ValidCase.apply)

  def findAnswer(n: Int, p: Int, r: Int, s: Int): Option[Vector[Char]] = {
    val vs = answers.filter(x => x.n == n && x.p == p && x.r == r && x.s == s).map(_.line)
    val ss = vs.sortWith(before)
    if (ss.isEmpty) {
      None
    } else {
      Some(ss(0))
    }
  }

  val T = StdIn.readInt()

  for {
    t <- 1 to T
  } {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val r = line(1)
    val p = line(2)
    val s = line(3)

    val answer = findAnswer(Math.pow(2, n).toInt, p, r, s)
    if (answer.isEmpty) {
      println(s"Case #$t: IMPOSSIBLE")
    } else {
      println(s"Case #$t: ${answer.get.mkString("")}")
    }
  }
}
