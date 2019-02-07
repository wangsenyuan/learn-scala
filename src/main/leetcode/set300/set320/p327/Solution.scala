package set300.set320.p327


object Solution {

  import scala.collection.mutable

  def countRangeSum(nums: Array[Int], lower: Int, upper: Int): Int = {
    val sums = mutable.Set.empty[Long]
    var sum = 0L
    nums.foreach(num => {
      sum += num
      sums += sum
    })
    val vs = sums.toArray.sorted
    val n = sums.size
    val cnt = Array.ofDim[Int](4 * n)
    val left = Array.fill(4 * n)(Long.MaxValue)
    val right = Array.fill(4 * n)(Long.MinValue)

    def initTree(i: Int, l: Int, r: Int): Unit = {
      if (l <= r) {
        left(i) = vs(l)
        right(i) = vs(r)
        if (l != r) {
          val mid = (l + r) / 2
          initTree(2 * i + 1, l, mid)
          initTree(2 * i + 2, mid + 1, r)
        }
      }
    }

    initTree(0, 0, n - 1)

    def update(i: Int, v: Long): Unit = {
      if (i < left.length && left(i) <= v && v <= right(i)) {
        cnt(i) += 1
        update(2 * i + 1, v)
        update(2 * i + 2, v)
      }
    }

    def count(i: Int, low: Long, up: Long): Int = {
      if (right(i) < low || left(i) > up) {
        0
      } else if (low <= left(i) && right(i) <= up) {
        cnt(i)
      } else {
        count(2 * i + 1, low, up) + count(2 * i + 2, low, up)
      }
    }

    var res = 0
    var i = nums.length - 1
    while (i >= 0) {
      update(0, sum)
      sum -= nums(i)
      res += count(0, sum + lower, sum + upper)
      i -= 1
    }
    res
  }

  def countRangeSum1(nums: Array[Int], lower: Int, upper: Int): Int = {
    val tree = new java.util.TreeMap[Long, Int]()

    tree.put(0, 1)
    var i = nums.length - 1
    var sum = 0L
    var res = 0
    while (i >= 0) {
      sum += nums(i)
      val wnd = tree.subMap(sum - upper, sum - lower + 1)
      val iter = wnd.values().iterator()
      while (iter.hasNext) {
        res += iter.next()
      }
      if (tree.containsKey(sum)) {
        tree.put(sum, tree.get(sum) + 1)
      } else {
        tree.put(sum, 1)
      }

      i -= 1
    }

    res
  }
}
