package set600.set650.p658

object Solution {
  def findClosestElements(arr: Array[Int], k: Int, x: Int): List[Int] = {
//    val n = arr.length
    val nums = arr.map(y => (x - y).abs).zipWithIndex.sortBy(_._1)
    val res = nums.take(k).map(y => y._2).sorted.map(arr(_))
    res.toList
  }
}
