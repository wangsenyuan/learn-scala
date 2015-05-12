package codejam.year2015.qr

import codejam.FileOp

/**
 * Created by senyuanwang on 15/5/6.
 */
object C extends App with FileOp {

  override val filePrefix = "/Users/senyuanwang/IdeaProjects/ALG/src/main/scala/codejam/year2015/qr/C-large-practice"

  val matrix = Array(
    Array(0, 0, 0, 0, 0),
    Array(0, 1, 2, 3, 4),
    Array(0, 2, -1, 4, -3),
    Array(0, 3, -4, -1, 2),
    Array(0, 4, 3, -2, -1)
  )

  def mul(i: Int, j: Int) = {
    val sign = if (i * j > 0) 1 else -1
    sign * matrix(i.abs)(j.abs)
  }

  def power(a: Int, n: Long): Int = {
    (0L until (n % 4)).foldLeft(1) {
      (res, _) =>
        mul(res, a)
    }
  }

  def multiplyAll(s: Array[Int], l: Int, m: Long) = {
    var res = 1
    for {
      j <- 0 until l
    } {
      res = mul(res, s(j))
    }
    power(res, m) == -1
  }

  def constructFirstSecond(s: Array[Int], l: Int, m: Long) = {

    def construct(target: Int, i: Int, res: Int): Option[Int] = {
      if (res == target) Some(i)
      else if (i == l * m) None
      else {
        val a = i % l
        construct(target, i + 1, mul(res, s(a)))
      }
    }

    construct(2, 0, 1).flatMap(construct(3, _, 1)) match {
      case Some(_) => true
      case None => false
    }
  }

  def process(s: String, l: Int, m: Long) = {
    val array = (s.map {
      case 'i' => 2
      case 'j' => 3
      case 'k' => 4
    }).toArray

    multiplyAll(array, l, m) && constructFirstSecond(array, l, 8L min m)
  }

  val T = file.next().toInt

  for {
    t <- 1 to T
  } {
    val firstLine = file.next().split("\\s+")
    val line = file.next()

    if (process(line, firstLine(0).toInt, firstLine(1).toLong)) {
      println(s"Case #$t: YES")
    } else {
      println(s"Case #$t: NO")
    }
  }
}
