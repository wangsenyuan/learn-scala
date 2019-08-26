package set0000.set800.set870.p874

object Solution {
  def robotSim(commands: Array[Int], obstacles: Array[Array[Int]]): Int = {
    val points = obstacles.map(row => s"${row(0)}_${row(1)}").toSet

    var x = 0
    var y = 0
    var d = 0

    var best = 0

    commands.foreach(cmd => {
      cmd match {
        case -2 =>
          d = turnLeft(d)
        case -1 =>
          d = turnLeft(d)
          d = turnLeft(d)
          d = turnLeft(d)
        case z =>
          var done = false
          var m = z
          while (!done && m > 0) {
            val (u, v) = move(x, y, d)
            done = points.contains(s"${u}_${v}")
            if (!done) {
              x = u
              y = v
              best = best max (x * x + y * y)
            }
            m -= 1
          }
      }
    })
    best
  }

  private def turnLeft(x: Int): Int = {
    if (x == 0) {
      3
    } else {
      x - 1
    }
  }

  private def move(x: Int, y: Int, d: Int): (Int, Int) = {
    if (d == 0) {
      (x, y + 1)
    } else if (d == 1) {
      (x + 1, y)
    } else if (d == 2) {
      (x, y - 1)
    } else {
      (x - 1, y)
    }
  }
}
