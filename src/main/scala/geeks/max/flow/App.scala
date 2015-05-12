package geeks.max.flow

import scala.io.Source

/**
 * Created by senyuanwang on 15/5/3.
 */
object App extends App {
  val file = Source.fromFile("/Users/senyuanwang/IdeaProjects/ALG/src/main/scala/geeks/max/flow/test-a.txt").getLines()
  val firstLine = file.next().split("\\s+")
  val n = firstLine(0).toInt
  val m = firstLine(1).toInt

  val graph = new Graph(n)

  for {
    _ <- 0 until m
    line = file.next().split("\\s+").map(_.toInt)
    v = line(0)
    w = line(1)
    c = line(2)
  } {
    graph.addEdge(v, w, c)
  }

  val maxFlow = graph.maxFlow(n, 0, 4)

  println(maxFlow)
}
