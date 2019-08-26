package set0000.set800.set840.p841

object Solution {
  def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
    val n = rooms.length
    val vis = Array.ofDim[Boolean](n)
    val que = Array.ofDim[Int](n)
    var front = 0
    var end = 0
    vis(0) = true
    que(end) = 0
    end += 1

    val arr = rooms.toArray

    while (front < end) {
      val u = que(front)
      front += 1
      for {
        v <- arr(u)
        if !vis(v)
      } {
        vis(v) = true
        que(end) = v
        end += 1
      }
    }

    vis.forall(identity)
  }
}
