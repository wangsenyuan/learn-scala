package set0000.set800.set890.p895


object Solution {

  class FreqStack() {

    import scala.collection.mutable

    case class Node(v: Int, f: Int, i: Int)

    private def compareNode(a: Node, b: Node): Boolean = {
      if (a.f < b.f) {
        true
      } else if (a.f == b.f) {
        a.i < b.i
      } else {
        false
      }
    }

    val pq = mutable.PriorityQueue[Node]()(Ordering.fromLessThan(compareNode))

    val freq = mutable.Map.empty[Int, Int]

    var index = 0


    def push(x: Int) {
      if (!freq.contains(x)) {
        freq += x -> 1
        pq.enqueue(Node(x, 1, index))
      } else {
        freq(x) = 1 + freq(x)
        pq.enqueue(Node(x, freq(x), index))
      }

      index += 1
    }

    def pop(): Int = {
      while (!pq.isEmpty) {
        val head = pq.dequeue()
        if (head.f == freq(head.v)) {
          if (head.f > 1) {
            freq(head.v) -= 1
          } else {
            freq -= head.v
          }
          return head.v
        }
      }

      -1
    }

  }

  /**
   * Your FreqStack object will be instantiated and called as such:
   * var obj = new FreqStack()
   * obj.push(x)
   * var param_2 = obj.pop()
   */
}
