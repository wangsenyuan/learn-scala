package set200.set200.p207


object Solution {

  import scala.collection.mutable

  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
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
    val visited = Array.fill(numCourses)(false)
    var x = 0
    while (x < numCourses) {
      val cur = (0 until numCourses).find(i => !visited(i) && in(i).isEmpty)
      cur match {
        case None => x = numCourses + 1
        case Some(u) =>
          visited(u) = true
          for {
            v <- out(u)
          } {
            in(v) -= u
          }
      }
      x += 1
    }

    x == numCourses
  }

  def canFinish1(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val graph = Array.fill[mutable.Set[Int]](numCourses)(null)

    for {
      i <- 0 until numCourses
    } {
      graph(i) = mutable.Set.empty[Int]
    }

    for {
      pre <- prerequisites
    } {
      val a = pre(0)
      val b = pre(1)
      graph(a) += b
    }

    val labels = Array.fill(numCourses)(0)

    def dfs(u: Int, label: Int): Boolean = {
      if (labels(u) == label) {
        false
      } else if (labels(u) > 0) {
        true
      } else {
        labels(u) = label
        graph(u).isEmpty || graph(u).forall(dfs(_, label))
      }
    }

    var label = 0
    var can = true
    var i = 0
    while (i < numCourses && can) {
      if (labels(i) == 0) {
        label += 1
        can = dfs(i, label)
      }
      i += 1
    }

    can
  }
}
