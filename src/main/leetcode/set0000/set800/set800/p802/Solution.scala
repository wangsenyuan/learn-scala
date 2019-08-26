package set0000.set800.set800.p802

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution {
  def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
    val pq = mutable.PriorityQueue.empty[Node](Ordering.fromLessThan(compareNode))

    val n = graph.length

    val ins = Array.ofDim[ArrayBuffer[Int]](n)
    var i = 0
    while(i < n) {
      ins(i) = ArrayBuffer.empty[Int]
      i += 1
    }

    val degrees = Array.ofDim[Int](n)
    i = 0
    while(i < n) {
      val outs = graph(i)
      outs.foreach(j => {
        ins(j) += i
      })
      degrees(i) = outs.length
      pq.enqueue(Node(i, outs.length))
      i += 1
    }

    val vis = Array.ofDim[Boolean](n)

    val res = ArrayBuffer.empty[Int]

    while(!pq.isEmpty) {
      val Node(i, d) = pq.dequeue()
      if(!vis(i)) {
        vis(i) = true
        if(d == 0) {
          res += i

          ins(i).foreach(j => {
            degrees(j) -= 1
            pq.enqueue(Node(j, degrees(j)))
          })
        }
      }
    }

    val arr = res.toArray

    Sorting.quickSort(arr)

    arr.toList
  }

  case class Node(index: Int, degree: Int)

  private def compareNode(a: Node, b: Node): Boolean = {
    a.degree > b.degree
  }
}
