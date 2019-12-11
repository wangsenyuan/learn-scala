package set1000.set1200.set1200.p1206

import scala.util.Random

class Skiplist() {
  val MAX_LEVEL = 31
  var level = 0

  val rand = new Random()

  val header = new Node(Int.MinValue)

  def search(target: Int): Boolean = {
    var current = header

    for {
      i <- level to 0 by -1
    } {
      while (current.forward(i) != null && current.forward(i).key < target) {
        current = current.forward(i)
      }
    }
    current = current.forward(0)

    current != null && current.key == target
  }

  def add(num: Int) {
    var current = header

    val update = Array.ofDim[Node](MAX_LEVEL)

    for {
      i <- level to 0 by -1
    } {
      while (current.forward(i) != null && current.forward(i).key < num) {
        current = current.forward(i)
      }
      update(i) = current
    }

    current = current.forward(0)

    if (current == null || current.key > num) {
      val rlevel = randomLevel()
      if (rlevel > level) {
        for {
          i <- level + 1 to rlevel
        } {
          update(i) = header
        }
        level = rlevel
      }
      val node = new Node(num)

      for {
        i <- 0 to rlevel
      } {
        node.changeForward(i, update(i).forward(i))
        update(i).changeForward(i, node)
      }
    } else {
      current.cnt += 1
    }
  }

  def erase(num: Int): Boolean = {
    var current = header
    val update = Array.ofDim[Node](MAX_LEVEL)

    for {
      i <- level to 0 by -1
    } {
      while (current.forward(i) != null && current.forward(i).key < num) {
        current = current.forward(i)
      }
      update(i) = current
    }

    current = current.forward(0)

    if (current != null && current.key == num) {
      current.cnt -= 1
      if (current.cnt == 0) {
        for {
          i <- 0 to level
          if update(i).forward(i) == current
        } {
          update(i).changeForward(i, current.forward(i))
        }

        while (level > 0 && header.forward(level) == null) {
          level -= 1
        }
      }
      true
    } else {
      false
    }
  }

  class Node(val key: Int, var cnt: Int = 1) {
    val fwd = Array.ofDim[Node](MAX_LEVEL)

    def forward(level: Int) = fwd(level)

    def changeForward(level: Int, next: Node) = {
      fwd(level) = next
    }
  }

  private def randomLevel() = {
    var lvl = 0
    var r = rand.nextFloat()
    while (r < 0.5 && lvl < MAX_LEVEL - 1) {
      lvl += 1
      r = rand.nextFloat()
    }
    lvl
  }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * var obj = new Skiplist()
 * var param_1 = obj.search(target)
 * obj.add(num)
 * var param_3 = obj.erase(num)
 */
