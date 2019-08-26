package set0000.set300.set330.p331

object Solution {
  def isValidSerialization(preorder: String): Boolean = {
    if (preorder.isEmpty) {
      true
    } else {
      val nodes = preorder.split(",")
      val n = nodes.length
      var i = n - 1
      var can = true
      var nulls = 0
      while (i >= 0 && can) {
        if (nodes(i) == "#") {
          nulls += 1
        } else if (nulls < 2) {
          can = false
        } else {
          nulls -= 1
        }
        i -= 1
      }
      can && nulls == 1
    }
  }

  def isValidSerialization1(preorder: String): Boolean = {
    if (preorder.isEmpty) {
      true
    } else {
      val nodes = preorder.split(",")
      val n = nodes.length
      if (n == 1) {
        nodes(0) == "#"
      } else {
        val stack = Array.fill(n)(-1)
        val childrenCount = Array.fill(n)(0)

        def pop(p: Int): Int = {
          if (p == 0 || childrenCount(stack(p - 1)) != 2) {
            p
          } else {
            pop(p - 1)
          }
        }

        def go(i: Int, p: Int): Boolean = {
          if (i == n) {
            pop(p) == 0
          } else if (p == 0 || p == n) {
            false
          } else {
            val j = stack(p - 1)
            childrenCount(j) += 1
            if (nodes(j) == "#" || childrenCount(j) > 2) {
              false
            } else nodes(i) match {
              case "#" =>
                go(i + 1, pop(p))
              case _ =>
                stack(p) = i
                //should go left
                go(i + 1, p + 1)
            }
          }
        }

        stack(0) = 0
        go(1, 1)
      }
    }
  }
}
