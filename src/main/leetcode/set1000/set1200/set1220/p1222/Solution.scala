package set1000.set1200.set1220.p1222

import scala.collection.mutable.ListBuffer

object Solution {
  def queensAttacktheKing(queens: Array[Array[Int]], king: Array[Int]): List[List[Int]] = {
    val isQueue = Array.ofDim[Boolean](8, 8)
    queens.foreach(que => isQueue(que(0))(que(1)) = true)

    val buf = ListBuffer.empty[List[Int]]

    var x = king(0)

    while (x >= 0 && !isQueue(x)(king(1))) {
      x -= 1
    }

    if (x >= 0) {
      buf += List(x, king(1))
    }

    x = king(0)

    while (x < 8 && !isQueue(x)(king(1))) {
      x += 1
    }

    if (x < 8) {
      buf += List(x, king(1))
    }

    var y = king(1)

    while (y >= 0 && !isQueue(king(0))(y)) {
      y -= 1
    }

    if (y >= 0) {
      buf += List(king(0), y)
    }

    y = king(1)

    while (y < 8 && !isQueue(king(0))(y)) {
      y += 1
    }

    if (y < 8) {
      buf += List(king(0), y)
    }

    x = king(0)
    y = king(1)

    while (x >= 0 && y >= 0 && !isQueue(x)(y)) {
      x -= 1
      y -= 1
    }

    if (x >= 0 && y >= 0) {
      buf += List(x, y)
    }

    x = king(0)
    y = king(1)

    while (x >= 0 && y < 8 && !isQueue(x)(y)) {
      x -= 1
      y += 1
    }

    if (x >= 0 && y < 8) {
      buf += List(x, y)
    }

    x = king(0)
    y = king(1)

    while (x < 8 && y < 8 && !isQueue(x)(y)) {
      x += 1
      y += 1
    }

    if (x < 8 && y < 8) {
      buf += List(x, y)
    }

    x = king(0)
    y = king(1)

    while (x < 8 && y >= 0 && !isQueue(x)(y)) {
      x += 1
      y -= 1
    }

    if (x < 8 && y >= 0) {
      buf += List(x, y)
    }

    buf.toList
  }
}
