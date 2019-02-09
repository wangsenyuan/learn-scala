package set300.set330.p333

/**
  * Created by senyuanwang on 16/2/13.
  */
object App extends App {

  def largestBSTSubtree(root: TreeNode): Int = {
    val result = visit(root)
    return result.res.abs
  }

  case class Result(res: Int, min: Int, max: Int)

  def visit(root: TreeNode): Result = {
    if (root == null) {
      Result(0, Int.MaxValue, Int.MinValue)
    } else {
      val left = visit(root.left)
      val right = visit(root.right)

      if (left.res < 0 || right.res < 0 || root.`val` < left.max || root.`val` > right.min) {
        Result(-1 * (left.res.abs max right.res.abs), 0, 0)
      } else {
        Result(left.res + 1 + right.res, root.`val` min left.min, root.`val` max right.max)
      }
    }
  }
}
