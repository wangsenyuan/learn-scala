package codejam.year2016.round1a.b

import scala.io.StdIn

/**
  * Created by wangsenyuan on 4/28/16.
  */
object App extends App {

  def play(lists: Vector[Array[Int]], n: Int): Array[Int] = {
    val counts = lists.flatMap(l => l).foldLeft(Map[Int, Int]()) {
      (map, x) =>
        map.get(x) match {
          case None => map + (x -> 1)
          case Some(y) => map + (x -> (y + 1))
        }
    }

    val list = counts.filter(p => p._2 % 2 == 1).map(p => p._1)
    list.toArray.sorted
  }


  var T = StdIn.readLine().toInt

  for {
    i <- 1 to T
  } {
    val n = StdIn.readLine().toInt
    var rows = Vector[Array[Int]]()
    for {
      j <- 0 until 2 * n - 1
    } {
      val line = StdIn.readLine()
      val row = line.split("\\s+").map(_.toInt)
      rows = row +: rows
    }
    val missColumn = play(rows, n)
    println(s"Case #$i: ${missColumn.mkString(" ")}")
  }
}
