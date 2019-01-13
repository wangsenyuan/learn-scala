package set200.set210.p218


object Solution {

  case class Pair(first: Int, second: Int)

  def getSkyline(buildings: Array[Array[Int]]): List[Array[Int]] = {
    val n = buildings.size

    val open = Array.fill[Pair](n)(null)
    val close = Array.fill[Pair](n)(null)
    var i = 0
    while (i < n) {
      open(i) = Pair(buildings(i)(0), buildings(i)(2))
      close(i) = Pair(buildings(i)(1), buildings(i)(2))
      i += 1
    }

    val os = open.sortBy(_.first)
    val cs = close.sortBy(_.first)

    val heights = new java.util.PriorityQueue[Int]((v1: Int, v2: Int) => v2 - v1)

    heights.add(0)

    var res = List.empty[Array[Int]]
    i = 0
    var j = 0
    var prev = 0
    while (j < n) {
      var x = 0
      if (i < n && os(i).first <= cs(j).first) {
        x = os(i).first
        heights.offer(os(i).second)
        i += 1
      } else {
        x = cs(j).first
        heights.remove(cs(j).second)
        j += 1
      }
      val maxHeight = heights.peek()
      if (prev != maxHeight) {
        res = Array(x, maxHeight) :: res
        prev = maxHeight
      }
    }


    res.reverse
  }
}
