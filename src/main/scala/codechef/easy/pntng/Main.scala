package codechef.easy.pntng

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/2/4.
  */
object Main {

  case class Layer(t: Long, c: Long)


  def paint(layers: Array[Layer], n: Long, m: Long): Option[Long] = {
    val area = n * m
    val sorted = layers.sortBy(_.c)

    def go(i: Int, cost: Long, cover: Long): Option[Long] = {
      if (i == sorted.length) {
        if (cover == area) {
          Some(cost)
        } else {
          None
        }
      } else {
        val t = sorted(i).t
        val c = sorted(i).c
        val left = area - cover
        val need = left min t
        go(i + 1, cost + c * need, cover + need)
      }
    }

    go(0, 0L, 0L)
  }

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+")
    val n = line(0).toLong
    val m = line(1).toLong
    val h = line(2).toInt
    val layers = Array.fill[Layer](h)(null)
    var i = 0
    while (i < h) {
      val lay = StdIn.readLine().split("\\s+").map(_.toLong)
      layers(i) = Layer(lay(0), lay(1))
      i += 1
    }

    paint(layers, n, m) match {
      case None => println("Impossible")
      case Some(x) => println(x)
    }
  }
}
