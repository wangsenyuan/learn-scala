package p339.nested.list.weight.sum

/**
  * Created by wangsenyuan on 3/31/16.
  */
object App {
  def depthSum(nestedList: List[NestedInteger]): Int = {

    def go(nestedList: List[NestedInteger], depth: Int, sum: Int): Int =
      nestedList match {
        case Nil => sum
        case _ =>
          val newSum = sum + nestedList.filter(_.isInteger).map(_.getInteger * depth).sum
          go(nestedList.filterNot(_.isInteger), depth + 1, newSum)
      }

    go(nestedList, 1, 0)
  }
}
