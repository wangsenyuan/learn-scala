package set0000.set300.set340.p349

/**
  * Created by wangsenyuan on 5/18/16.
  */
object Solution {

  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val set = nums1.toSet
    var set2 = Set.empty[Int]
    var res = List.empty[Int]
    nums2.foreach(x => {
      if (set.contains(x) && !set2.contains(x)) {
        res = x :: res
        set2 += x
      }
    })
    res.toArray
  }

  def main(args: Array[String]): Unit = {
    val nums1 = Array(9, 4, 5)
    val nums2 = Array(9, 8, 9, 4, 8)
    val result = intersection(nums1, nums2)
    println(result.mkString(" "))
  }
}
