package set0000.set200.set210.p210

object Solution {

  import scala.collection.mutable

  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    val out = Array.fill[mutable.Set[Int]](numCourses)(null)
    val in = Array.fill[mutable.Set[Int]](numCourses)(null)
    for {
      i <- 0 until numCourses
    } {
      out(i) = mutable.Set.empty[Int]
      in(i) = mutable.Set.empty[Int]
    }

    for {
      pre <- prerequisites
    } {
      val a = pre(0)
      val b = pre(1)
      out(b) += a
      in(a) += b
    }
    val visited = Array.fill(numCourses)(-1)
    var x = 0
    while (x < numCourses) {
      val cur = (0 until numCourses).find(i => visited(i) < 0 && in(i).isEmpty)
      cur match {
        case None => x = numCourses + 1
        case Some(u) =>
          visited(u) = x
          for {
            v <- out(u)
          } {
            in(v) -= u
          }
      }
      x += 1
    }

    if (visited.exists(_ < 0)) {
      Array()
    } else {
      val res = Array.fill(numCourses)(0)
      for {
        i <- 0 until numCourses
      } {
        res(visited(i)) = i
      }
      res
    }
  }
}
