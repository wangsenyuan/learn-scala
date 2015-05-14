package codejam.year2015.qr

import codejam.FileOp

/**
 * Created by senyuanwang on 15/5/14.
 */
object D extends App with FileOp {
  override val filePrefix = "/Users/senyuanwang/IdeaProjects/ALG/src/main/scala/codejam/year2015/qr/D-large-practice";

  def process(x: Int, r: Int, c: Int): Boolean = {
    if ((r * c) % x != 0) true
    else if (x == 3 && r == 1) true
    else if (x == 4 && r <= 2) true
    else if (x == 5 && (r <= 2 || (r == 3 && c == 5))) true
    else if (x == 6 && r <= 3) true
    else if (x >= 7) true
    else false
  }

  val T = file.next().toInt

  for {
    t <- 1 to T
    line = file.next().split("\\s+").map(_.toInt)
    x = line(0)
    r = line(1)
    c = line(2)
  } {
    val rt = process(x, r min c, r max c)
    if(rt) {
      println(s"Case #$t: RICHARD");
    } else {
      println(s"Case #$t: GABRIEL");
    }
  }
}
