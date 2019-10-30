package set1000.set1000.set1040.p1041

object Solution {
  def isRobotBounded(instructions: String): Boolean = {
    var x = 0
    var y = 0
    var d = 0

    var i = 0
    while (i < 4) {
      var j = 0
      while (j < instructions.length) {
        if (instructions(j) == 'G') {
          if (d == 0) {
            y += 1
          } else if (d == 1) {
            x += 1
          } else if (d == 2) {
            y -= 1
          } else {
            x -= 1
          }
        } else if (instructions(j) == 'L') {
          d = (d + 3) % 4
        } else {
          d = (d + 1) % 4
        }
        j += 1
      }

      i += 1
    }

    x == 0 && y == 0 && d == 0
  }
}
