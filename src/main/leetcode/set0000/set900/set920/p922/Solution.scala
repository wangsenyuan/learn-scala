package set0000.set900.set920.p922

object Solution {
  def sortArrayByParityII(A: Array[Int]): Array[Int] = {
    val (evens, odds) = A.partition(num => (num & 1) == 0)

    evens.zip(odds).flatMap(x => Array(x._1, x._2))
  }
}
