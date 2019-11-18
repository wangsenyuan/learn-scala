package set1000.set1100.set1120.p1122


object Solution {
  def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    val n = arr2.length
    val pos = arr2.zipWithIndex.toMap.withDefault(x => x + n)

    arr1.sortBy(pos)
  }
}
