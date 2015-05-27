package codejam.max.flow

import org.scalatest.FlatSpec

/**
 * Created by senyuanwang on 15/5/27.
 */
class GraphSpec extends FlatSpec {

  "find max flow in a single path graph" should "return the path capacity" in {
    val graph = new Graph(2)
    graph.addEdge(0, 1, 10)
    assert(graph.maxFlow(0, 1) == 10)
  }

  "find max flow in a normal graph" should "return max flow as 11" in {
    val graph = new Graph(5)
    graph.addEdge(0, 1, 10)
    graph.addEdge(0, 2, 2)
    graph.addEdge(1, 2, 6)
    graph.addEdge(1, 3, 6)
    graph.addEdge(3, 2, 3)
    graph.addEdge(3, 4, 8)
    graph.addEdge(2, 4, 5)
    assert(graph.maxFlow(0, 4) == 11)
  }
}
