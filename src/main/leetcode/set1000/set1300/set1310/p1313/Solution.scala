package set1000.set1300.set1310.p1313

object Solution {
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
    nums.grouped(2).flatMap(arr => {
      val a = arr(0)
      val b = arr(1)
      Array.fill(a)(b)
    }).toArray
  }
}
