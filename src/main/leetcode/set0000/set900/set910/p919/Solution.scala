package set0000.set900.set910.p919


object Solution {

  /**
   * Definition for a binary tree node.
   **/
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  class CBTInserter(_root: TreeNode) {

    import scala.collection.mutable.ListBuffer

    var root = _root
    val lastCompleteLevel = ListBuffer.empty[TreeNode]
    var cur = ListBuffer.empty[TreeNode]
    var size = 0
    var depth = 0
    var anchor = 0
    if (root != null) {
      lastCompleteLevel += root
      size += 1
      var done = false
      while (lastCompleteLevel.size > 0 && !done) {
        depth += 1
        var i = 0
        while (i < lastCompleteLevel.size) {
          val node = lastCompleteLevel(i)
          if (node.left != null) {
            cur += node.left
            size += 1
          }
          if (node.right != null) {
            cur += node.right
            size += 1
          }
          i += 1
        }

        val n = cur.size

        if (n == (1 << depth)) {
          lastCompleteLevel.clear()
          lastCompleteLevel ++= cur
          cur.clear()
          anchor += n / 2
        } else {
          done = true
        }
      }
    }


    def insert(v: Int): Int = {
      // root won't be null
      val p = (size - 1) >> 1
      val i = p - anchor

      val r = lastCompleteLevel(i)

      val node = new TreeNode(v)
      if (r.left == null) {
        r.left = node
      } else {
        r.right = node
      }

      cur += node
      size += 1

      val n = cur.size
      if (n == (1 << depth)) {
        lastCompleteLevel.clear()
        lastCompleteLevel ++= cur
        cur.clear()
        depth += 1
        anchor += n / 2
      }

      r.value
    }

    def get_root(): TreeNode = {
      root
    }

  }

  /**
   * Your CBTInserter object will be instantiated and called as such:
   * var obj = new CBTInserter(root)
   * var param_1 = obj.insert(v)
   * var param_2 = obj.get_root()
   */
}
